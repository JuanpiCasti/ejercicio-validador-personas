package org.example.external;

import org.example.exceptions.ServicioRenaperException;

public interface IAdapterServicioRenaper {
    Boolean verificarExistenciaPersona(int dni, String nombre) throws ServicioRenaperException;
}
