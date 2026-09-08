package cr.ac.una.est.minidiscord.business.service;

import cr.ac.una.est.minidiscord.business.model.Message;
import cr.ac.una.est.minidiscord.business.model.User;

public class ChatService {

    // La validación de negocio rechaza textos vacíos lanzando una excepción lógica.
    // La capa de negocio NUNCA debe invocar ni modificar componentes de la vista directamente.
    public Message processMessage (User sender, String text) {
        if (text==null || text.trim().isEmpty()) {
            throw new IllegalArgumentException("El mensaje no puede estar vacío");
        }
        return new Message(sender, text.trim());
    }
}
