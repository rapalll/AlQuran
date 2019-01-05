package com.grack.rapalll.al_quran.model;

import com.google.gson.annotations.SerializedName;


public class AyahsItem {

    @SerializedName("number")
    private int number;

    @SerializedName("hizbQuarter")
    private int hizbQuarter;

    @SerializedName("ruku")
    private int ruku;

    @SerializedName("manzil")
    private int manzil;

    @SerializedName("text")
    private String text;

    @SerializedName("page")
    private int page;

    @SerializedName("numberInSurah")
    private int numberInSurah;

    @SerializedName("juz")
    private int juz;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getHizbQuarter() {
        return hizbQuarter;
    }

    public void setHizbQuarter(int hizbQuarter) {
        this.hizbQuarter = hizbQuarter;
    }

    public int getRuku() {
        return ruku;
    }

    public void setRuku(int ruku) {
        this.ruku = ruku;
    }

    public int getManzil() {
        return manzil;
    }

    public void setManzil(int manzil) {
        this.manzil = manzil;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getNumberInSurah() {
        return numberInSurah;
    }

    public void setNumberInSurah(int numberInSurah) {
        this.numberInSurah = numberInSurah;
    }

    public int getJuz() {
        return juz;
    }

    public void setJuz(int juz) {
        this.juz = juz;
    }

    @Override
    public String toString() {
        return
                "AyahsItem{" +
                        "number = '" + number + '\'' +
                        ",hizbQuarter = '" + hizbQuarter + '\'' +
                        ",ruku = '" + ruku + '\'' +
                        ",manzil = '" + manzil + '\'' +
                        ",text = '" + text + '\'' +
                        ",page = '" + page + '\'' +
                        ",numberInSurah = '" + numberInSurah + '\'' +
                        ",juz = '" + juz + '\'' +
                        "}";
    }
}