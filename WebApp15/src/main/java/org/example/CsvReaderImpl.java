package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvReaderImpl implements CsvReader {
    private static final String URL = "C:\\Users\\User\\IdeaProjects\\homework\\WebApp15\\src\\main\\resources\\testData.csv";
    List<Question> questionsList = new ArrayList<>();

    public List<Question> readCsv() throws IOException {
        File file = new File(URL);
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (line != null) {
            String question = line.substring(0, line.indexOf(","));
            List<String> option = new ArrayList<>();
            String xs = line.substring(line.indexOf(",") + 1, line.indexOf(";"));
            String[] alf = xs.split(",");
            for (int i = 0; i < alf.length; i++) {
                option.add(alf[i].trim());
            }
            questionsList.add(new Question(question, option));
            line = reader.readLine();
        }
        return questionsList;
    }
}
