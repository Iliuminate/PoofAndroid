package com.dev.iliuminate.structures;

import java.io.Serializable;

/**
 * Created by Iliuminate on 04/07/2015.
 */
@SuppressWarnings("serial")
public class Pending implements Serializable {

    long item, value, total, phone;
    String user_name, direction;


    public Pending() {
    }

    public Pending(long item, long value, long total, long phone, String user_name, String direction) {
        this.item = item;
        this.value = value;
        this.total = total;
        this.phone = phone;
        this.user_name = user_name;
        this.direction = direction;
    }

    public long getItem() {
        return item;
    }

    public void setItem(long item) {
        this.item = item;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
}
