package entity;

public abstract class Canbo {
    protected String hoten;
    protected int tuoi;
    protected GioiTinh gioiTinh;
    protected String diaChi;

    public Canbo(String hoten, int tuoi, GioiTinh gioiTinh, String diaChi) {
        this.hoten = hoten;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public String getHoten() {
        return hoten;
    }
}
