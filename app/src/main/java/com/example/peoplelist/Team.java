package com.example.peoplelist;

import java.io.Serializable;

public class Team implements Serializable {

    private String name, history, networth, owner, image, url;

    public Team(String name, String history, String networth, String owner, String image, String url) {
        this.name = name;
        this.history = history;
        this.networth = networth;
        this.owner = owner;
        this.image = image;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNetworth() {
        return networth;
    }

    public void setNetworth(String networth) {
        this.networth = networth;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String address) {
        this.owner = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
