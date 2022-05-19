package org.example;

import org.example.service.QuestionServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

public class Test {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionServiceImpl view = a.getBean("view", QuestionServiceImpl.class);
        view.getQuestions(view.getReader());
    }
}
