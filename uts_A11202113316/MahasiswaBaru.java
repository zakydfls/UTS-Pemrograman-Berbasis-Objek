package uts_A11202113316;

class MahasiswaBaru extends Mahasiswa {
    public String asalSekolah;

    public MahasiswaBaru(String nim, String nama, int semester, int usia, String[] krs, String asalSekolah) {
        super(nim, nama, semester, usia, krs);
        this.asalSekolah = asalSekolah;
    }

    public boolean ikutOspek() {
        return true;
    }

    @Override
    public void infoMahasiswa() {
        super.infoMahasiswa();
        System.out.println("Asal Sekolah : " + this.asalSekolah);
    }
}
