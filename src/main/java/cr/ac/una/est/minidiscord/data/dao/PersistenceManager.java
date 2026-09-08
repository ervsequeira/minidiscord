package cr.ac.una.est.minidiscord.data.dao;

// Nuevo de la clase 8 (opcional): archivo completo — Singleton que centraliza el acceso al MessageDAO
public class PersistenceManager {

    private static PersistenceManager instancia;
    private final MessageDAO dao;

    // Constructor PRIVADO: nadie fuera de esta clase puede hacer "new PersistenceManager()"
    private PersistenceManager() {
        this.dao = new MessageDAO();
    }

    public static synchronized PersistenceManager getInstance() {
        if (instancia == null) {
            instancia = new PersistenceManager();
        }
        return instancia;
    }

    public MessageDAO getMessageDAO() { return dao; }
}
