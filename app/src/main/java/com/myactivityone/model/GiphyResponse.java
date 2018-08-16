package com.myactivityone.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by jvs group on 6/17/2017.
 */

public class GiphyResponse {

    @SerializedName("data")
    private List<GiphyResponceImages> data;

    public List<GiphyResponceImages> getData() {
        return data;
    }

    public void setData(List<GiphyResponceImages> results) {
        this.data = results;
    }
}
