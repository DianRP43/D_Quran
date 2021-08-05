package com.dian.dquran;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.sufficientlysecure.htmltextview.HtmlTextView;

import java.util.ArrayList;
import java.util.List;

// {10118043, Dian Rosa Pratama, AKB}
public class AdapterAyat extends  RecyclerView.Adapter<AdapterAyat.ViewHolder> {
    private List<ModelAyat.ResultAyat> SubjectAyat;
    private Context context;
    private List<MainModel.Result> SubjectSurah;



    public AdapterAyat(List<ModelAyat.ResultAyat> subjectAyat, Context context) {
        SubjectAyat = subjectAyat;
        this.context = context;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView,textView2,textView3,textView4,textView5;
        HtmlTextView htmlTextView;
        ViewHolder(View v) {

            super(v);
            textView = v.findViewById(R.id.listayat);
            textView2 = v.findViewById(R.id.listarti);
            textView3 = v.findViewById(R.id.listangka);
            htmlTextView = v.findViewById(R.id.listtr);
        }
    }
    @NonNull
    @Override
    public AdapterAyat.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.fragment_ayat, parent, false);

        return new AdapterAyat.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterAyat.ViewHolder holder, int position) {

        holder.textView.setText(SubjectAyat.get(position).getAr());
        holder.textView2.setText(SubjectAyat.get(position).getId());
        holder.htmlTextView.setHtml(SubjectAyat.get(position).getTr());
        holder.textView3.setText(SubjectAyat.get(position).getNomor());

    }
    void setFilterAyat(ArrayList<ModelAyat.ResultAyat> filterList){
        SubjectAyat = new ArrayList<>();
        SubjectAyat.addAll(filterList);
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return SubjectAyat.size();
    }
}
