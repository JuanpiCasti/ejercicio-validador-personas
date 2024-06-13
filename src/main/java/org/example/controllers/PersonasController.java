package org.example.controllers;

import org.example.DTOs.PersonaDTO;
import org.example.services.IValidadorPersonasService;

public class PersonasController {
    private IValidadorPersonasService validadorPersonas;

    public PersonasController(IValidadorPersonasService validadorPersonas) {
        this.validadorPersonas = validadorPersonas;
    }

    public void crearPersona(Object request) {

        PersonaDTO personaDTO = (PersonaDTO) request;

        validadorPersonas.crearPersona(personaDTO);

    }
}
