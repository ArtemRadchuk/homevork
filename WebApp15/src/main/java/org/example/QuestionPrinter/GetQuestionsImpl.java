package org.example.QuestionPrinter;

import org.example.Question;
import org.example.Reader.CsvReaderImpl;

import java.io.IOException;
import java.util.Scanner;

public class GetQuestionsImpl implements GetQuestions {
CsvReaderImpl reader;

    public GetQuestionsImpl(CsvReaderImpl reader) {
        this.reader = reader;
    }

    public CsvReaderImpl getReader() {
        return reader;
    }

    @Override
    public void getQuestions(CsvReaderImpl reader) throws IOException {
        reader.readCsv();
        int i = 0;
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
                i++;
                System.out.println(i);
            }
        }
    System.out.println(i + " Ответов из 5 верны");
    }
}
