package com.students.backend.backendstudentsapirest.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idEstudiante;

    @Column
    private Integer documento;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String curso;

    @Column
    private String jornada;

}
