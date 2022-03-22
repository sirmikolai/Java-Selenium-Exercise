package datastructures;

public enum SizeBody {
    S("S"),
    M("M"),
    L("L");

    private final String name;

    SizeBody(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
