package br.com.joni.marvelheros.Model;

import java.io.Serializable;

public class EventSummary implements Serializable {
    private String resourdeURI;
    private String name;

    public EventSummary() {
    }

    public EventSummary(String resourdeURI, String name) {
        this.resourdeURI = resourdeURI;
        this.name = name;
    }

    public String getResourdeURI() {
        return resourdeURI;
    }

    public void setResourdeURI(String resourdeURI) {
        this.resourdeURI = resourdeURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
