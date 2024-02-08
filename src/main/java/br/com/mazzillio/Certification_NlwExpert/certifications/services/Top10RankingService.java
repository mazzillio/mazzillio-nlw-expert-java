package br.com.mazzillio.Certification_NlwExpert.certifications.services;


import br.com.mazzillio.Certification_NlwExpert.students.entities.Certification;
import br.com.mazzillio.Certification_NlwExpert.students.repositories.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Top10RankingService {

    @Autowired
    private CertificationRepository certificationRepository;
    public List<Certification> execute(){
        return certificationRepository.findTop10ByOrderByGrateDesc();
    }
}
