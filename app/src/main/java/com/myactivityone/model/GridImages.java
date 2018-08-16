package com.myactivityone.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jk on 8/14/2018.
 */

public class GridImages {

    @SerializedName("original_mp4")
    private VideoPath videopath;

    @SerializedName("480w_still")
    private ImagePath imagepath;

    public VideoPath getVideopath() {
        return videopath;
    }

    public void setVideopath(VideoPath videopath) {
        this.videopath = videopath;
    }

    public ImagePath getImagepath() {
        return imagepath;
    }

    public void setImagepath(ImagePath imagepath) {
        this.imagepath = imagepath;
    }
}
