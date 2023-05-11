package uts_A11202113316;

import java.util.HashSet;
import java.util.Set;

class Mahasiswa {
    String nim, nama;
    int semester, usia;
    String[] krs;
    float[] nilai;

    public Mahasiswa(String nim, String nama, int semester, int usia, String[] krs) {
        this.nim = nim;
        this.nama = nama;
        this.semester = semester;
        this.usia = usia;
        this.krs = krs;
    }

    public float[] getNilai() {
        return nilai;
    }

    public void setNilai(float[] nilai) {
        this.nilai = nilai;
    }

    public float hitungRataNilai(float[] nilai) {
        float total = 0;
        for (float n : nilai) {
            total += n;
        }
        return total / nilai.length;
    }

    public void infoMahasiswa() {
        System.out.println("Nama Mahasiswa    : " + this.nama);
        System.out.println("NIM Mahasiswa     : " + this.nim);
        System.out.println("Semester          : " + this.semester);
        System.out.println("Usia              : " + this.usia);
    }

    public void infoKrsMahasiswa() {
        System.out.println("KRS " + this.nama + " : ");
        Set<String> uniqueKrs = new HashSet<String>();
        for (int i = 0; i < this.krs.length; i++) {
            uniqueKrs.add(this.krs[i]);
        }
        for (String mataKuliah : uniqueKrs) {
            System.out.println("- " + mataKuliah);
        }
    }
}
