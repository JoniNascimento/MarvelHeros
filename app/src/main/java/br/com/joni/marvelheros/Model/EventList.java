package br.com.joni.marvelheros.Model;

import java.io.Serializable;
import java.util.List;

public class EventList implements Serializable {
    private int resourceURI;
    private int returned;
    private String collectionURI;
    private List<EventSummary> items;

    public EventList() {
    }

    public EventList(int resourceURI, int returned, String collectionURI, List<EventSummary> items) {
        this.resourceURI = resourceURI;
        this.returned = returned;
        this.collectionURI = collectionURI;
        this.items = items;
    }

    public int getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(int resourceURI) {
        this.resourceURI = resourceURI;
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

    public List<EventSummary> getItems() {
        return items;
    }

    public void setItems(List<EventSummary> items) {
        this.items = items;
    }
}
