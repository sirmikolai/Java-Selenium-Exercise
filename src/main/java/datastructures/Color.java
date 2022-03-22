package datastructures;

public enum Color {
    BLUE("Blue"),
    ORANGE("Orange"),
    PINK("Pink"),
    BEIGE("Beige"),
    BLACK("Black"),
    YELLOW("Yellow"),
    WHITE("White"),
    GREEN("GREEN");

    private final String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
