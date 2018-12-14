package com.grack.rapalll.al_quran;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.grack.rapalll.al_quran.model.DataItem;
import java.util.List;

public class SurahAdapter extends RecyclerView.Adapter<SurahAdapter.SurahHolder> {

  private Context context;
  private List<DataItem> dataSurah;

  public SurahAdapter(Context context,
      List<DataItem> dataSurah) {
    this.context = context;
    this.dataSurah = dataSurah;
  }

  @NonNull
  @Override
  public SurahHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_surah, parent, false);
    return new SurahHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull SurahHolder Holder, int position) {

    DataItem dataItem = dataSurah.get(position);

    Holder.rowTerjemahanSurah.setText(dataItem.getEnglishNameTranslation());

//        Integer number  = dataSurah.get(position).getNumber();
//        String namaSurah = dataSurah.get(position).getEnglishName();
//        String translate = dataSurah.get(position).getEnglishNameTranslation();
//        Integer jumlahAyat= dataSurah.get(position).getNumberOfAyahs();

  }

//    public void setDataSurah (List<DataItem> dataSurah){
//        this.dataSurah = dataSurah;
//    }

  @Override
  public int getItemCount() {
    return dataSurah.size();
  }

  class SurahHolder extends RecyclerView.ViewHolder {

//    TextView rowNumber;
//    TextView rowNamaSurah;
    TextView rowTerjemahanSurah;
//    TextView rowJumlahAyat;

    public SurahHolder(View itemView) {
      super(itemView);
//      rowNamaSurah = itemView.findViewById(R.id.rowNamaSurah);
//      rowNumber = itemView.findViewById(R.id.rowNumber);
      rowTerjemahanSurah = itemView.findViewById(R.id.rowTerjemahanSurah);
//      rowJumlahAyat = itemView.findViewById(R.id.rowJumlahAyat);
    }
  }

}
