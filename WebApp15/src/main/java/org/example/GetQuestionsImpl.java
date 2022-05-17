package org.example;

import java.io.IOException;

public class GetQuestionsImpl implements GetQuestions {
    CsvReaderImpl reader;

    public GetQuestionsImpl(CsvReaderImpl reader) {
        this.reader = reader;
    }

    public void getQuestionsImpl(CsvReaderImpl reader) throws IOException {
        reader.readCsv();
        for (Question question: reader.questionsList) {
            System.out.println( "Question: \n" + question.getQuestion() + "?");
            System.out.println("Answer options: \n" + question.getAnswerOption() + "\n\n");
        }
    }
}
