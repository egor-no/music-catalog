package com.testproject.learningspring;

import com.testproject.learningspring.data.entity.*;
import com.testproject.learningspring.data.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class LearningspringApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearningspringApplication.class, args);
    }


}
