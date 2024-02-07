package br.com.mazzillio.Certification_NlwExpert.questions.dto;

import br.com.mazzillio.Certification_NlwExpert.questions.entities.Question;

import java.util.List;
import java.util.UUID;

public record QuestionResult(UUID id, String technology, String Description, List<AlternativesResult> alternatives) {

    public QuestionResult(Question question) {
        this(question.getId(), question.getTechnology(), question.getDescription(), question.getAlternatives().stream().map(AlternativesResult::new).toList());
    }
}
