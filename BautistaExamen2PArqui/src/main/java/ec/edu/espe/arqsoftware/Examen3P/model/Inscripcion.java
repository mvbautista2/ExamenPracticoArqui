/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author valen
 */
@Data
public class Inscripcion {
    
    @Id
    private String id;
    private String idEstudiante;
    private String idCurso;
}
