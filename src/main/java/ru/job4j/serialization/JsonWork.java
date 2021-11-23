package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class JsonWork {
    public static void main(String[] args) {
        final Student student = new Student(1212, "Ivanov", false,
                new Scooter("M1", 40), new String[]{"songs", "swimming"});
        final Gson gson = new GsonBuilder().create();
        final String strJson = gson.toJson(student);
        System.out.println(strJson);
        final String str =
                "{"
                        + "\"id\":1212,"
                        + "\"surname\":\"Ivanov\","
                        + "\"job\":false,"
                        + "\"scooter\":"
                        + "{"
                        + "\"model\":\"M1\","
                        + "\"speed\":40"
                        + "},"
                        + "\"hobbies\":"
                        + "[\"songs\",\"swimming\"]"
                        + "}";
        final Student studentMod = gson.fromJson(str, Student.class);
        System.out.println(studentMod);

        JSONObject jsonScooter = new JSONObject("{\"model\":\"M1\",\"speed\":40}");

        List<String> list = new ArrayList<>();
        list.add("songs");
        list.add("swimming");
        JSONArray jsonHobbies = new JSONArray(list);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", student.getId());
        jsonObject.put("surname", student.getSurname());
        jsonObject.put("job", student.isJob());
        jsonObject.put("scooter", jsonScooter);
        jsonObject.put("hobbies", jsonHobbies);

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(student).toString());
    }
}
