/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.controller;

import ec.edu.espe.arqsoftware.Examen3P.dto.CursoRS;
import ec.edu.espe.arqsoftware.Examen3P.model.Curso;
import ec.edu.espe.arqsoftware.Examen3P.service.CursoService;
import static ec.edu.espe.arqsoftware.Examen3P.transform.CursoRSTransform.buildTransformRS;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author valen
 */

@RestController
@RequestMapping("/api/curso")
@Slf4j
public class CursoController {
    
    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    
    
    @GetMapping(value = "area/{area}")
    public ResponseEntity obtenerPorArea(@PathVariable("area") String area) {
          LocalDate fechaAhora = LocalDate.now(ZoneId.of("America/Chicago"));
        List<CursoRS> cursosRS = new ArrayList<>();
        String errorMessage = "Error en la consulta de cursos";
        try {
            Curso curso = new Curso();
            LocalDate fechaInicio = curso.getFechaInicio();
            List<Curso> cursos = this.cursoService.obtenerPorArea(area);
            log.info("Cursos obtenidos {} con los parametros: {} - {}",
                    cursos.size(), fechaInicio, fechaAhora);
            cursos.forEach(c -> {
                cursosRS.add(buildTransformRS(c));
            });
        } catch (Exception e) {
           
            return ResponseEntity.badRequest().body(e);
        }

        return ResponseEntity.ok(cursosRS);
    }
    
    @GetMapping(value = "nombre/{nombre}")
    public ResponseEntity obtenerPorNombreSimilar(@PathVariable("nombre") String nombre) {
        LocalDate fechaAhora = LocalDate.now(ZoneId.of("America/Chicago"));
        List<CursoRS> cursosRS = new ArrayList<>();
        String errorMessage = "Error en la consulta de cursos";
        try {
            Curso curso = new Curso();
            LocalDate fechaInicio = curso.getFechaInicio();
            List<Curso> cursos = this.cursoService.obtenerPorNombreSimilar(nombre);
            log.info("Cursos obtenidos {} con los parametros: {} - {}",
                    cursos.size(), fechaInicio, fechaAhora);
            cursos.forEach(c -> {
                cursosRS.add(buildTransformRS(c));
            });
        } catch (Exception e) {
           
            return ResponseEntity.badRequest().body(e);
        }

        return ResponseEntity.ok(cursosRS);
    }
    
}
