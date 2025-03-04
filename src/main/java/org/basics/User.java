package org.basics;

public class User {

    private Integer id;
    private String first;
    private String last;
    private int age;
    private String email;

    public User () {
    }

    public User (Integer id, String first, String last, int age, String email) {
        this.id = id;
        this.first = first;
        this.last = last;
        this.age = age;
        this.email = email;
    }

    public Integer getId () {
        return this.id;
    }

    public void setId (Integer id) {
        this.id = id;
    }

    public String getFirst () {
        return this.first;
    }

    public void setFirst (String first) {
        this.first = first;
    }

    public String getLast () {
        return this.last;
    }

    public void setLast (String last) {
        this.last = last;
    }

    public int getAge () {
        return this.age;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public String getEmail () {
        return this.email;
    }

    public void setEmail (String email) {
        this.email = email;
    }

    @Override
    public String toString () {
        return "User{" + "id=" + this.id + ", first='" + this.first + '\'' + ", last='" + this.last + '\'' + ", age=" + this.age + ", email='" + this.email + '\'' + '}';
    }
}
