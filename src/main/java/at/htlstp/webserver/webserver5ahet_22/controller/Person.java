package at.htlstp.webserver.webserver5ahet_22.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter @AllArgsConstructor
public class Person {

    private String nachname;

    private String vorname;

    private Date geburtstag;

    private String ort;
}
