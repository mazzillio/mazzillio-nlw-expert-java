package br.com.mazzillio.Certification_NlwExpert.certifications.controllers;

import br.com.mazzillio.Certification_NlwExpert.certifications.services.Top10RankingService;
import br.com.mazzillio.Certification_NlwExpert.students.entities.Certification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class RankingController  {

    @Autowired
    private Top10RankingService top10RankingService;
    @GetMapping
    public List<Certification> ranking(){
        return top10RankingService.execute();
    }
}
