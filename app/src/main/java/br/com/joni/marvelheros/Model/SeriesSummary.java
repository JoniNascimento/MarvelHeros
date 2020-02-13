package br.com.joni.marvelheros.Model;

import java.io.Serializable;

public class SeriesSummary implements Serializable {
    private String resourceURI;
    private String name;

    public SeriesSummary() {
    }

    public SeriesSummary(String resourceURI, String name) {
        this.resourceURI = resourceURI;
        this.name = name;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
