package br.com.mazzillio.Certification_NlwExpert.students.services;

import br.com.mazzillio.Certification_NlwExpert.students.DTOS.VerifyData;
import org.springframework.stereotype.Service;

@Service
public class VerifyIsHasCertificationService {
    public boolean execute(VerifyData data) {
        return data.email().equals("mattheus@mail.com") && data.technology().equals("JAVA");
    }
}
