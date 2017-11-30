package com.wongel.test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tseringwongelgurung on 11/29/17.
 */

public class JsonTest {
    public List<Student> getList() {
        List<Student> list = new ArrayList<>();
        String json = getJson();

        try {
            JSONArray array = new JSONArray(json);

            for (int i = 0; i < array.length(); i++) {
                JSONObject object = (JSONObject) array.get(i);

                String name = object.getString("name");
                String address = object.getString("address");
                int roll = object.getInt("roll");
                Student student = new Student(name, roll, address);
                list.add(student);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public String getJson() {
        return "[{\n" +
                "\t\"name\": \"Arjun Gurung12\",\n" +
                "\t\"roll\": 123,\n" +
                "\t\"address\": \"Swoyamnbhu\"\n" +
                "}, {\n" +
                "\t\"name\": \"Arjun Gurung234\",\n" +
                "\t\"roll\": 123,\n" +
                "\t\"address\": \"Swoyamnbhu\"\n" +
                "}, {\n" +
                "\t\"name\": \"Arjun Gurung35\",\n" +
                "\t\"roll\": 123,\n" +
                "\t\"address\": \"Swoyamnbhu23424\"\n" +
                "}, {\n" +
                "\t\"name\": \"Arjun Gurung35635\",\n" +
                "\t\"roll\": 123,\n" +
                "\t\"address\": \"Swoyamnbhu\"\n" +
                "}, {\n" +
                "\t\"name\": \"Arjun Gurung34534534543\",\n" +
                "\t\"roll\": 123,\n" +
                "\t\"address\": \"Swoyamnbhu\"\n" +
                "}]";
    }
}
