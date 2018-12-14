package com.grack.rapalll.al_quran.api;

import com.grack.rapalll.al_quran.model.Surah;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

  @GET("surah")
  Call<Surah> getAllsurah();
}
