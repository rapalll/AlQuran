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
import com.grack.rapalll.al_quran.model.AyahsItem;
import com.grack.rapalll.al_quran.model.QuranResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailQuran extends AppCompatActivity {

    private static final String TAG = "Pesan Saya";
    Toolbar toolbar;
    //private DataItem dataItem;
    String id;
    private RecyclerView recyclerView;
    private List<AyahsItem> detailAyah;
    private DetailAdapter detailAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_quran);


        toolbar = findViewById(R.id.toolbar);

        recyclerView = findViewById(R.id.detailAyat);

        id = getIntent().getStringExtra("detailAyah");

        setupList();
        loadData();

//        Log.e(DetailQuran.class.getSimpleName(), "rowAyat:" + detailAyah.getNumberInSurah()
//                + "\n" + detailAyah.getText() + "\n");

    }

    private void setupList() {
        detailAyah = new ArrayList<>();
        detailAdapter = new DetailAdapter(this, detailAyah);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadData() {
        final ApiInterface apiInterface = Apiclient.getRetrofit().create(ApiInterface.class);
        Call<QuranResponse> call = apiInterface.getDetailAyat("7");
        call.enqueue(new Callback<QuranResponse>() {
            @Override
            public void onResponse(Call<QuranResponse> call, Response<QuranResponse> response) {
                if (response.isSuccessful()) {
                    detailAyah.clear();
//                    SurahResponse response1 = response.body();
//                    detailAdapter.setData(response1.getAyah());
                    detailAyah = response.body().getAyahsItems();
                    recyclerView.setAdapter(detailAdapter);
                    detailAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<QuranResponse> call, Throwable t) {
//                Toast.makeText(DetailQuran.this, "Gagal Dapat Data", Toast.LENGTH_SHORT).show();
                Log.e(TAG, t.getMessage());

            }
        });
    }
}

//
//        AyahsItem detailAyah = new GsonBuilder().create().fromJson(getIntent().getStringExtra("quran"), AyahsItem.class);
//        tvRowAyat.setText(String.valueOf(detailAyah.getNumberInSurah()));
//        tvRowArabic.setText(detailAyah.getText());
//        tvRowTranslate.setText(surahsIndo.getText());

//

//        final ApiInterface apiinterface = Apiclient.getRetrofit().create(ApiInterface.class);
//        Call<DetailResponse> call = apiinterface.getAllSurah();
//        call.enqueue(new Callback<SurahResponse>() {
//            @Override
//            public void onResponse(Call<SurahResponse> call, Response<SurahResponse> response) {
//                if (response.isSuccessful()) {
//                    surahsItems.clear();
//                    surahsItems.addAll(response.body().getData());
//                    recyclerView.setAdapter(surahAdapter);
//                    surahAdapter.notifyDataSetChanged();
////                        Movie movies = response.body();
////                        adapter.setData(movies.getResults());
////                        recyclerView.setAdapter(adapter);
////                        adapter.notifyDataSetChanged();
//
//                }
//                progressDialog.dismiss();
//
//            }
//
//            @Override
//            public void onFailure(Call<SurahResponse> call, Throwable t) {
//
//            }
//        });
//        return null;
//    }

