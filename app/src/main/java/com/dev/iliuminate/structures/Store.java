package com.dev.iliuminate.structures;

/**
 * Created by Iliuminate on 05/07/2015.
 */
public class Store {

    private Integer idstore;
    private String name;
    private String phone;
    private String category;
    private String type;
    private String address;
    private String email;
    private String latitude;
    private String longitude;


    public Store() {
    }

    public Store(Integer idstore, String name, String phone, String category, String type, String address, String email, String latitude, String longitude) {
        this.idstore = idstore;
        this.name = name;
        this.phone = phone;
        this.category = category;
        this.type = type;
        this.address = address;
        this.email = email;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getIdstore() {
        return idstore;
    }

    public void setIdstore(Integer idstore) {
        this.idstore = idstore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
