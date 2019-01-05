package com.grack.rapalll.al_quran;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.grack.rapalll.al_quran.adapter.SurahAdapter;
import com.grack.rapalll.al_quran.api.ApiInterface;
import com.grack.rapalll.al_quran.api.Apiclient;
import com.grack.rapalll.al_quran.model.DataItem;
import com.grack.rapalll.al_quran.model.QuranResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends Fragment {

    List<DataItem> surahsItems = new ArrayList<>();
    Toolbar toolbar;
    ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private SurahAdapter surahAdapter;
//    ProgressDialog progressDialog;

//    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        progressDialog = new ProgressDialog(getContext());
        View view = inflater.inflate(R.layout.fragment_quran, viewGroup, false);
        recyclerView = view.findViewById(R.id.listSurah);

//        surahAdapter = new SurahAdapter(getActivity(), surahsItems);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        LinearLayoutManager.VERTICAL
        recyclerView.setAdapter(surahAdapter);

        new loadAsync().execute();
        return view;
    }

    private class loadAsync extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog.setMessage(getResources().getString(R.string.loading));
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            final ApiInterface apiinterface = Apiclient.getRetrofit().create(ApiInterface.class);
            Call<QuranResponse> call = apiinterface.getAllSurah();
            call.enqueue(new Callback<QuranResponse>() {
                @Override
                public void onResponse(Call<QuranResponse> call, Response<QuranResponse> response) {
                    if (response.isSuccessful()) {
                        surahsItems.clear();
                        surahsItems.addAll(response.body().getData());
                        recyclerView.setAdapter(surahAdapter);
                        surahAdapter.notifyDataSetChanged();

                    }
                    progressDialog.dismiss();

                }

                @Override
                public void onFailure(Call<QuranResponse> call, Throwable t) {

                }
            });
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            surahAdapter = new SurahAdapter(getActivity(), surahsItems);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setHasFixedSize(true);
            recyclerView.setDrawingCacheEnabled(true);
            recyclerView.setItemViewCacheSize(View.DRAWING_CACHE_QUALITY_HIGH);
            recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        }
    }
}


//    private void loadData() {
//        final ApiInterface apiInterface = Apiclient.getRetrofit().create(ApiInterface.class);
//        Call<SurahResponse> call = apiInterface.getAllSurah();
//        call.enqueue(new Callback<SurahResponse>() {
//            @Override
//            public void onResponse(Call<SurahResponse> call, Response<SurahResponse> response) {
//                if (response.isSuccessful()) {
//                    surahsItems.clear();
//                    surahsItems.addAll(response.body().getData());
//                    recyclerView.setAdapter(surahAdapter);
//                    surahAdapter.notifyDataSetChanged();
//                }
//                progressDialog.dismiss();
//            }
//
//            @Override
//            public void onFailure(Call<SurahResponse> call, Throwable t) {
//
//            }
//        });
//    }
//
//}