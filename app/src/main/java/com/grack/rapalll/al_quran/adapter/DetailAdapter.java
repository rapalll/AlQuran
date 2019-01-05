package com.grack.rapalll.al_quran.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grack.rapalll.al_quran.R;
import com.grack.rapalll.al_quran.model.AyahsItem;

import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder> {

    private List<AyahsItem> detailAyat;
    private Context context;

    public DetailAdapter(Context context, List<AyahsItem> detailAyat) {
        this.context = context;
        this.detailAyat = detailAyat;
//        this.context = context;
//        this.arabicItems = arabicItems;
//        this.indoItems = indoItems;
    }


    @NonNull
    @Override
    public DetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_detail_quran, parent, false);
        return new DetailHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailHolder holder, int position) {

        final AyahsItem ayahDetail = detailAyat.get(position);

        holder.ayat.setText(String.valueOf(ayahDetail.getNumberInSurah()));
        holder.rowArabic.setText(ayahDetail.getText());
        holder.rowArtinya.setText(ayahDetail.getText());


    }

    @Override
    public int getItemCount() {
        return detailAyat.size();
    }

    public void setData(List<AyahsItem> data) {
        this.detailAyat = data;
    }

    class DetailHolder extends RecyclerView.ViewHolder {
        private TextView ayat, rowArabic, rowArtinya;

        public DetailHolder(@NonNull View itemView) {
            super(itemView);
            ayat = itemView.findViewById(R.id.rowAyat);
            rowArabic = itemView.findViewById(R.id.rowArabic);
            rowArtinya = itemView.findViewById(R.id.rowTerjemahan);
        }
    }
}
