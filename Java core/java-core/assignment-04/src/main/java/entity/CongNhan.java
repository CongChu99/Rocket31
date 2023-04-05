package entity;

public class CongNhan extends Canbo{
    private int bac;

    public CongNhan(String hoten, int tuoi, GioiTinh gioiTinh, String diaChi, int bac) {
        super(hoten, tuoi, gioiTinh, diaChi);
        this.bac = bac;
    }
}
