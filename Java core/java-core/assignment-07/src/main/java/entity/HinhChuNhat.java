package entity;

public class HinhChuNhat extends HinhHoc{

    private double chieuDai;
    private double chieuRong;
    @Override
    public double tinhChuVi() {
        return (chieuDai + chieuRong) * 2;
    }

    @Override
    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    public HinhChuNhat(double chieuDai, double chieuRong) {
        super();
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }
}
