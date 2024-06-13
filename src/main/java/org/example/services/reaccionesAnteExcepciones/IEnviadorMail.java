package org.example.services.reaccionesAnteExcepciones;

public interface IEnviadorMail {
    public void enviarMail(String asunto, String mensaje, String destinatario);
}
