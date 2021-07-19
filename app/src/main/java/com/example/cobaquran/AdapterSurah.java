package com.example.cobaquran;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AdapterSurah extends RecyclerView.Adapter<AdapterSurah.ViewHolder>{
    private List<MainModel.Result> SubjectSurah;
    private Context context;
    private String lemparNomor, lemparNama, LemparAsma, LemparArti, LemparType, LemparAyat;

    public AdapterSurah(List<MainModel.Result> subjectSurah, Context context) {
        SubjectSurah = subjectSurah;
        this.context = context;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView,textView2,textView3,textView4,textView5;
        ViewHolder(View v) {

            super(v);
            textView = v.findViewById(R.id.listsurah);
            textView2 = v.findViewById(R.id.listangka);
            textView3= v.findViewById(R.id.listkota);
            textView4 = v.findViewById(R.id.listayat);
            textView5= v.findViewById(R.id.listarab);
        }
    }
    @NonNull
    @Override
    public AdapterSurah.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fragment_surah, parent, false);

        return new AdapterSurah.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterSurah.ViewHolder holder, int position) {

        holder.textView.setText(SubjectSurah.get(position).getNama());

        holder.textView2.setText(SubjectSurah.get(position).getNomor());
        holder.textView3.setText(SubjectSurah.get(position).getType()+" - ");
        holder.textView4.setText(SubjectSurah.get(position).getAyat()+" ayat");
        holder.textView5.setText(SubjectSurah.get(position).getAsma());


        holder.textView.setOnClickListener(v -> {
            lemparNomor = SubjectSurah.get(position).getNomor();
            lemparNama = SubjectSurah.get(position).getNama();

            LemparAsma = SubjectSurah.get(position).getAsma();
            LemparArti = SubjectSurah.get(position).getArti();

            LemparType = SubjectSurah.get(position).getType();
            LemparAyat = SubjectSurah.get(position).getAyat();

//            Intent intent = new Intent(context, ayat_activity.class);
//            intent.putExtra("ayat", lemparNomor);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            context.startActivity(intent);

            Bundle bundle = new Bundle();
            bundle.putString("ayat", lemparNomor);
            bundle.putString("nama", lemparNama);
            bundle.putString("asma", LemparAsma);
            bundle.putString("arti", LemparArti);
            bundle.putString("tipe", LemparType);
            bundle.putString("ayat2", LemparAyat);

            Intent intent = new Intent(context,ayat_activity.class);
            intent.putExtras(bundle);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        });
        holder.textView5.setOnClickListener(v -> {
            lemparNomor = SubjectSurah.get(position).getNomor();
            lemparNama = SubjectSurah.get(position).getNama();

            LemparAsma = SubjectSurah.get(position).getAsma();
            LemparArti = SubjectSurah.get(position).getArti();

            LemparType = SubjectSurah.get(position).getType();
            LemparAyat = SubjectSurah.get(position).getAyat();

//            Intent intent = new Intent(context, ayat_activity.class);
//            intent.putExtra("ayat", lemparNomor);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            context.startActivity(intent);

            Bundle bundle = new Bundle();
            bundle.putString("ayat", lemparNomor);
            bundle.putString("nama", lemparNama);
            bundle.putString("asma", LemparAsma);
            bundle.putString("arti", LemparArti);
            bundle.putString("tipe", LemparType);
            bundle.putString("ayat2", LemparAyat);

            Intent intent = new Intent(context,ayat_activity.class);
            intent.putExtras(bundle);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);
        });

    }
    void setFilter(ArrayList<MainModel.Result> filterList){
        SubjectSurah = new ArrayList<>();
        SubjectSurah.addAll(filterList);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return SubjectSurah.size();
    }
}
