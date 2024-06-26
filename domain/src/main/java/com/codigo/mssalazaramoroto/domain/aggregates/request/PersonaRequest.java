package com.codigo.mssalazaramoroto.domain.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonaRequest {
    private String tipoDoc;
    private String numDoc;
    private String email;
    private String telefono;
    private String direccion;
    private String empresa;
}
