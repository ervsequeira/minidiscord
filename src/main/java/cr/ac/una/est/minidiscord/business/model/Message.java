package cr.ac.una.est.minidiscord.business.model;

import java.io.Serializable;

public class Message implements Serializable {

    private final User author;
    private final String content;

    public Message (User author, String content) {
        this.author=author;
        this.content=content;
    }

    @Override
    public String toString() {
        return author.getUsername() + ":" + content;
    }

}

