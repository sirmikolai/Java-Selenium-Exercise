package datastructures;

public enum BrowserType {
    CHROME("CHROME"),
    FIREFOX("FIREFOX"),
    EDGE("EDGE");

    private final String name;

    BrowserType(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
