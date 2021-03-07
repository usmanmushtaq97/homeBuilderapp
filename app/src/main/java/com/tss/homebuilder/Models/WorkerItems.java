package com.tss.homebuilder.Models;

public class WorkerItems {
    int wId;
    String wName;
    String wtypeofemployee,wAdress,wRatings,wAge,wImageUrl;
    int whourlyrate;

    public WorkerItems(int wId, String wName, String wtypeofemployee, String wAdress, String wRatings, String wAge, String wImageUrl, int whourlyrate) {
        this.wId = wId;
        this.wName = wName;
        this.wtypeofemployee = wtypeofemployee;
        this.wAdress = wAdress;
        this.wRatings = wRatings;
        this.wAge = wAge;
        this.wImageUrl = wImageUrl;
        this.whourlyrate = whourlyrate;
    }

    public int getwId() {
        return wId;
    }

    public void setwId(int wId) {
        this.wId = wId;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getWtypeofemployee() {
        return wtypeofemployee;
    }

    public void setWtypeofemployee(String wtypeofemployee) {
        this.wtypeofemployee = wtypeofemployee;
    }

    public String getwAdress() {
        return wAdress;
    }

    public void setwAdress(String wAdress) {
        this.wAdress = wAdress;
    }

    public String getwRatings() {
        return wRatings;
    }

    public void setwRatings(String wRatings) {
        this.wRatings = wRatings;
    }

    public String getwAge() {
        return wAge;
    }

    public void setwAge(String wAge) {
        this.wAge = wAge;
    }

    public String getwImageUrl() {
        return wImageUrl;
    }

    public void setwImageUrl(String wImageUrl) {
        this.wImageUrl = wImageUrl;
    }

    public int getWhourlyrate() {
        return whourlyrate;
    }

    public void setWhourlyrate(int whourlyrate) {
        this.whourlyrate = whourlyrate;
    }
}
