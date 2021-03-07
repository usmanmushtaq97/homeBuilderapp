package com.tss.homebuilder.Models;

public class RatingsModels {
    int id;
    String titlePerson, ImageUrl,ReviewComments;
    int RatingsValue;
    public RatingsModels(int id, String titlePerson, String imageUrl, String reviewComments, int ratingsValue) {
        this.id = id;
        this.titlePerson = titlePerson;
        ImageUrl = imageUrl;
        ReviewComments = reviewComments;
        RatingsValue = ratingsValue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitlePerson() {
        return titlePerson;
    }

    public void setTitlePerson(String titlePerson) {
        this.titlePerson = titlePerson;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getReviewComments() {
        return ReviewComments;
    }

    public void setReviewComments(String reviewComments) {
        ReviewComments = reviewComments;
    }

    public int getRatingsValue() {
        return RatingsValue;
    }

    public void setRatingsValue(int ratingsValue) {
        RatingsValue = ratingsValue;
    }
}
