package main.model.enums;

import lombok.Getter;

@Getter
public enum ItemType {
    WEAPON("Weapon"),
    ARMOR("Armor"),
    OTHER("Other");


    private final String displayName;

    ItemType(String displayName) {
        this.displayName = displayName;
    }
}
