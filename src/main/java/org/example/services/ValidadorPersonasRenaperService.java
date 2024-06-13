package org.example.services;

import org.example.DTOs.PersonaDTO;
import org.example.exceptions.ServicioRenaperException;
import org.example.external.IAdapterServicioRenaper;
import org.example.model.entitites.Persona;
import org.example.model.factories.PersonaFactory;
import org.example.model.repositories.IPersonaRepository;
import org.example.services.reaccionesAnteExcepciones.IReaccionAnteExcepcionRenaper;

import java.util.Collections;
import java.util.List;

public class ValidadorPersonasRenaperService implements IValidadorPersonasService {

    private IAdapterServicioRenaper servicioRenaper;
    private List<IReaccionAnteExcepcionRenaper> reaccionesAnteExcepciones;
    private IPersonaRepository personaRepository;

    public void agregarReacciones(IReaccionAnteExcepcionRenaper ... reacciones) {
        Collections.addAll(this.reaccionesAnteExcepciones, reacciones);
    }

    public void crearPersona(PersonaDTO personaDTO) {
        try {
            this.servicioRenaper.verificarExistenciaPersona(personaDTO.getDni(), personaDTO.getSexo());
            Persona nuevaPersona = PersonaFactory.crearAPartirDe(personaDTO);
            personaRepository.save(nuevaPersona);
        } catch (ServicioRenaperException e) {
            reaccionesAnteExcepciones.parallelStream().forEach(reaccion -> reaccion.reaccionar(e));
        }
    }
}
