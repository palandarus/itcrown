package ru.itcrown.models;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Getter
public class DocumentTransport {


    private final String server="address";
    private final String port="port";
    private final String login="login";
    private final String password="password";



}
