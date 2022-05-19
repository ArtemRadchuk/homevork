package org.example.Reader;

import org.example.Question;

import java.io.IOException;
import java.util.List;

public interface CsvReader {
    List<Question> readCsv() throws IOException;
}
