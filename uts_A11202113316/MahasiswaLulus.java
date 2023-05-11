package uts_A11202113316;

class MahasiswaLulus extends Mahasiswa {
    private int tahunWisuda;
    private float ipk;

    public MahasiswaLulus(String nim, String nama, int semester, int usia, String[] krs, int tahunWisuda, float ipk) {
        super(nim, nama, semester, usia, krs);
        this.tahunWisuda = tahunWisuda;
        this.ipk = ipk;
    }

    public boolean ikutWisuda() {
        return true;
    }

    public void infoMahasiswa() {
        super.infoMahasiswa();
        System.out.println("Tahun Wisuda : " + this.tahunWisuda);
        System.out.println("IPK          : " + this.ipk);
    }
}
