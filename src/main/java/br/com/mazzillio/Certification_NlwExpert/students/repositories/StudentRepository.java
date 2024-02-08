package br.com.mazzillio.Certification_NlwExpert.students.repositories;

import br.com.mazzillio.Certification_NlwExpert.students.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StudentRepository extends JpaRepository<Student, UUID> {
    public Optional<Student> findByEmail(String email);
}
