package org.example;

import java.io.IOException;

public interface GetQuestions {
    void getQuestionsImpl(CsvReaderImpl reader) throws IOException;
}
