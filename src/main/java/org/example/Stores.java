package org.example;

public abstract class Stores {
    private String  storeName;
    private String location;


    public Stores(){}

    public Stores(String storeName, String location){
        this.storeName = storeName;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }


}
