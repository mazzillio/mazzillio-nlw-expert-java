package br.com.mazzillio.Certification_NlwExpert.questions.controllers;

import br.com.mazzillio.Certification_NlwExpert.questions.dto.QuestionResult;
import br.com.mazzillio.Certification_NlwExpert.questions.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/technology/{technology}")
    public List<QuestionResult> findByTechnology(@PathVariable String technology) {
        return questionRepository.findByTechnology(technology).stream().map(QuestionResult::new).toList();
    }
}
