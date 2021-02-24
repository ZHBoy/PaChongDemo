package com.zhboy.myapplication;

/**
 * @author: zhou_hao
 * @date: 2021/2/24
 * @description:
 **/
public class UrlFilterBean {

    private String url;

    private String divOut;

    private String divInt;

    public UrlFilterBean(){

    }

    public UrlFilterBean(String url, String divOut, String divInt) {
        this.url = url;
        this.divOut = divOut;
        this.divInt = divInt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDivOut() {
        return divOut;
    }

    public void setDivOut(String divOut) {
        this.divOut = divOut;
    }

    public String getDivInt() {
        return divInt;
    }

    public void setDivInt(String divInt) {
        this.divInt = divInt;
    }
}
