package org.example.model.factories;

import org.example.DTOs.PersonaDTO;
import org.example.model.entitites.Persona;
import org.example.model.entitites.Sexo;

public class PersonaFactory {
    public static Persona crearAPartirDe(PersonaDTO personaDTO) {
        Persona persona = new Persona();
        persona.setNombre(personaDTO.getNombre());
        persona.setApellido(personaDTO.getApellido());
        persona.setDni(persona.getDni());
        persona.setSexo(Sexo.valueOf(personaDTO.getSexo()));
        return persona;
    }
}
