/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.service;

import ec.edu.espe.arqsoftware.Examen3P.dao.EstudianteRepository;
import ec.edu.espe.arqsoftware.Examen3P.model.Estudiante;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author valen
 */
@ExtendWith(MockitoExtension.class)
public class EstudianteServiceTest {
    
    
    @Mock
    private EstudianteRepository estudianteRepo;
    
    @InjectMocks
    private EstudianteService estudianteService;
    
    private Estudiante estudiante;
    
    private List<Estudiante> estudianteList;  
    
    @BeforeEach
    public void setUp() {
        this.estudiante = new Estudiante();
        estudiante.setCorreoElectrónico("valentina@hotmail.com");
        estudiante.setEstado("ECU");
        estudiante.setFechaCreacion(LocalDate.now());
        estudiante.setNombre("Valentina");
        
        this.estudianteList = new ArrayList<>();
        this.estudianteList.add(estudiante);
    }

    /**
     * Test of listarPorCorreoElectronico method, of class EstudianteService.
     */
    @Test
    public void testListarPorCorreoElectronico() {
        System.out.println("listarPorCorreoElectronico");
        String correoElectronico = "";
        EstudianteService instance = null;
        List<Estudiante> expResult = null;
        List<Estudiante> result = instance.listarPorCorreoElectronico(correoElectronico);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crearEstudiante method, of class EstudianteService.
     */
    @Test
    public void testCrearEstudiante() {
       lenient().when(estudianteRepo.save(estudiante)).thenReturn(estudiante);
        try {
            verify(estudianteService).crearEstudiante(estudiante);
        } catch (Exception e) {
            Logger.getLogger(EstudianteServiceTest.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }
    
}
