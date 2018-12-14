package com.grack.rapalll.al_quran;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;
import com.grack.rapalll.al_quran.api.ApiInterface;
import com.grack.rapalll.al_quran.api.Apiclient;
import com.grack.rapalll.al_quran.model.DataItem;
import com.grack.rapalll.al_quran.model.Surah;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

  private RecyclerView recyclerView;
  private SurahAdapter surahAdapter;
  List<DataItem> dataSurah;
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

  private void setupList() {
    dataSurah = new ArrayList<>();
    surahAdapter = new SurahAdapter(this, dataSurah);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
  }

  private void loadData() {
    final ApiInterface apiInterface = Apiclient.getRetrofit().create(ApiInterface.class);
    Call<Surah> call = apiInterface.getAllsurah();
    call.enqueue(new Callback<Surah>() {
      @Override
      public void onResponse(Call<Surah> call, Response<Surah> response) {
        if (response.isSuccessful()) {
            dataSurah.clear();
            dataSurah.addAll(response.body().getData());
            recyclerView.setAdapter(surahAdapter);
            surahAdapter.notifyDataSetChanged();
          }
      }

      @Override
      public void onFailure(Call<Surah> call, Throwable t) {

      }
    });
  }
}
