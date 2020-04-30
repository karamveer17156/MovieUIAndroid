package com.example.myapplication;

public class Address {
    int _addr_id;
    String address, postal,phone;

    public int get_addr_id() {
        return _addr_id;
    }

    public void set_addr_id(int _addr_id) {
        this._addr_id = _addr_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address(int id, String addr, String postal_code, String ph){
        this._addr_id = id;
        this.address = addr;
        this.postal = postal_code;
        this.phone = ph;
    }
}
