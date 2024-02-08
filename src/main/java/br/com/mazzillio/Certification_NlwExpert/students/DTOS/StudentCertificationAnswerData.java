package br.com.mazzillio.Certification_NlwExpert.students.DTOS;

import java.util.List;

public record StudentCertificationAnswerData(String email, String technology,
                                             List<QuestionAnswerData> questionsAnswers) {
}
