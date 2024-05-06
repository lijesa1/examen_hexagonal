package com.codigo.mssalazaramoroto.application.controller;

import com.codigo.mssalazaramoroto.domain.aggregates.dto.EmpresaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.dto.PersonaDto;
import com.codigo.mssalazaramoroto.domain.aggregates.request.EmpresaRequest;
import com.codigo.mssalazaramoroto.domain.aggregates.request.PersonaRequest;
import com.codigo.mssalazaramoroto.domain.ports.in.EmpresaServiceIn;
import com.codigo.mssalazaramoroto.domain.ports.in.PersonaServiceIn;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ms-salazar-amoroto/v1/empresa")
@AllArgsConstructor
public class EmpresaController {
    private final EmpresaServiceIn empresaServiceIn;

    @PostMapping
    public ResponseEntity<EmpresaDto> registrar(@RequestBody EmpresaRequest requestEmpresa) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(empresaServiceIn.crearEmpresaIn(requestEmpresa));
    }

    @GetMapping
    public ResponseEntity<EmpresaDto> buscarEmpresaByNumeroDocumento(@RequestParam String numDoc) {
        return ResponseEntity
                .ok(empresaServiceIn.obtenerEmpresaByNumeroDocumentoIn(numDoc).get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDto> buscarEmpresaById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.buscarXIdIn(id).get());
    }

    @GetMapping("/empresas")
    public ResponseEntity<List<EmpresaDto>> buscarEmpresas() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.obtenerTodosIn());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmpresaDto> actualizar(@PathVariable Long id, @RequestBody EmpresaRequest empresaRequest) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.actualizarIn(id, empresaRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresaDto> delete(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(empresaServiceIn.deleteIn(id));
    }
}
