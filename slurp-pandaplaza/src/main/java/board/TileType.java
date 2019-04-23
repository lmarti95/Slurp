package board;

public enum TileType {

    EMPTY("-"),
    ARCADE("arcade"),
    ARMCHAIR("armchair"),
    ;

    private String type;

    TileType(String type) {
        this.type = type;
    }
}
