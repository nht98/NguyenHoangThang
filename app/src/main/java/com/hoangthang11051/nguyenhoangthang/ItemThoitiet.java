package com.hoangthang11051.nguyenhoangthang;


public class ItemThoitiet {
    String tenquocgia;
    String thoitiet = null;
    int nhietdo;


    public ItemThoitiet(String tenquocgia, int nhietdo) {
        this.tenquocgia = tenquocgia;
        this.nhietdo = nhietdo;
    }

    public ItemThoitiet(String tenquocgia, String thoitiet, int nhietdo) {
        this.tenquocgia = tenquocgia;
        this.thoitiet = thoitiet;
        this.nhietdo = nhietdo;
    }

    public String getKieuThoiTiet() {
        if (thoitiet != null) {
            return thoitiet;
        }
        if (nhietdo > 30) {
            return "Nang";
        } else if (nhietdo >= 20) {
            return "Nhieu may";
        } else {
            return "Mua";
        }
    }

    public String getNhietDo() {
        return nhietdo + "°C";
    }

    public int getIMG() {
        String tt = getKieuThoiTiet();
        switch (tt) {
            case "Nang":
                return R.drawable.sun;
            case "Nhieu may":
                return R.drawable.cloud;
            case "Mua":
                return R.drawable.rain;
        }
        return 0;
    }
}
