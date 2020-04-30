package com.example.myapplication;

public class User {
    String first_name, last_name, email, timestamp;
    int _add_id, _user_id;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int get_add_id() {
        return _add_id;
    }

    public void set_add_id(int _add_id) {
        this._add_id = _add_id;
    }

    public int get_user_id() {
        return _user_id;
    }

    public void set_user_id(int _user_id) {
        this._user_id = _user_id;
    }

    public User(String fname, String lname, String mail, String timestamp, int uid, int aid ){
        this.first_name = fname;
        this.last_name = lname;
        this.email = mail;
        this.timestamp = timestamp;
        this._user_id = uid;
        this._add_id = aid;
    }
}
