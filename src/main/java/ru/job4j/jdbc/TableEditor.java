package ru.job4j.jdbc;

import java.io.*;
import java.sql.*;
import java.util.*;

public class TableEditor implements AutoCloseable {
    private Connection connection;
    private Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException, SQLException {
        final String url = this.properties.getProperty("hibernate.connection.url");
        final String login = this.properties.getProperty("hibernate.connection.username");
        final String password = this.properties.getProperty("hibernate.connection.password");
        final String driver = this.properties.getProperty("hibernate.connection.driver_class");
        Class.forName(driver);
        connection = DriverManager.getConnection(url, login, password);
    }

    private void executeStatement(String sql, String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            if (!sql.contains("drop table")) {
                System.out.println(getTableScheme(connection, tableName));
            }
        }
    }

    public void createTable(String tableName) throws Exception {
        final String sql = String.format("create table if not exists %s ();", tableName);
        executeStatement(sql, tableName);
    }

    public void dropTable(String tableName) throws Exception {
        final String sql = String.format("drop table %s;", tableName);
        executeStatement(sql, tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        final String sql = String.format("alter table %s add %s %s;", tableName, columnName, type);
        executeStatement(sql, tableName);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        final String sql = String.format("alter table %s drop column %s;", tableName, columnName);
        executeStatement(sql, tableName);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName)
            throws Exception {
        final String sql = String.format("alter table %s rename column %s to %s;",
                tableName, columnName, newColumnName);
        executeStatement(sql, tableName);
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        try (BufferedReader in = new BufferedReader(new FileReader("app.properties"))) {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TableEditor editor = new TableEditor(properties);
        String tableName = "demo_table2";
        String columnName = "email";
        String newColumnName = "street_address";
        String type = "varchar(255)";
        editor.createTable(tableName);
        editor.addColumn(tableName, columnName, type);
        editor.renameColumn(tableName, columnName, newColumnName);
        editor.dropColumn(tableName, newColumnName);
        editor.dropTable(tableName);
        editor.close();
    }
}