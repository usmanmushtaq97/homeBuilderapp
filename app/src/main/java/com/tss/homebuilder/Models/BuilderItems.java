package com.tss.homebuilder.Models;

public class BuilderItems {
  int bid;
  String bname,bstartdate,bWeburl,baddress,bPhone,Brating;
  int bNo_of_employee;
  String bImageUrl;
  int bVerifiyStatus;

  public BuilderItems(int bid, String bname, String bstartdate, String bWeburl, String baddress, String bPhone, String brating, int bNo_of_employee, String bImageUrl, int bVerifiyStatus) {
    this.bid = bid;
    this.bname = bname;
    this.bstartdate = bstartdate;
    this.bWeburl = bWeburl;
    this.baddress = baddress;
    this.bPhone = bPhone;
    Brating = brating;
    this.bNo_of_employee = bNo_of_employee;
    this.bImageUrl = bImageUrl;
    this.bVerifiyStatus = bVerifiyStatus;
  }

  public int getBid() {
    return bid;
  }

  public void setBid(int bid) {
    this.bid = bid;
  }

  public String getBname() {
    return bname;
  }

  public void setBname(String bname) {
    this.bname = bname;
  }

  public String getBstartdate() {
    return bstartdate;
  }

  public void setBstartdate(String bstartdate) {
    this.bstartdate = bstartdate;
  }

  public String getbWeburl() {
    return bWeburl;
  }

  public void setbWeburl(String bWeburl) {
    this.bWeburl = bWeburl;
  }

  public String getBaddress() {
    return baddress;
  }

  public void setBaddress(String baddress) {
    this.baddress = baddress;
  }

  public String getbPhone() {
    return bPhone;
  }

  public void setbPhone(String bPhone) {
    this.bPhone = bPhone;
  }

  public String getBrating() {
    return Brating;
  }

  public void setBrating(String brating) {
    Brating = brating;
  }

  public int getbNo_of_employee() {
    return bNo_of_employee;
  }

  public void setbNo_of_employee(int bNo_of_employee) {
    this.bNo_of_employee = bNo_of_employee;
  }

  public String getbImageUrl() {
    return bImageUrl;
  }

  public void setbImageUrl(String bImageUrl) {
    this.bImageUrl = bImageUrl;
  }

  public int getbVerifiyStatus() {
    return bVerifiyStatus;
  }

  public void setbVerifiyStatus(int bVerifiyStatus) {
    this.bVerifiyStatus = bVerifiyStatus;
  }
}
