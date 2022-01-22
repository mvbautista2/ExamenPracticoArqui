/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.model;

import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author valen
 */

@Data
public class Estudiante {
    
    @Id
    private String id;
    private String nombre;
    private String correoElectrónico;
    private String pais;
    private LocalDate fechaNacimiento;
    private LocalDate fechaCreacion;
    private String estado;
    
}
