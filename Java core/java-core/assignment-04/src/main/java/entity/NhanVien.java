package entity;

public class NhanVien extends Canbo {
    private String congviec;

    public NhanVien(String hoten, int tuoi, GioiTinh gioiTinh, String diaChi, String congviec) {
        super(hoten, tuoi, gioiTinh, diaChi);
        this.congviec = congviec;
    }

    public String getCongviec() {
        return congviec;
    }

    public void setCongviec(String congviec) {
        this.congviec = congviec;
    }
}
