package br.com.mazzillio.Certification_NlwExpert.students.entities;

import lombok.*;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Certifications {

    private UUID id;
    private UUID studentId;

    private String technology;

    private int grate;

    private List<AnswersCertifications> answersCertifications;

}
