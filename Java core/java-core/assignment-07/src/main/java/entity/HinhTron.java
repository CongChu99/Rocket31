package entity;

public class HinhTron extends HinhHoc{

    private double bankinh;
    @Override
    public double tinhChuVi() {
        return 2 * bankinh * Math.PI;
    }

    @Override
    public double tinhDienTich() {
        return bankinh * bankinh * Math.PI;
    }

    public HinhTron(double bankinh) {
        super();
        this.bankinh = bankinh;
    }

    public void setBankinh(double bankinh) {
        this.bankinh = bankinh;
    }

    public double getBankinh() {
        return bankinh;
    }
}
