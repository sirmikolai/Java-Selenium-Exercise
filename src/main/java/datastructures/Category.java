package datastructures;

public enum Category {
    WOMEN("Women"),
    DRESSES("Dresses"),
    T_SHIRTS("T-shirts");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
