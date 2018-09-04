package com.example.joshhsieh.joshprojectcustomer.Class;

import java.io.Serializable;

public class DinlingServiceMsg implements Serializable {
    public static final int TYPE_RECEVIED = 0;  // 代表接受訊息
    public static final int TYPE_SENT = 1;      // 代表發送訊息
    private String content; // 代表訊息內容
    private int type; // 代表訊息類型 上面 0 和 1
    private int image;
    private int number; // 點擊事件代碼


    public DinlingServiceMsg(String content, int type, int image, int number) {
        this.content = content;
        this.type = type;
        this.image = image;
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
