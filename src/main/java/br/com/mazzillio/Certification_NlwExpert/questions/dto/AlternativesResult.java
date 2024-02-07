package br.com.mazzillio.Certification_NlwExpert.questions.dto;

import br.com.mazzillio.Certification_NlwExpert.questions.entities.Alternatives;

import java.util.UUID;

public record AlternativesResult(UUID id, String description) {
    public AlternativesResult(Alternatives alternatives) {
        this(alternatives.getId(), alternatives.getDescription());
    }
}
