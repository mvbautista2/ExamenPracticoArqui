/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 *
 * @author valen
 */
@Data
public class Curso {
    
    @Id
    private String id;
    private String codigo;
    private String area;
    private String nombre;
    private Integer duracionHoras;
    private LocalDate fechaInicio;
    private BigDecimal costo;
}
