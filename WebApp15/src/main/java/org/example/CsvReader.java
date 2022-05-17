package org.example;

import java.io.IOException;
import java.util.List;

public interface CsvReader {
    public List<Question> readCsv() throws IOException;
}
