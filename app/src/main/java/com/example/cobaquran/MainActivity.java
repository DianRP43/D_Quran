package com.example.cobaquran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.SearchView;

import com.example.cobaquran.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    private final String TAG = "MainActivity";

    List<MainModel.Result> Surah;

    RecyclerView RSurah;
    AdapterSurah Adapter;
    RecyclerView.LayoutManager LMSurah;
    Context context;
    LinearLayout drawerLayout;
    MainModel model;
    SearchView CariSurah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Surah = new ArrayList<MainModel.Result>();
        setContentView(R.layout.activity_main);

        //
        context = getApplicationContext();
        RSurah = findViewById(R.id.recyclerViewSurah);
        LMSurah = new LinearLayoutManager(this);
        getDataFromApi();

        CariSurah = findViewById(R.id.cariSurah);
        CariSurah.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nextText) {
                //Data akan berubah saat user menginputkan text/kata kunci pada SearchView
                nextText = nextText.toLowerCase();
                ArrayList<MainModel.Result> dataFilter = new ArrayList<>();
                for(MainModel.Result data : Surah){
                    String nama = data.getNama().toLowerCase();
                    String nomor = data.getNomor().toLowerCase();
                    if(nama.contains(nextText)  ||  nomor.contains(nextText)) {
                        dataFilter.add(data);
                    }
                }
                Adapter.setFilter(dataFilter);
                return true;
            }
        });
    }

    private void getDataFromApi (){
        ApiService.endpoint().getData()
                .enqueue(new Callback<List<MainModel.Result>>() {
                    @Override
                    public void onResponse(Call<List<MainModel.Result>> call, Response<List<MainModel.Result>> response) {
                        if (response.isSuccessful()){
                            Surah = response.body();
                            Log.d(TAG, response.body().toString());
                            model = new MainModel();
                            model.setResult(Surah);
//                            LinearLayoutManager llm = new LinearLayoutManager(this);
//                            llm.setOrientation(LinearLayoutManager.VERTICAL);
//                            list.setLayoutManager(llm);
//                            list.setAdapter( adapter );
                            Adapter = new AdapterSurah(model.getResult(),getApplicationContext());
                            RSurah.setLayoutManager(LMSurah);
                            RSurah.setAdapter(Adapter);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<MainModel.Result>> call, Throwable t) {
                        Log.d(TAG, t.toString());
                    }
                }) ;
    }
}