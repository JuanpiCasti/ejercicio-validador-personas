package org.example.services.reaccionesAnteExcepciones;

import org.example.exceptions.ICustomException;

public interface IReaccionAnteExcepcionRenaper {
    void reaccionar(ICustomException ex);
}
