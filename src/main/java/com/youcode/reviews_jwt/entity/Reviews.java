package com.youcode.reviews_jwt.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "reviews")
@Builder
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column
    private String title;
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate date;
    private String message;
    @Column(columnDefinition = "integer default 1")
    private Integer reactions;
    @Column(columnDefinition = "boolean default false")
    private Boolean reported;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private OurUsers user;
}
