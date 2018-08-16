package com.myactivityone.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jvs group on 6/17/2017.
 */

public class GiphyResponceImages {


    @SerializedName("title")
    private String title;

    @SerializedName("images")
    private GridImages images;


    public GiphyResponceImages(String title, GridImages images) {
        this.title = title;
        this.images = images;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GridImages getImages() {
        return images;
    }

    public void setImages(GridImages images) {
        this.images = images;
    }
}
