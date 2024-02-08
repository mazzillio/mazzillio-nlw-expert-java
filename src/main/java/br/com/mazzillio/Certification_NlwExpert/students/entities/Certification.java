package br.com.mazzillio.Certification_NlwExpert.students.entities;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "certifications")
@Builder
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100)
    private String technology;

    @Column(length = 10)
    private int grate;

    @Column(name = "student_id")
    private UUID studentId;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "certification")
    @Column(name = "answer_certification_id", insertable = false, updatable = false)
    @JsonManagedReference
    private List<AnswerCertification> answersCertifications;

}
