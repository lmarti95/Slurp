package main.java.board;

/**
 * Adatszerkezet a csempék megkülönböztetéséhez
 */
public enum TileType {

    /**
     * Üres csempe
     */
    EMPTY("-"),

    /**
     * Játékkgépet tartalmazó csempe
     */
    ARCADE("arcade"),

    /**
     * Fotelt tartalmazó csempe
     */
    ARMCHAIR("armchair"),
    ;

    /**
     * A typus String reprezentációja
     */
    private String type;

    /**
     * Konstruktor. String reprezentáció megadása.
     * @param type string reprezentáció
     */
    TileType(String type) {
        this.type = type;
    }
}
