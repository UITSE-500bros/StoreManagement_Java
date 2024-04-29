package Models.DaiLyModel;

public interface DaiLyBuilder {
    DaiLyBuilder setMaDaiLy(int maDaiLy);
    DaiLyBuilder setTenDaiLy(String tenDaiLy);
    DaiLyBuilder setDienThoai(String dienThoai);
    DaiLyBuilder setDiaChi(String diaChi);
    DaiLyBuilder setMaLoaiDaiLy(int maLoaiDaiLy);
    DaiLyBuilder setMaQuan(int maQuan);
    DaiLyBuilder setSoNo(int soNo);
    DaiLyBuilder setNgayTiepNhan(String ngayTiepNhan);
    DaiLy build();
}
