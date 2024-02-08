package br.com.mazzillio.Certification_NlwExpert.students.services;

import br.com.mazzillio.Certification_NlwExpert.questions.entities.Alternatives;
import br.com.mazzillio.Certification_NlwExpert.questions.entities.Question;
import br.com.mazzillio.Certification_NlwExpert.questions.repositories.QuestionRepository;
import br.com.mazzillio.Certification_NlwExpert.students.DTOS.StudentCertificationAnswerData;
import br.com.mazzillio.Certification_NlwExpert.students.DTOS.VerifyData;
import br.com.mazzillio.Certification_NlwExpert.students.entities.AnswerCertification;
import br.com.mazzillio.Certification_NlwExpert.students.entities.Certification;
import br.com.mazzillio.Certification_NlwExpert.students.entities.Student;
import br.com.mazzillio.Certification_NlwExpert.students.repositories.CertificationRepository;
import br.com.mazzillio.Certification_NlwExpert.students.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class StudentCertificationAnswersService {


    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CertificationRepository certificationRepository;

    @Autowired
    private VerifyIsHasCertificationService verifyIsHasCertificationService;

    public Certification execute(StudentCertificationAnswerData data) throws Exception {

        var hasCertification = verifyIsHasCertificationService.execute(new VerifyData(data.email(), data.technology()));
        if (hasCertification) {
            throw new Exception("Voce já tirou essa certificação");
        }
        List<Question> questions = questionRepository.findByTechnology(data.technology());
        List<AnswerCertification> answerCertifications = new ArrayList<>();
        AtomicInteger grades = new AtomicInteger(0);
        data.questionsAnswers().forEach(questionAnswer -> {
            var questionSelect = questions.stream().filter(
                            question -> question.getId().equals(questionAnswer.getQuestionId())
                    )
                    .findFirst().get();
            var correctAlternative = questionSelect.getAlternatives().stream().filter(Alternatives::isCorrect).findFirst().get();
            boolean isCorrect = correctAlternative.getId().equals(questionAnswer.getAnswerId());
            answerCertifications.add(AnswerCertification.builder()
                    .answerId(questionAnswer.getAnswerId())
                    .questionId(questionAnswer.getQuestionId())
                    .isCorrect(isCorrect)
                    .build());
            if (isCorrect) grades.getAndIncrement();
        });
        Optional<Student> existStudent = studentRepository.findByEmail(data.email());
        UUID studentId;
        if (existStudent.isEmpty()) {
            Student student = studentRepository.save(Student.builder().email(data.email()).build());
            studentId = student.getId();
        } else {
            studentId = existStudent.get().getId();
        }

        Certification certification = Certification.builder()
                .studentId(studentId)
                .technology(data.technology())
                .grate(grades.get())
                .build();
        var certificationCreated = certificationRepository.save(certification);

        answerCertifications.forEach(answerCertification -> {
            answerCertification.setCertificationId(certificationCreated.getId());
            answerCertification.setStudentId(studentId);
        });
        certificationCreated.setAnswersCertifications(answerCertifications);
        certificationRepository.save(certificationCreated);
        return certificationCreated;
    }
}
