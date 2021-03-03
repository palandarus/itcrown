package ru.itcrown.models;

import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class DocumentTransport {

    private static DocumentTransport instance;
    private final String server = "address";
    private final String port = "port";
    private final String login = "login";
    private final String password = "password";

    private DocumentTransport() {
    }

    public DocumentTransport getInstance() {
        if (instance == null) {
            synchronized (DocumentTransport.class) {
                if (instance == null) instance = new DocumentTransport();
            }
        }
        return instance;
    }
}
