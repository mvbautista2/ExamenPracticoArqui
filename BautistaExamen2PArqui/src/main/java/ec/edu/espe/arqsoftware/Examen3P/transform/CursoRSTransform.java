/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.transform;

import ec.edu.espe.arqsoftware.Examen3P.dto.CursoRS;
import ec.edu.espe.arqsoftware.Examen3P.model.Curso;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author valen
 */
public class CursoRSTransform {
    public static CursoRS buildTransformRS(Curso curso) {
        LocalDate fechaInicio = curso.getFechaInicio();

        return CursoRS.builder()
                .codigo(curso.getCodigo())
                .area(curso.getArea())
                .costo(curso.getCosto())
                .duracionHoras(curso.getDuracionHoras())
                .fechaInicio(curso.getFechaInicio())
                .nombre(curso.getNombre())
                .build();
    }
    
}
