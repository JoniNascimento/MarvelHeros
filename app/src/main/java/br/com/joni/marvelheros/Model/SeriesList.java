package br.com.joni.marvelheros.Model;

import java.io.Serializable;
import java.util.List;

public class SeriesList implements Serializable {
    private int available;
    private int returned;
    private String collectionURI;
    private List<SeriesSummary> items;

    public SeriesList() {
    }

    public SeriesList(int available, int returned, String collectionURI, List<SeriesSummary> items) {
        this.available = available;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.items = items;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getReturned() {
        return returned;
    }

    public void setReturned(int returned) {
        this.returned = returned;
    }

    public String getCollectionURI() {
        return collectionURI;
    }

    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    public List<SeriesSummary> getItems() {
        return items;
    }

    public void setItems(List<SeriesSummary> items) {
        this.items = items;
    }
}
