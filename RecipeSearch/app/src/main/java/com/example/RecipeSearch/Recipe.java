package com.example.RecipeSearch;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Data;

@Data
    public class Recipe implements Parcelable {
        private String RCP_NM;
        private String RCP_PARTS_DTLS;
        private int INFO_CAR;
        private int INFO_NA;
        private int INFO_FAT;
        private int INFO_PRO;
        private String MANUAL01;
        private String MANUAL02;
        private String MANUAL03;
        private String MANUAL04;
        private String MANUAL05;
        private String MANUAL06;
        private String MANUAL07;
        private String MANUAL08;
        private String MANUAL09;
        private String MANUAL10;
        private String MANUAL11;
        private String MANUAL12;
        private String MANUAL13;
        private String MANUAL14;
        private String MANUAL15;
        private String MANUAL16;
        private String MANUAL17;
        private String MANUAL18;
        private String MANUAL19;
        private String MANUAL20;

    protected Recipe(Parcel in) {
        RCP_NM = in.readString();
        RCP_PARTS_DTLS = in.readString();
        INFO_CAR = in.readInt();
        INFO_NA = in.readInt();
        INFO_FAT = in.readInt();
        INFO_PRO = in.readInt();
        MANUAL01 = in.readString();
        MANUAL02 = in.readString();
        MANUAL03 = in.readString();
        MANUAL04 = in.readString();
        MANUAL05 = in.readString();
        MANUAL06 = in.readString();
        MANUAL07 = in.readString();
        MANUAL08 = in.readString();
        MANUAL09 = in.readString();
        MANUAL10 = in.readString();
        MANUAL11 = in.readString();
        MANUAL12 = in.readString();
        MANUAL13 = in.readString();
        MANUAL14 = in.readString();
        MANUAL15 = in.readString();
        MANUAL16 = in.readString();
        MANUAL17 = in.readString();
        MANUAL18 = in.readString();
        MANUAL19 = in.readString();
        MANUAL20 = in.readString();
    }

    public static final Creator<Recipe> CREATOR = new Creator<Recipe>() {
        @Override
        public Recipe createFromParcel(Parcel in) {
            return new Recipe(in);
        }

        @Override
        public Recipe[] newArray(int size) {
            return new Recipe[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(RCP_NM);
        dest.writeString(RCP_PARTS_DTLS);
        dest.writeInt(INFO_CAR);
        dest.writeInt(INFO_NA);
        dest.writeInt(INFO_FAT);
        dest.writeInt(INFO_PRO);
        dest.writeString(MANUAL01);
        dest.writeString(MANUAL02);
        dest.writeString(MANUAL03);
        dest.writeString(MANUAL04);
        dest.writeString(MANUAL05);
        dest.writeString(MANUAL06);
        dest.writeString(MANUAL07);
        dest.writeString(MANUAL08);
        dest.writeString(MANUAL09);
        dest.writeString(MANUAL10);
        dest.writeString(MANUAL11);
        dest.writeString(MANUAL12);
        dest.writeString(MANUAL13);
        dest.writeString(MANUAL14);
        dest.writeString(MANUAL15);
        dest.writeString(MANUAL16);
        dest.writeString(MANUAL17);
        dest.writeString(MANUAL18);
        dest.writeString(MANUAL19);
        dest.writeString(MANUAL20);
    }
}

