package ru.job4j.ood.srp;

public class Good {
    private String name;
    private boolean expireDate;

    public Good(String name, boolean isExpireDate) {
        this.name = name;
        this.expireDate = isExpireDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isExpireDate() {
        return expireDate;
    }

    public void setExpireDate(boolean expireDate) {
        this.expireDate = expireDate;
    }
}
