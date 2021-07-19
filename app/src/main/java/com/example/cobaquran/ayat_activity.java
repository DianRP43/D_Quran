package com.example.cobaquran;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.example.cobaquran.retrofit.ApiService;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Subject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ayat_activity extends AppCompatActivity {
    private final String TAG = "ayat_activity";
    List<ModelAyat.ResultAyat> Ayat;
    public String LemparNilai, LemparNama, LemaprAsma, LemparArti, LemparAyat, LemparType;
    RecyclerView RAyat;
    AdapterAyat AdapterAyat;
    AdapterSurah AdapterSurah;
    RecyclerView.LayoutManager LMAyat;
    Context context;
    LinearLayout drawerLayout;
    ModelAyat model;
    TextView txt1, keterangan_asma, keterangan_nama, keterangan_arti;
    ImageView btn;
    SearchView CariAyat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Ayat = new ArrayList<ModelAyat.ResultAyat>();
        setContentView(R.layout.activity_ayat_activity);

        //
        context = getApplicationContext();
        RAyat = findViewById(R.id.recyclerViewAyat);
        LMAyat = new LinearLayoutManager(this);
        getDataFromApi();
        Intent intent = getIntent();
        LemparNama = intent.getExtras().getString("nama");
        txt1 = findViewById(R.id.header_surat);
        txt1.setText(LemparNama);
        LemaprAsma = intent.getExtras().getString("asma");
        keterangan_asma = findViewById(R.id.keterangan);
        keterangan_asma.setText(LemaprAsma);

        keterangan_nama = findViewById(R.id.keterangan2);
        keterangan_nama.setText(LemparNama);
        LemparArti = intent.getExtras().getString("arti");
        LemparType = intent.getExtras().getString("tipe");

        LemparAyat = intent.getExtras().getString("ayat2");
        keterangan_arti = findViewById(R.id.keterangan3);
        keterangan_arti.setText(LemparArti+" - "+LemparType+" - "+LemparAyat+" ayat");

        btn = findViewById(R.id.btn_back);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ayat_activity.this, MainActivity.class));
            }
        });

        CariAyat = findViewById(R.id.cariAyat);
        CariAyat.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nextText) {
                //Data akan berubah saat user menginputkan text/kata kunci pada SearchView
                nextText = nextText.toLowerCase();
                ArrayList<ModelAyat.ResultAyat> dataFilter = new ArrayList<>();
                for (ModelAyat.ResultAyat data : Ayat) {
                    String id = data.getId().toLowerCase();
                    String nomor = data.getNomor().toLowerCase();
                    if (id.contains(nextText) || nomor.contains(nextText)) {
                        dataFilter.add(data);
                    }
                }
                AdapterAyat.setFilterAyat(dataFilter);
                return true;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    private void getDataFromApi() {
        Intent intent = getIntent();
        LemparNilai = intent.getExtras().getString("ayat");
        LemparNama = intent.getExtras().getString("nama");
        txt1 = findViewById(R.id.header_surat);
        txt1.setText(LemparNama);
        ApiService.endPointAyat().getData("surat/" + LemparNilai + ".json")
                .enqueue(new Callback<List<ModelAyat.ResultAyat>>() {
                    @Override
                    public void onResponse(Call<List<ModelAyat.ResultAyat>> call, Response<List<ModelAyat.ResultAyat>> response) {

                        if (response.isSuccessful()) {
                            Ayat = response.body();
                            Log.d(TAG, response.body().toString());
                            model = new ModelAyat();
                            model.setResult_ayat(Ayat);
                            AdapterAyat = new AdapterAyat(model.getResult_ayat(), getApplicationContext());
                            RAyat.setLayoutManager(LMAyat);
                            RAyat.setAdapter(AdapterAyat);
                        }
                    }

                    @Override
                    public void onFailure(Call<List<ModelAyat.ResultAyat>> call, Throwable t) {
                        Log.d(TAG, t.toString());
                    }
                });
    }

}