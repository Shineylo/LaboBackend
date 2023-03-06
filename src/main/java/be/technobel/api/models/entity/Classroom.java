package be.technobel.api.models.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter @Getter
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private int capacity;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean teacherOnly;

    @OneToMany(mappedBy = "classroom")
    private Set<Request> request;

    @ManyToMany
    @JoinTable(name = "classrooms_equipement",
            joinColumns = @JoinColumn(name = "classroom_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id"))
    private Set<Equipment> equipments = new LinkedHashSet<>();

}
