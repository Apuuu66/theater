package com.ttms;

import com.google.gson.Gson;
import org.junit.Test;

public class TestJson {
    @Test
    public void aa() {
        Gson gson = new Gson();
        int i = gson.fromJson("100", int.class);              //100
        double d = gson.fromJson("\"99.99\"", double.class);  //99.99
        boolean b = gson.fromJson("true", boolean.class);     // true
        String str = gson.fromJson("String", String.class);   // String
        System.out.println(i);
        System.out.println(d);
        System.out.println(b);
        System.out.println(str);
    }

    @org.junit.Test
    public void bb() {
        Gson gson = new Gson();
//        User user = new User("怪盗kidou", 24);
//        String jsonObject = gson.toJson(user); // {"name":"怪盗kidou","age":24}
//        System.out.println(jsonObject);
//        String jsonString = "{\"name\":\"怪盗kidou\",\"age\":24}";
//        User user1 = gson.fromJson(jsonString, User.class);
        String json = "{\"name\":\"怪盗kidou\",\"age\":24,\"emailAddress\":\"ikidou@example.com\"}";
        User user = gson.fromJson(json,User.class);
        System.out.println(user);
        String s = gson.toJson(user);
        System.out.println(s);
    }
}
