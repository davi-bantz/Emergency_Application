package com.example.emergencyapplication.Rescuer_Registration;

public class ReadWriteService {

    public String Orgname, OrgRole, OrgAddress, Skills;

    public  ReadWriteService(){

    }
    public ReadWriteService (String textOrgName, String textOrgRole, String textOrgAddress, String textSKills){
        this.Orgname =  textOrgName;
        this.OrgRole = textOrgRole;
        this.OrgAddress = textOrgAddress;
        this.Skills = textSKills;
    }

    public String getOrgname() {
        return Orgname;
    }

    public void setOrgname(String orgname) {
        Orgname = orgname;
    }

    public String getOrgRole() {
        return OrgRole;
    }

    public void setOrgRole(String orgRole) {
        OrgRole = orgRole;
    }

    public String getOrgAddress() {
        return OrgAddress;
    }

    public void setOrgAddress(String orgAddress) {
        OrgAddress = orgAddress;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) {
        Skills = skills;
    }
}
