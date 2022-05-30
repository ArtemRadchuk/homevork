package org.example.service;

import org.example.util.CsvReader;

import java.io.IOException;
import java.net.URISyntaxException;

public interface QuestionService {
    void getQuestions(CsvReader reader) throws IOException, URISyntaxException;
}
