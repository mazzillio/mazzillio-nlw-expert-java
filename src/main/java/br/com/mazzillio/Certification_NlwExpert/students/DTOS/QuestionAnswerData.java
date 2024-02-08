package br.com.mazzillio.Certification_NlwExpert.students.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionAnswerData {
    private UUID questionId;
    private UUID answerId;
    private boolean isCorrect;
}
