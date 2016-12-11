package ru.alibek;

import java.util.*;


public class User {
    String name;
    User(String name) throws Exception {
        validateName(name);
        this.setName(name);
    }
    User() {

    }

    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public boolean isMe(String name) {
        return this.name.equals(name);
    }
    public void validateName(String name) throws Exception {
        char ch = 'e' ;
        if( Character.isDigit(name.charAt(0)) ) {
            throw new Exception();
        }
    }




}
