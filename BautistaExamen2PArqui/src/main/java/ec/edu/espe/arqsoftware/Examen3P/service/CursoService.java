/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.service;

import ec.edu.espe.arqsoftware.Examen3P.dao.CursoRepository;
import ec.edu.espe.arqsoftware.Examen3P.model.Curso;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 * @author valen
 */
@Slf4j
@Service
public class CursoService {

    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<Curso> obtenerPorArea(String area) {
        Curso curso = new Curso();
        LocalDate fechaInicio = curso.getFechaInicio();
        LocalDate fechaAhora = LocalDate.now();
        Period diff = Period.between( fechaInicio, fechaAhora);
        if (fechaInicio.isBefore(fechaAhora) && diff.getMonths() <= 1) {
            return this.cursoRepository.findByAreaAndFechaInicioBetween(area, fechaInicio, fechaAhora);
        } else {
            log.error("No se han encontrado cursos recientes que esten dentro del área: {}", area);
            throw new IllegalArgumentException("Fechas invalidas");
        }

    }

    public List<Curso> obtenerPorNombreSimilar(String nombre) {
        Curso curso = new Curso();
        LocalDate fechaInicio = curso.getFechaInicio();
        LocalDate fechaAhora = LocalDate.now();
        Period diff = Period.between( fechaInicio, fechaAhora);
        if (fechaInicio.isBefore(fechaAhora) && diff.getMonths() <= 1) {
            return this.cursoRepository.findByNombreLikeAndFechaInicioBetween(nombre, fechaInicio, fechaAhora);
        } else {
            log.error("No se han encontrado cursos recientes que tengan un nombre similar a: {}", nombre);
            throw new IllegalArgumentException("Fechas invalidas");
        }
    }
}
