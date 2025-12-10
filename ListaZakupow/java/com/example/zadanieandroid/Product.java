package com.example.zadanieandroid;

public class Product {
    private String name;
    private boolean purchased;

    public Product(String name) {
        this.name = name;
        this.purchased = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPurchased() {
        return purchased;
    }

    public void setPurchased(boolean purchased) {
        this.purchased = purchased;
    }
}
