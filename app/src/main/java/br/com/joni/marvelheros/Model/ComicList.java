package br.com.joni.marvelheros.Model;

import java.io.Serializable;
import java.util.List;

public class ComicList implements Serializable {
    private int available;
    private int returned;
    private String collectionURI;
    private List<StorySummary> items;

    public ComicList() {

    }

    public ComicList(int available, int returned, String collectionURI, List<StorySummary> items) {
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

    public List<StorySummary> getItems() {
        return items;
    }

    public void setItems(List<StorySummary> items) {
        this.items = items;
    }
}
