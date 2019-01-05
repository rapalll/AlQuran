package com.grack.rapalll.al_quran.model.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class IndonesiaResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<DataItem> data;

    @SerializedName("status")
    private String status;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return
                "IndonesiaResponse{" +
                        "code = '" + code + '\'' +
                        ",data = '" + data + '\'' +
                        ",status = '" + status + '\'' +
                        "}";
    }
}