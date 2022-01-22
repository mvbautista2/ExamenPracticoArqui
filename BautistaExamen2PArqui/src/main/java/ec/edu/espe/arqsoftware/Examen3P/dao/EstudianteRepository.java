/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.dao;

import ec.edu.espe.arqsoftware.Examen3P.model.Estudiante;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author valen
 */
public interface EstudianteRepository extends MongoRepository<Estudiante, String> {
     List<Estudiante> findByCorreoElectronico(String correoElectronico);
}
