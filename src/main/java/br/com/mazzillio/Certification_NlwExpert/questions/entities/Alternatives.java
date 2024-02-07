package br.com.mazzillio.Certification_NlwExpert.questions.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "alternatives")
public class Alternatives {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String description;

    @Column(name = "is_correct")
    private boolean isCorrect;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;


}
