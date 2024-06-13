package org.example.services.reaccionesAnteExcepciones;

import org.example.exceptions.ICustomException;
import org.example.utils.ConfigReader;

public class ReaccionEnviarMail implements IReaccionAnteExcepcionRenaper {
    private IEnviadorMail enviadorMail;
    private String mail;
    private ConfigReader configReader;

    @Override
    public void reaccionar(ICustomException ex) {
        enviadorMail.enviarMail(
                "Excepcion en la llamada al servicio de RENAPER",
                ex.getCustomMessage(),
                mail
        );
    }
}
