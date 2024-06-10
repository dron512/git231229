package com.onezogreen.onezo3.sales;

public enum TakeInOut {
    TAKEOUT("포장"),
    EATIN("매장");

    private final String description;

    TakeInOut(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}