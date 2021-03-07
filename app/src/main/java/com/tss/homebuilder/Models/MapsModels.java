package com.tss.homebuilder.Models;

public class MapsModels {
    int mid;
    String mtitle, mdescription, mapurl;
    public MapsModels(int mid, String mtitle, String mdescription, String mapurl) {
        this.mid = mid;
        this.mtitle = mtitle;
        this.mdescription = mdescription;
        this.mapurl = mapurl;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMtitle() {
        return mtitle;
    }

    public void setMtitle(String mtitle) {
        this.mtitle = mtitle;
    }

    public String getMdescription() {
        return mdescription;
    }

    public void setMdescription(String mdescription) {
        this.mdescription = mdescription;
    }

    public String getMapurl() {
        return mapurl;
    }

    public void setMapurl(String mapurl) {
        this.mapurl = mapurl;
    }
}
