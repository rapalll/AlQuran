package com.grack.rapalll.al_quran.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.grack.rapalll.al_quran.R;
import com.grack.rapalll.al_quran.detail.DetailQuran;
import com.grack.rapalll.al_quran.model.DataItem;

import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahHolder> {

  private Context context;
  private List<DataItem> surahItems;


  public SurahAdapter(Context context,
                      List<DataItem> surahItems) {
    this.context = context;
    this.surahItems = surahItems;
  }

  @NonNull
  @Override
  public SurahHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.list_surah, parent, false);
    return new SurahHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull final SurahHolder holder, final int position) {

    final DataItem surahsItem = surahItems.get(position);

    holder.rowNamaSurah.setText(surahsItem.getEnglishName());
    holder.rowTerjemahanSurah.setText(surahsItem.getEnglishNameTranslation());
    holder.rowJumlahAyat.setText(String.valueOf(surahsItem.getNumberOfAyahs()));
    holder.rowNumber.setText(String.valueOf(surahsItem.getNumber()));

    holder.itemView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        DataItem data = surahItems.get(position);
        Intent intent = new Intent(holder.itemView.getContext(), DetailQuran.class);
        intent.putExtra("detailAyah", surahsItem.getNumber());
        holder.itemView.getContext().startActivity(intent);

      }
    });

  }


  @Override
  public int getItemCount() {
    return surahItems.size();
  }

  class SurahHolder extends RecyclerView.ViewHolder {

    TextView rowNumber;
    TextView rowNamaSurah;
    TextView rowTerjemahanSurah;
    TextView rowJumlahAyat;

    public SurahHolder(View itemView) {
      super(itemView);
      rowNamaSurah = itemView.findViewById(R.id.rowNamaSurah);
      rowNumber = itemView.findViewById(R.id.rowNumber);
      rowTerjemahanSurah = itemView.findViewById(R.id.rowTerjemahanSurah);
      rowJumlahAyat = itemView.findViewById(R.id.rowJumlahAyat);
    }
  }

}
