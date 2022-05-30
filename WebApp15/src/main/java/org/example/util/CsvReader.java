package org.example.util;

import org.example.domain.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    private ResourceLoader resourceLoader;
    public String url;
    public List<Question> questionsList = new ArrayList<>();

    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public CsvReader(String url) {
        this.url = url;
    }


    public List<Question> readCsv() throws IOException {
        resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("file:" + url);
        File file = resource.getFile();
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        String line = reader.readLine();
        while (line != null) {
            String question = line.substring(0, line.indexOf(","));
            String answers = line.substring(line.indexOf(",") + 1, line.indexOf(";"));
            String[] allAnswer = answers.split(",");
            String rightAnswer = null;
            String[] option = new String[allAnswer.length - 1];
            for (int i = 0; i < allAnswer.length; i++) {
                if (i < allAnswer.length - 1) {
                    option[i] = (allAnswer[i].trim());
                }
                if (i == allAnswer.length - 1) {
                    rightAnswer = allAnswer[i];
                }
            }

            questionsList.add(new Question(question, option, rightAnswer));
            line = reader.readLine();
        }
        return questionsList;
    }
}
