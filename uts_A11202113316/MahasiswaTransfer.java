package uts_A11202113316;

public class MahasiswaTransfer extends MahasiswaBaru {
    String asalUniversitas;

    public MahasiswaTransfer(String nim, String nama, int semester, int usia, String[] krs, String asalUniversitas) {
        super(nim, nama, semester, usia, krs, asalUniversitas);
        this.asalUniversitas = asalUniversitas;
    }

    @Override
    public boolean ikutOspek() {
        return false;
    }

    @Override
    public void infoMahasiswa() {
        super.infoMahasiswa();
        System.out.println("Asal Universitas : " + this.asalUniversitas);
    }
}
