package com.atguigu.p2p0224.bean;

/**
 * 作者：田学伟 on 2017/6/26 15:19
 * QQ：93226539
 * 作用：
 */

public class LoginBean {
    /**
     * name : xiaolongge
     * imageurl : http://182.92.5.3:8081/P2PInvest/images/tx.png
     * iscredit : true
     * phone : 15321970103
     */

    private String name;
    private String imageurl;
    private String iscredit;
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getIscredit() {
        return iscredit;
    }

    public void setIscredit(String iscredit) {
        this.iscredit = iscredit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
