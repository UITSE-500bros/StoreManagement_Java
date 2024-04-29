package Models.DaiLyModel;

public class DaiLy {
    private int maDaiLy;
    private String tenDaiLy;
    private String dienThoai;
    private String diaChi;
    private int maLoaiDaiLy;
    private int maQuan;
    private int soNo;
    private String ngayTiepNhan;

    public DaiLy() {
    }

    public DaiLy(int maDaiLy2, String tenDaiLy2, String dienThoai2, String diaChi2, int maLoaiDaiLy2, int maQuan2, int soNo2, String ngayTiepNhan2) {
        this.maDaiLy = maDaiLy2;
        this.tenDaiLy = tenDaiLy2;
        this.dienThoai = dienThoai2;
        this.diaChi = diaChi2;
        this.maLoaiDaiLy = maLoaiDaiLy2;
        this.maQuan = maQuan2;
        this.soNo = soNo2;
        this.ngayTiepNhan = ngayTiepNhan2;
    }
}
