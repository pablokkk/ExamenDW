package com.example.examendesarrollo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Examen_desarrollo {

    private String nombre;
    private String tipo;
    private Integer duracion;
    private String dificultad;


}
