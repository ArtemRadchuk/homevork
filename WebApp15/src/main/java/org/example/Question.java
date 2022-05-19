package org.example;

import java.util.List;

public class Question {
    private String question;
    private String[] answerOption;
    private String rightAnswer;

    public Question(String question, String[] answerOption, String rightAnswer) {
        this.question = question;
        this.rightAnswer = rightAnswer;
        this.answerOption = answerOption;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(String[] answerOption) {
        this.answerOption = answerOption;
    }
}
