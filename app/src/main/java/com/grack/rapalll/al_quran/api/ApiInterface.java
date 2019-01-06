package com.grack.rapalll.al_quran.api;

import com.grack.rapalll.al_quran.model.QuranResponse;

import com.grack.rapalll.al_quran.model.models.IndonesiaResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {
  @GET("surah")
  Call<QuranResponse> getAllSurah();

  @GET("surah/{number}/editions/quran-uthmani,id.indonesian")
  Call<IndonesiaResponse> getDetailAyat(@Path("number") String number);
}
