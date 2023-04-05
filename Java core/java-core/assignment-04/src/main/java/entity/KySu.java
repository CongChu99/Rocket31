package entity;

public class KySu extends Canbo{
    private String nganhdaotao;

    public KySu(String hoten, int tuoi, GioiTinh gioiTinh, String diaChi, String nganhdaotao) {
        super(hoten, tuoi, gioiTinh, diaChi);
        this.nganhdaotao = nganhdaotao;
    }

    public String getNganhdaotao() {
        return nganhdaotao;
    }

    public void setNganhdaotao(String nganhdaotao) {
        this.nganhdaotao = nganhdaotao;
    }
}
