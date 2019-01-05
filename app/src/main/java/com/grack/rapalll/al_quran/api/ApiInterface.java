package com.grack.rapalll.al_quran.api;

import com.grack.rapalll.al_quran.model.QuranResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {


//  @GET("surah")
//  Call<Surah> getArabicSurah();
//
//  @GET("/quran/arabic")
//  Call<QuranArabResponse> getQuranArabic();
//
//  @GET("/quran/id.indonesian")
//  Call<QuranResponse> getQuranIndo();

  @GET("surah")
  Call<QuranResponse> getAllSurah();

  @GET("surah/{number}/editions/quran-uthmani,id.muntakhab")
  Call<QuranResponse> getDetailAyat(@Path("number") String number);
}
