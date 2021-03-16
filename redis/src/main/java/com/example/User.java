package com.example;

/**
 * @author: podigua
 * @create: 2021-03-16 23:12
 **/

public class User {
    private String id;
    private String name;
    public User(){

    }
    public User(String id,String name){
        this.id=id;
        this.name=name;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
