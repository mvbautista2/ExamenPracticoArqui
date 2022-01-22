/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.service;

import ec.edu.espe.arqsoftware.Examen3P.dao.CursoRepository;
import ec.edu.espe.arqsoftware.Examen3P.model.Curso;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author valen
 */
public class CursoServiceTest {
    
    @Mock
    private CursoRepository cursoRepository;
    
    @InjectMocks
    private CursoService cursoService;
    
    private Curso curso;
    
    private List<Curso> cursoList;
    @BeforeEach
    public void setUp() {
        this.curso = new Curso();
        curso.setArea("Informatica");
        curso.setCodigo("L01");
        curso.setCosto(new BigDecimal("1800.50"));
        curso.setDuracionHoras(5);
        curso.setFechaInicio(LocalDate.now());
        curso.setNombre("Data Mining");
        
        this.cursoList = new ArrayList<>();
        this.cursoList.add(curso);
    }

    /**
     * Test of obtenerPorArea method, of class CursoService.
     */
    @Test
    public void testObtenerPorArea() {
         when(cursoRepository.findByAreaAndFechaInicioBetween("Info", LocalDate.now(), LocalDate.now())).thenReturn(cursoList);
        try {
            Assertions.assertEquals(curso, cursoService.obtenerPorArea("Info"));
        } catch (Exception e) {
            Logger.getLogger(CursoServiceTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * Test of obtenerPorNombreSimilar method, of class CursoService.
     */
    @Test
    public void testObtenerPorNombreSimilar() {
         when(cursoRepository.findByNombreLikeAndFechaInicioBetween("Data Mining", LocalDate.now(), LocalDate.now())).thenReturn(cursoList);
        try {
            Assertions.assertEquals(curso, cursoService.obtenerPorNombreSimilar("Data Mining"));
        } catch (Exception e) {
            Logger.getLogger(CursoServiceTest.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
}
