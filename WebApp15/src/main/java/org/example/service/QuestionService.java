package org.example.service;

import org.example.util.CsvReader;

import java.io.IOException;

public interface QuestionService {
    void getQuestions(CsvReader reader) throws IOException;
}
