package br.com.mazzillio.Certification_NlwExpert.students.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswersCertifications {
    private UUID id;

    private UUID certificationId;
    private UUID studentId;
    private UUID questionId;
    private UUID answerId;
    private boolean isCorrect;
}
