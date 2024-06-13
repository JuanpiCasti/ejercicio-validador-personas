package org.example.model.entitites;

import lombok.Data;

@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int dni;
    private Sexo sexo;
}
