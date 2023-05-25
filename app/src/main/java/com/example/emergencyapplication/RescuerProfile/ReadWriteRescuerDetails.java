package com.example.emergencyapplication.RescuerProfile;

public class ReadWriteRescuerDetails {

    public String  phone, dob, org, role, orgaddress, basicSkill;

    public ReadWriteRescuerDetails(String data, String dataEmail, String dataDOB, String dataPhoneNumber, String dataOrgName, String dataOrgRole, String dataOrgAddress, String databasicSkill) {

    }
    public ReadWriteRescuerDetails(String dataPhoneNumber, String dataDOB, String dataOrgName, String dataRole, String dataOrgAddress, String databasicSkill) {
        this.dob = dataDOB;
        this.phone = dataPhoneNumber;
        this.org = dataOrgName;
        this.role = dataRole;
        this.orgaddress = dataOrgAddress;
        this.basicSkill = databasicSkill;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getOrgaddress() {
        return orgaddress;
    }

    public void setOrgaddress(String orgaddress) {
        this.orgaddress = orgaddress;
    }

    public String getBasicSkill() {
        return basicSkill;
    }

    public void setBasicSkill(String basicSkill) {
        this.basicSkill = basicSkill;
    }



}
