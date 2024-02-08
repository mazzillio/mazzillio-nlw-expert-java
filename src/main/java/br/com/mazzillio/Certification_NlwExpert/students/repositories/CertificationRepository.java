package br.com.mazzillio.Certification_NlwExpert.students.repositories;

import br.com.mazzillio.Certification_NlwExpert.students.entities.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface CertificationRepository extends JpaRepository<Certification, UUID> {

    @Query("select c from certifications c INNER JOIN c.student std where std.email =:email and c.technology =:technology")
    List<Certification> findByStudentAndTechnology(String email, String technology);

    List<Certification> findTop10ByOrderByGrateDesc();
}
