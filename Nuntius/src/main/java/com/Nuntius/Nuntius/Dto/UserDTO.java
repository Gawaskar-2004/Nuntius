package com.Nuntius.Nuntius.Dto;

import lombok.Data;

@Data
public class UserDTO {
    private int user_id;
    private String name;
    private String email;
    private long phone_no;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public long getPhone_no() {
        return phone_no;
    }
    public void setPhone_no(long phone_no) {
        this.phone_no = phone_no;
    }
}
