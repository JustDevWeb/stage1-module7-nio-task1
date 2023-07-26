package com.epam.mjc.nio;

import java.util.Objects;

public class ProfileDataParser {
    private String name = null;
    private String email = null;
    private String phone = null;
    private String age = null;

    public ProfileDataParser(String data) {
        this.parseData(data);
    }

    public void parseData(String data) {
        String[] arrayData = data.split(System.lineSeparator());

        for (int i = 0; i < arrayData.length; i++) {
            String[] values = arrayData[i].split(":");
            String key = values[0];
            String value = values[1].trim();

            if (Objects.equals(key, "Name")) {
                name = value;
            } else if (Objects.equals(key, "Age")) {
                this.age = value;
            } else if (Objects.equals(key, "Email")) {
                this.email = value;
            } else if (Objects.equals(key, "Phone")) {
                this.phone = value;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return Integer.parseInt(age);
    }

    public Long getPhone() {
        return Long.parseLong(phone);
    }

    public String getEmail() {
        return email;
    }
}
    
