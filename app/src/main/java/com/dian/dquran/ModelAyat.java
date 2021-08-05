package com.dian.dquran;


import java.util.List;

public class ModelAyat {
    private List<ModelAyat.ResultAyat> result_ayat;

    public List<ModelAyat.ResultAyat> getResult_ayat() {
        return result_ayat;
    }

    public void setResult_ayat(List<ModelAyat.ResultAyat> result_ayat) {
        this.result_ayat= result_ayat;
    }

    public class ResultAyat {

    private String ar, id, nomor, tr;

    public String getAr() {
        return ar;
    }

    public void setAr(String ar) {
        this.ar = ar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomor() {
        return nomor;
    }

    public void setNomor(String nomor) {
        this.nomor = nomor;

    }
        public String getTr() {
            return tr;
        }
        public void setTr(String tr) {
            this.tr = tr;
        }
    }
}
