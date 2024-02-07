package br.com.mazzillio.Certification_NlwExpert.students.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "student")
    private List<Certification> certifications;

    @OneToMany(mappedBy = "student")
    private List<AnswerCertification> answerCertifications;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

}
