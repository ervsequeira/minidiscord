package cr.ac.una.est.minidiscord.business.model;

import java.io.Serializable;

// Se implementa Serializable para poder convertir la instancia en bytes.
// Esto hace posible poder almacenarla en disco a futuro.
public class User implements Serializable {

    // La propiedad 'final' hace inmultable al username, no cambiara tras su instancia
    private final String username;
    public User(String username) {
        this.username=username;
    }

    public String getUsername(){
        return username;
    }


}
