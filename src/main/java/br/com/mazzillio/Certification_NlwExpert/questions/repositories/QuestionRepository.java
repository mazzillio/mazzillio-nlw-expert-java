package br.com.mazzillio.Certification_NlwExpert.questions.repositories;

import br.com.mazzillio.Certification_NlwExpert.questions.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    List<Question> findByTechnology(String technology);
}
