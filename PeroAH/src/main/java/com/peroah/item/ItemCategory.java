package com.peroah.item;

import java.util.ArrayList;
import java.util.List;

public enum ItemCategory {
    WEAPONS("Weapons"),
    ARMOR("Armor"),
    TOOLS("Tools"),
    BLOCKS("Blocks"),
    CONSUMABLES("Consumables"),
    MISC("Miscellaneous");

    private String displayName;

    ItemCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
