package com.myactivityone.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jk on 8/14/2018.
 */

public class ImagePath implements Parcelable {

    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public ImagePath() {
    }

    private ImagePath(Parcel in) {
        this.url = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(url);
    }

    public static final Parcelable.Creator<ImagePath> CREATOR = new Parcelable.Creator<ImagePath>() {

        @Override
        public ImagePath createFromParcel(Parcel source) {
            return new ImagePath(source);
        }

        @Override
        public ImagePath[] newArray(int size) {
            return new ImagePath[size];
        }
    };
}
