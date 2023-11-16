package com.uu.kiwii.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "subjects")
@NoArgsConstructor
@AllArgsConstructor
public class Subject {

    @Id
    @Nonnull
    private String id;

    private String name;

    @Column(columnDefinition = "text[]")
    private List<String> rm;

    @Column(columnDefinition = "text[]")
    private List<String> links;
}
