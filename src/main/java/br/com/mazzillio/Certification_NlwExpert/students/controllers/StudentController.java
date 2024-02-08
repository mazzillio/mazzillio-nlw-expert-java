package br.com.mazzillio.Certification_NlwExpert.students.controllers;

import br.com.mazzillio.Certification_NlwExpert.students.DTOS.StudentCertificationAnswerData;
import br.com.mazzillio.Certification_NlwExpert.students.DTOS.VerifyData;
import br.com.mazzillio.Certification_NlwExpert.students.services.StudentCertificationAnswersService;
import br.com.mazzillio.Certification_NlwExpert.students.services.VerifyIsHasCertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private VerifyIsHasCertificationService verifyIsHasCertificationService;

    @Autowired
    private StudentCertificationAnswersService studentCertificationAnswersService;

    @PostMapping("/verifyIfHasCertification")
    public String verifyIfHasCertification(@RequestBody VerifyData data) {
        return verifyIsHasCertificationService.execute(data) ? "Usario não pode fazer a prova" : "Usuario pode fazer a prova";
    }

    @PostMapping("/certification/answer")
    public ResponseEntity<Object> checkQuestions(@RequestBody StudentCertificationAnswerData data) {
        try {
            return ResponseEntity.ok(studentCertificationAnswersService.execute(data));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }


    }
}
