package be.technobel.api.models.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Setter @Getter
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipement_id", nullable = false)
    private Long id;

    @Column( nullable = false)
    private String name;

    @ManyToMany(mappedBy = "equipments")
    private Set<Classroom> classrooms = new LinkedHashSet<>();

    @ManyToMany(mappedBy = "equipments")
    private Set<Request> requests = new LinkedHashSet<>();

}
