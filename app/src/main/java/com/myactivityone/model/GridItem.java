package com.myactivityone.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jk on 8/14/2018.
 */

public class GridItem implements Parcelable {

    String video_tital;
    String video_image;
    String video_url;
    int count;

    public String getVideo_tital() {
        return video_tital;
    }

    public void setVideo_tital(String video_tital) {
        this.video_tital = video_tital;
    }

    public String getVideo_image() {
        return video_image;
    }

    public void setVideo_image(String video_image) {
        this.video_image = video_image;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public GridItem() {
    }

    private GridItem(Parcel in) {
        this.video_tital = in.readString();
        this.video_image = in.readString();
        this.video_url = in.readString();
        this.count= in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(video_tital);
        dest.writeString(video_image);
        dest.writeString(video_url);
        dest.writeInt(count);
    }

    public static final Parcelable.Creator<GridItem> CREATOR = new Parcelable.Creator<GridItem>() {

        @Override
        public GridItem createFromParcel(Parcel source) {
            return new GridItem(source);
        }

        @Override
        public GridItem[] newArray(int size) {
            return new GridItem[size];
        }
    };
}
