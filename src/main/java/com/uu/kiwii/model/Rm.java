package com.uu.kiwii.model;

import java.util.List;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rm {

    @Id
    @Nonnull
    private String id;

    private String name;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "rm_subject", 
        joinColumns = @JoinColumn(name = "rm_id"), 
        inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<Subject> subjects;

    @OneToMany(mappedBy = "rm", cascade = CascadeType.ALL)
    private List<Link> links;
}
