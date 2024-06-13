package org.example.services.reaccionesAnteExcepciones;

import org.example.exceptions.ICustomException;
import org.example.utils.logger.Error;
import org.example.utils.logger.Logger;

import java.time.LocalDateTime;

public class ReaccionLoggearError implements IReaccionAnteExcepcionRenaper {
    Logger logger;


    @Override
    public void reaccionar(ICustomException ex) {
        logger.log(new Error(ex.getCustomMessage(), ex.getCustomStackTrace(), LocalDateTime.now()));
    }
}
