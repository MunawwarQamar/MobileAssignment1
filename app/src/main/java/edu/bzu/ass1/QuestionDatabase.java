package edu.bzu.ass1;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionDatabase {
    private String question, option1, option2, option3, option4, rightOption;
      final ArrayList<QuestionDatabase> questionList;

    public QuestionDatabase() {
        ArrayList<QuestionDatabase> tempList = new ArrayList<>();
        tempList.add(new QuestionDatabase("İki Yüz", "Two Hundred", "Twenty", "Twelve", "Two Thousand", "Two Hundred"));
        tempList.add(new QuestionDatabase("Mor", "Green", "Red", "Black", "Purple", "Purple"));
        tempList.add(new QuestionDatabase("Yüz Milyon", "One Hundred Thousand", "One Billion", "One Hundred Million", "Ten Thousand", "One Hundred Million"));
        tempList.add(new QuestionDatabase("Mavi", "Gold", "Blue", "Gray", "Yellow", "Blue"));

        tempList.add(new QuestionDatabase("Teyze", "Aunt", "Uncle", "Brother", "Sister", "Aunt"));
        tempList.add(new QuestionDatabase("Kardeş", "Sister", "Brother", "Mother", "Father", "Brother"));
        tempList.add(new QuestionDatabase("Dört", "Five", "Four", "one", "Seven", "Four"));
        tempList.add(new QuestionDatabase("Anne", "Father", "Mother", "Brother", "Sister", "Mother"));
        tempList.add(new QuestionDatabase("Turuncu", "Orange", "Blue", "Red", "Yellow", "Orange"));
        tempList.add(new QuestionDatabase("Kahverengi", "Gold", "Brown", "Gray", "Yellow", "Brown"));

        questionList = new ArrayList<>(Collections.unmodifiableList(tempList));
    }

    public QuestionDatabase(String question, String option1, String option2, String option3, String option4, String rightOption) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.rightOption = rightOption;
        this.questionList = null;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getRightOption() {
        return rightOption;
    }

    public void setRightOption(String rightOption) {
        this.rightOption = rightOption;
    }

    public ArrayList<QuestionDatabase> getQuestionList() {
        return questionList;
    }
}
