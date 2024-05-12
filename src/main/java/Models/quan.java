package Models;

public  class quan {

    private int maquan;
    private String tenquan;

    public quan(int maquan) {
        this.maquan = maquan;
    }

    public quan(int maquan, String tenquan) {
        this.maquan = maquan;
        this.tenquan = tenquan;
    }

    public quan() {

    }

    public int getId() {
        return maquan;
    }

    public void setId(Integer id) {
        this.maquan = id;
    }

    public String getTenquan() {
        return tenquan;
    }

    public void setTenquan(String tenquan) {
        this.tenquan = tenquan;
    }
}
