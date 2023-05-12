package uts_A11202113316;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

public class MahasiswaMain {
    public static void main(String[] args) {
        boolean menu = true;

        ArrayList<Mahasiswa> listMhs = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("======Aplikasi Input Data Mahasiswa======");
            System.out.println("Jenis Mahasiswa :");
            System.out.println("1. Mahasiswa Aktif");
            System.out.println("2. Mahasiswa Baru");
            System.out.println("3. Mahasiswa Transfer");
            System.out.println("4. Mahasiswa Lulus");
            System.out.print("Pilihan : ");
            int jenisMahasiswa = sc.nextInt();
            sc.nextLine();
            while (jenisMahasiswa > 4 || jenisMahasiswa == 0) {
                System.out.println("Input yang anda masukkan tidak ada dalam menu!");
                System.out.print("Silahkan masukkan ulang pilihan anda : ");
                jenisMahasiswa = sc.nextInt();
                sc.nextLine();
            }

            System.out.print("Nama Mahasiswa        : ");
            String nama = sc.nextLine();
            System.out.print("NIM Mahasiswa         : ");
            String nim = sc.nextLine();
            System.out.print("Semester              : ");
            int semester = sc.nextInt();
            sc.nextLine();
            System.out.print("Usia                  : ");
            int usia = sc.nextInt();
            sc.nextLine();


            System.out.print("Jumlah matakuliah yang telah ditempuh : ");
            int jumlahMataKuliah = sc.nextInt();
            sc.nextLine();
            float[] nilai = new float[jumlahMataKuliah];
            String[] krs = new String[jumlahMataKuliah];
            for (int j = 0; j < jumlahMataKuliah; j++) {
                System.out.print("Mata kuliah ke-" + (j + 1) + " : ");
                krs[j] = sc.nextLine();
                System.out.print("Nilai Mata Kuliah " + krs[j] + " : ");
                nilai[j] = sc.nextFloat();
                sc.nextLine();
            }

            Mahasiswa mahasiswa = new Mahasiswa(nim, nama, semester, usia, krs);
            mahasiswa.nilai = nilai;
            // listMhs.add(mahasiswa);
            switch (jenisMahasiswa) {
                case 1:
                    mahasiswa = new Mahasiswa(nim, nama, semester, usia, krs);
                    mahasiswa.nilai = nilai;
                    break;
                case 2:
                    System.out.print("Asal Sekolah : ");
                    String asalSekolah = sc.nextLine();
                    mahasiswa = new MahasiswaBaru(nim, nama, semester, usia, krs, asalSekolah);
                    mahasiswa.nilai = nilai;
                    break;
                case 3:
                    System.out.print("Asal Universitas : ");
                    String asalUniversitas = sc.nextLine();
                    mahasiswa = new MahasiswaTransfer(nim, nama, semester, usia, krs,
                            asalUniversitas);
                    mahasiswa.nilai = nilai;
                    break;
                case 4:
                    System.out.print("Tahun Wisuda : ");
                    int tahunWisuda = sc.nextInt();
                    sc.nextLine();
                    System.out.print("IPK : ");
                    float ipk = sc.nextFloat();
                    sc.nextLine();
                    mahasiswa = new MahasiswaLulus(nim, nama, semester, usia, krs, tahunWisuda,
                            ipk);
                    mahasiswa.nilai = nilai;
                    break;
            }
            listMhs.add(mahasiswa);
            System.out.println("Data Mahasiswa berhasil ditambahkan!\n");

            // Tampilkan data Mahasiswa
            System.out.println("=== Data Mahasiswa ===");
            Iterator<Mahasiswa> iterator = listMhs.iterator();
            while (iterator.hasNext()) {
                Mahasiswa mhs = iterator.next();
                mhs.infoMahasiswa();
                if (mhs instanceof MahasiswaBaru) {
                    System.out.println("Mengikuti OSPEK : " + ((MahasiswaBaru) mhs).ikutOspek());
                } else if (mhs instanceof MahasiswaTransfer) {
                    System.out.println("Mengikuti OSPEK : " + ((MahasiswaTransfer) mhs).ikutOspek());
                }
                System.out.println("======================\n");
            }

            // Hitung rata-rata nilai mahasiswa
            System.out.println("=== Rata-rata Nilai Mahasiswa ===");
            HashSet<String> setNama = new HashSet<String>();
            for (Mahasiswa mhs : listMhs) {
                if (!setNama.contains(mhs.nama)) {
                    setNama.add(mhs.nama);
                    float rataNilai = mhs.hitungRataNilai(mhs.nilai);
                    System.out.println(mhs.nama + ": " + rataNilai);
                }
                System.out.println("=================================\n");
            }
            for (Mahasiswa mhsKRS : listMhs) {
                mhsKRS.infoKrsMahasiswa();
                System.out.println("=====================\n");
            }
            System.out.println("Input data lagi ? [Y/T]");
            char lanjut = sc.next().charAt(0);
            sc.nextLine();
            if (lanjut == 'Y' || lanjut == 'y')
                ;
            else {
                menu = false;
                System.out.println("Terimakasih :)");
            }
        } while (menu == true);
        sc.close();
    }
}
