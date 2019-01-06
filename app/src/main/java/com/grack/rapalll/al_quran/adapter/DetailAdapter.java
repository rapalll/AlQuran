package com.grack.rapalll.al_quran.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.grack.rapalll.al_quran.R;
import java.util.List;

public class DetailAdapter extends RecyclerView.Adapter<DetailAdapter.DetailHolder> {

  private List<com.grack.rapalll.al_quran.model.models.AyahsItem> detailAyat;
  private List<com.grack.rapalll.al_quran.model.models.AyahsItem> detailAyat2;
  private Context context;

  public DetailAdapter(Context context,
      List<com.grack.rapalll.al_quran.model.models.AyahsItem> detailAyat,
      List<com.grack.rapalll.al_quran.model.models.AyahsItem> data2) {
    this.context = context;
    this.detailAyat = detailAyat;
    this.detailAyat2 = data2;
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

    com.grack.rapalll.al_quran.model.models.AyahsItem ayahDetail = detailAyat.get(position);
    com.grack.rapalll.al_quran.model.models.AyahsItem ayahDetail2 = detailAyat2.get(position);

    holder.ayat.setText(String.valueOf(ayahDetail.getNumberInSurah()));
    holder.rowArabic.setText(ayahDetail.getText());
    holder.rowArtinya.setText(ayahDetail2.getText());


  }

  @Override
  public int getItemCount() {
    return detailAyat.size();
  }

  public void setData(List<com.grack.rapalll.al_quran.model.models.AyahsItem> data,
      List<com.grack.rapalll.al_quran.model.models.AyahsItem> data2) {
    this.detailAyat = data;
    this.detailAyat2 = data2;
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
