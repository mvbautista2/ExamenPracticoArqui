/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.service;

import ec.edu.espe.arqsoftware.Examen3P.dao.EstudianteRepository;
import ec.edu.espe.arqsoftware.Examen3P.exception.CreateException;
import ec.edu.espe.arqsoftware.Examen3P.model.Estudiante;
import java.time.LocalDate;
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
public class EstudianteService {
    private final EstudianteRepository estudianteRepo;

    public EstudianteService(EstudianteRepository estudianteRepo) {
        this.estudianteRepo = estudianteRepo;
    }
      
    public List<Estudiante> listarPorCorreoElectronico(String correoElectronico) {
        return this.listarPorCorreoElectronico(correoElectronico);
    }

    
    public void crearEstudiante(Estudiante estudiante) {
        
        
  
        LocalDate fechaCreacion = LocalDate.now(ZoneId.of("America/Chicago"));
      
            List<Estudiante> estudiantes = this.listarPorCorreoElectronico(estudiante.getCorreoElectrónico());
            for (Estudiante e : estudiantes) {
                if (e.getCorreoElectrónico().equals(estudiante.getCorreoElectrónico()) ){
                    throw new CreateException("El estudiante con correo: " + estudiante.getCorreoElectrónico() + " ya existe");
                }
            }
            
        log.info("El estudiante {} ha sido creado con éxito", estudiante.getId().toString());
        
        estudiante.setFechaCreacion(LocalDate.now());
        this.estudianteRepo.save(estudiante);

    }
    
}
