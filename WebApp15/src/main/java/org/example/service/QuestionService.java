package org.example.service;

import org.example.util.CsvReaderImpl;

import java.io.IOException;

public interface QuestionService {
    void getQuestions(CsvReaderImpl reader) throws IOException;
}
