package com.grack.rapalll.al_quran;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.grack.rapalll.al_quran.api.ApiInterface;
import com.grack.rapalll.al_quran.api.Apiclient;
import com.grack.rapalll.al_quran.model.DataItem;
import com.grack.rapalll.al_quran.model.Surah;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private SurahAdapter surahAdapter;
    List<DataItem> dataSurah;
    Surah surah;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Al-Quran");

        recyclerView = findViewById(R.id.listSurah);
        setupList();
        loadData();

//        Log.e(MainActivity.class.getSimpleName()
    }

    private void setupList(){
        surahAdapter = new SurahAdapter(dataSurah);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void loadData(){
        final ApiInterface apiInterface = Apiclient.getRetrofit().create(ApiInterface.class);
        Call<List<DataItem>> call = apiInterface.getAllsurah();
        call.enqueue(new Callback<List<DataItem>>() {
            @Override
            public void onResponse(Call<List<DataItem>> call, Response<List<DataItem>> response) {
                if (response.isSuccessful()){
                    DataItem surah = (DataItem) response.body();
                    surahAdapter.setDataSurah(surah.getsurah());
                    recyclerView.setAdapter(surahAdapter);
                    surahAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DataItem>> call, Throwable t) {

            }
        });
    }
}
