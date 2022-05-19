package org.example;

import org.example.QuestionPrinter.GetQuestionsImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
        GetQuestionsImpl view = a.getBean("view", GetQuestionsImpl.class);
        view.getQuestions(view.getReader());
    }
}
