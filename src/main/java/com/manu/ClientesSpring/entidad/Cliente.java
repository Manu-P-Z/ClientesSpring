package com.manu.ClientesSpring.entidad;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class Cliente{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String nombre;
    @Column
    private String apellidos;
    @Column
    private String category;
    @Column
    private float limite_credito;
    @Column(name = "fecha_creacion")
    private LocalDateTime creationDate;

}
