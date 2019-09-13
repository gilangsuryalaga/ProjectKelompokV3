package com.example.projectkelompokv3;

import android.os.Parcel;
import android.os.Parcelable;

public class Data implements Parcelable {
    private int no;
     private  String nama,tgl,jenkel,alamat;
public Data(){

}
    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int describeContents(){
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(this.no);
        dest.writeString(this.nama);
        dest.writeString(this.tgl);
        dest.writeString(this.jenkel);
        dest.writeString(this.alamat);
    }

    protected Data(Parcel in){
        this.no = in.readInt();
        this.nama = in.readString();
        this.tgl = in.readString();
        this.jenkel = in.readString();
        this.alamat = in.readString();
    }
    public static final Creator<Data> CREATOR = new Parcelable.Creator<Data>(){
        @Override
        public Data createFromParcel(Parcel source) {
            return new Data(source);
        }
        @Override
        public Data[] newArray(int size){
            return new Data[size];
        }
    };

}
