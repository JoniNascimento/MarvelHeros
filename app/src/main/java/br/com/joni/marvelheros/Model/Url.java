package br.com.joni.marvelheros.Model;

import java.io.Serializable;

public class Url implements Serializable {
    private String type;
    private String url;

    public Url() {
    }

    public Url(String type, String url) {
        this.type = type;
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
