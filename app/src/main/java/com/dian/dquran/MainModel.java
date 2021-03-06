package com.dian.dquran;

import java.util.List;

public class MainModel {
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Result{
        private String ayat,arti,asma,audio,nama,keterangan,nomor,name,rukuk,type,urut;

        public String getAyat() {
            return ayat;
        }

        public void setAyat(String ayat) {
            this.ayat = ayat;
        }

        public String getArti() {
            return arti;
        }

        public void setArti(String arti) {
            this.arti = arti;
        }

        public String getAsma() {
            return asma;
        }

        public void setAsma(String asma) {
            this.asma = asma;
        }

        public String getAudio() {
            return audio;
        }

        public void setAudio(String audio) {
            this.audio = audio;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getKeterangan() {
            return keterangan;
        }

        public void setKeterangan(String keterangan) {
            this.keterangan = keterangan;
        }

        public String getNomor() {
            return nomor;
        }

        public void setNomor(String nomor) {
            this.nomor = nomor;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRukuk() {
            return rukuk;
        }

        public void setRukuk(String rukuk) {
            this.rukuk = rukuk;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getUrut() {
            return urut;
        }

        public void setUrut(String urut) {
            this.urut = urut;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "nama='" + nama + '\'' +
                    '}';
        }
    }

}
