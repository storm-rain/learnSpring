package com.protostuff.ccc;

import java.util.List;

public class User
{
    private String name;
    private int age;

    private List list;


    public User()
    {

    }
    public User(String name, int age, List list)
    {
        this.name = name;
        this.age = age;
        this.list = list;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void addAddress(String address)
    {
        list.add(address);
    }

    public String getAddress(int i)
    {
        return (String) list.get(i);
    }
}
