package br.com.joni.marvelheros.Model;

import java.io.Serializable;

public class CharacterDataWrapper implements Serializable {
    private int code;
    private String status;
    private String copyright;
    private String attribuitionText;
    private String attribuitionData;
    private  CharacterDataContainer data;
    private String etag;

    public CharacterDataWrapper() {
    }

    public CharacterDataWrapper(int code, String status, String copyright, String attribuitionText, String attribuitionData, CharacterDataContainer data, String etag) {
        this.code = code;
        this.status = status;
        this.copyright = copyright;
        this.attribuitionText = attribuitionText;
        this.attribuitionData = attribuitionData;
        this.data = data;
        this.etag = etag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getAttribuitionText() {
        return attribuitionText;
    }

    public void setAttribuitionText(String attribuitionText) {
        this.attribuitionText = attribuitionText;
    }

    public String getAttribuitionData() {
        return attribuitionData;
    }

    public void setAttribuitionData(String attribuitionData) {
        this.attribuitionData = attribuitionData;
    }

    public CharacterDataContainer getData() {
        return data;
    }

    public void setData(CharacterDataContainer data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
