package org.example.service;

import org.example.domain.Question;
import org.example.util.CsvReader;


import java.io.IOException;
import java.util.Scanner;

public class QuestionServiceImpl implements QuestionService {
CsvReader reader;

    public QuestionServiceImpl(CsvReader reader) {
        this.reader = reader;
    }

    public CsvReader getReader() {
        return reader;
    }

    @Override
    public void getQuestions(CsvReader reader) throws IOException {
        reader.readCsv();
        int rightAnswerQuantity = 0;
        for (Question question: reader.questionsList) {
            System.out.println(question.getQuestion() + "?");
            for (int j = 0; j < question.getAnswerOption().length; j++) {
                System.out.println((j+1) + ") " + question.getAnswerOption()[j]);
                if (j == question.getAnswerOption().length-1){
                    System.out.println("");
                }
            }
            int answer = Integer.parseInt(new Scanner(System.in).nextLine());
            if (question.getAnswerOption()[answer-1].trim().equals(question.getRightAnswer().trim())){
                rightAnswerQuantity++;
            }
        }
    System.out.println(rightAnswerQuantity + " Ответов из 5 верны");
    }
}
