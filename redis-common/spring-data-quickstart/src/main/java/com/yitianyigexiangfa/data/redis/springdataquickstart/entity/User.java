package com.yitianyigexiangfa.data.redis.springdataquickstart.entity;

import java.io.Serializable;

/**
 * @author Bill Lau
 * @date 2018-04-18
 */
public class User implements Serializable {

    private String id;
    private String name;

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
