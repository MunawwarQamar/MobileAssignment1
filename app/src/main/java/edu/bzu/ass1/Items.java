package edu.bzu.ass1;

import org.jetbrains.annotations.NotNull;

public class Items {
    private String word;
    private String meaningInEng;
    private String meaningInArabic;
    private String category;

    public Items() {
    }

    public Items(String word, String meaningInEng, String meaningInArabic, String category) {
        this.word = word;
        this.meaningInEng = meaningInEng;
        this.meaningInArabic = meaningInArabic;
        this.category = category;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaningInEng() {
        return meaningInEng;
    }

    public void setMeaningInEng(String meaningInEng) {
        this.meaningInEng = meaningInEng;
    }

    public String getMeaningInArabic() {
        return meaningInArabic;
    }

    public void setMeaningInArabic(String meaningInArabic) {
        this.meaningInArabic = meaningInArabic;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @NotNull
    @Override
    public String toString() {
        String msg = getWord() + " : " + getMeaningInEng() +" : "+getMeaningInArabic();
        return msg;
    }
}
