package datastructures;

public enum Gender {
    WOMEN("Mrs.", "uniform-id_gender2"),
    MAN("Mr.", "uniform-id_gender1");

    private final String displayedText, divIdValue;

    Gender(String displayedText, String divIdValue) {
        this.displayedText = displayedText;
        this.divIdValue = divIdValue;
    }

    public String getDisplayedText() {
        return this.displayedText;
    }

    public String getDivIdValue() {
        return this.divIdValue;
    }
}
