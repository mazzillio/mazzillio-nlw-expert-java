package br.com.mazzillio.Certification_NlwExpert.students.services;

import br.com.mazzillio.Certification_NlwExpert.students.DTOS.VerifyData;
import br.com.mazzillio.Certification_NlwExpert.students.entities.Certification;
import br.com.mazzillio.Certification_NlwExpert.students.repositories.CertificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VerifyIsHasCertificationService {

    @Autowired
    private CertificationRepository certificationRepository;

    public boolean execute(VerifyData data) {
        List<Certification> existsCertification = certificationRepository.findByStudentAndTechnology(data.email(), data.technology());
        return !existsCertification.isEmpty();
    }
}
