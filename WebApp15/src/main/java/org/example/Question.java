package org.example;

import java.util.List;

public class Question {
    private String question;
    private List<String> answerOption;

    public Question() {
    }

    public Question(String question, List<String> answerOption) {
        this.question = question;

        this.answerOption = answerOption;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(List<String> answerOption) {
        this.answerOption = answerOption;
    }
}
