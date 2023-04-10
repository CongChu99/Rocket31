package entity;

public abstract class HinhHoc {

    private static int dem;

    public HinhHoc() {
        if (dem < Configs.SO_LUONG_HINH_TOI_DA){
            dem +=1;
        } else {
            throw new HinhHocException("So luong hinh hoc toi da la: " + Configs.SO_LUONG_HINH_TOI_DA);
        }
    }

    public abstract double tinhChuVi();

    public abstract double tinhDienTich();
}
