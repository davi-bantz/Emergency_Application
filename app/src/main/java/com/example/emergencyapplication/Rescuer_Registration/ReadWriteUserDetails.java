package com.example.emergencyapplication.Rescuer_Registration;

public class ReadWriteUserDetails {
    public String  dob, Phone, name, email ;


    public ReadWriteUserDetails(){

    }

    public ReadWriteUserDetails(String textdob, String textPhoneNumber, String textName, String textEmail){
        this.dob = textdob;
        this.Phone = textPhoneNumber;
        this.name = textName;
        this.email = textEmail;

    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
