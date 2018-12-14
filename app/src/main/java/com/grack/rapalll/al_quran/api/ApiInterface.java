package com.grack.rapalll.al_quran.api;

import com.grack.rapalll.al_quran.model.DataItem;

import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("/surah")
    Call<List<DataItem>> getAllsurah();
}
