/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.dao;

import ec.edu.espe.arqsoftware.Examen3P.model.Curso;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author valen
 */
public interface CursoRepository extends MongoRepository<Curso, String>{
    
    List<Curso>findByAreaAndFechaInicioBetween(String area, LocalDate fechaInicio, LocalDate fechaAhora);
    List<Curso>findByNombreLikeAndFechaInicioBetween(String nombre, LocalDate fechaInicio, LocalDate fechaAhora);
    
}
