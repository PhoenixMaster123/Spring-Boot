package main.model.enums;

import lombok.Getter;

@Getter
public enum PlayerClass {
    MYSTIC_MUSE("Mystic Muse"),
    GHOST_HUNTER("Ghost Hunter"),
//    SOUL_EATER("Soul Eater"),
//    BLOOD_HUNTER("Blood Hunter"),
//    HUNTER("Hunter"),
//    WARRIOR("Warrior"),
//    SHAMAN("Shaman"),
//    PALADIN("Paladin"),
//    ROGUE("Rogue"),
//    PRIEST("Priest"),
//    DEATH_KNIGHT("Death Knight"),
//    MAGE("Mage"),
//    WARLOCK("Warlock"),
    DOOMBRINGER("Doombringer");

    private final String displayName;

    PlayerClass(String displayName) {
        this.displayName = displayName;
    }
}