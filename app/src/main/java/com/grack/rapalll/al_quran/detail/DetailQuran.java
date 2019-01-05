package com.grack.rapalll.al_quran.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import com.grack.rapalll.al_quran.R;
import com.grack.rapalll.al_quran.adapter.DetailAdapter;
import com.grack.rapalll.al_quran.api.ApiInterface;
import com.grack.rapalll.al_quran.api.Apiclient;
import com.grack.rapalll.al_quran.model.models.IndonesiaResponse;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailQuran extends AppCompatActivity {

  private static final String TAG = "Pesan Saya";
  Toolbar toolbar;
  int id;
  private RecyclerView recyclerView;
  private List<com.grack.rapalll.al_quran.model.models.AyahsItem> detailAyah;
  private DetailAdapter detailAdapter;
  private DetailAdapter detailAdapterA;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail_quran);
    toolbar = findViewById(R.id.toolbar);
    recyclerView = findViewById(R.id.detailAyat);
    id = getIntent().getIntExtra("detailAyah", 0);
    setupList();
    loadData();
  }

  private void setupList() {
    detailAdapter = new DetailAdapter(this, detailAyah, detailAyah);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
  }

  private void loadData() {
    final ApiInterface apiInterface = Apiclient.getRetrofit().create(ApiInterface.class);
    Call<IndonesiaResponse> call = apiInterface.getDetailAyat(String.valueOf(id));
    call.enqueue(new Callback<IndonesiaResponse>() {
      @Override
      public void onResponse(Call<IndonesiaResponse> call, Response<IndonesiaResponse> response) {
        if (response.isSuccessful()) {
          IndonesiaResponse ayahs = response.body();
          detailAdapter.setData(ayahs.getData().get(0).getAyahs(), ayahs.getData().get(1).getAyahs());
          recyclerView.setAdapter(detailAdapter);
        }
      }

      @Override
      public void onFailure(Call<IndonesiaResponse> call, Throwable t) {
        Log.e(TAG, t.getMessage());
      }
    });
  }
}
