package com.entity;

//业务扩展类，继承于一个属性多的，写一个属性少的
public class StudentBusinsess extends Student {
    private int cardid;
    private String cardinfo;

    public int getCardid() {
        return cardid;
    }

    public void setCardid(int cardid) {
        this.cardid = cardid;
    }

    public String getCardinfo() {
        return cardinfo;
    }

    public void setCardinfo(String cardinfo) {
        this.cardinfo = cardinfo;
    }

    @Override
    public String toString() {
        return super.toString()+","+this.cardid+","+this.cardinfo;
    }
}
