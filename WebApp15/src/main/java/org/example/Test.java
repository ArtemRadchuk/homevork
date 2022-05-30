package org.example;

import org.example.service.QuestionServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.net.URISyntaxException;

public class Test {

    public static void main(String[] args) throws IOException, URISyntaxException {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        QuestionServiceImpl service = applicationContext.getBean("view", QuestionServiceImpl.class);
        service.getQuestions(service.getReader());
    }
}
