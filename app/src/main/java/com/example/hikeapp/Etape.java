package com.example.hikeapp;

import android.os.Parcel;
import android.os.Parcelable;

public class Etape implements Parcelable {


    private String pat;
    private int num;
    private String image;
    private String code;
    private int status;

    public Etape(String pat, int num,String image, String code,int status){
        this.pat=pat;
        this.num=num;
        this.image=image;
        this.code=code;
        this.status=status;
    }

    public String getPat() {
        return pat;
    }

    public int getNum() {
        return num;
    }

    public String getImage() {
        return image;
    }

    public String getCode() {
        return code;
    }

    public int getStatus() {
        return status;
    }

    public void setPat(String pat) {
        this.pat = pat;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Etape(Parcel in){
        String[] data = new String[5];

        in.readStringArray(data);
        // the order needs to be the same as in writeToParcel() method
        this.pat = data[0];
        this.num = Integer.parseInt(data[1]);
        this.image = data[2];
        this.code = data[3];
        this.status= Integer.parseInt(data[4]);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {this.pat, ""+this.num, this.image, this.code, ""+this.status});
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Etape createFromParcel(Parcel in) {
            return new Etape(in);
        }

        public Etape[] newArray(int size) {
            return new Etape[size];
        }
    };
}
