package com.peroah.item;

public class ItemSerializer {
    public String serialize(Object item) {
        return item == null ? "" : item.toString();
    }
}
