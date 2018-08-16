package com.myactivityone.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jk on 8/14/2018.
 */

public  class VideoPath implements Parcelable {

    @SerializedName("mp4")
    private String mp4;

    public String getVideoUrl() {
        return mp4;
    }

    public void setVideoUrl(String mp4) {
        this.mp4 = mp4;
    }


    public VideoPath() {
    }

    private VideoPath(Parcel in) {
        this.mp4 = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(mp4);
    }

    public static final Parcelable.Creator<VideoPath> CREATOR = new Parcelable.Creator<VideoPath>() {

        @Override
        public VideoPath createFromParcel(Parcel source) {
            return new VideoPath(source);
        }

        @Override
        public VideoPath[] newArray(int size) {
            return new VideoPath[size];
        }
    };
}
