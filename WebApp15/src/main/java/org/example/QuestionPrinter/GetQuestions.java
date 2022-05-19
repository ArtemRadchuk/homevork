package org.example.QuestionPrinter;

import org.example.Reader.CsvReaderImpl;

import java.io.IOException;

public interface GetQuestions {
    void getQuestions(CsvReaderImpl reader) throws IOException;
}
