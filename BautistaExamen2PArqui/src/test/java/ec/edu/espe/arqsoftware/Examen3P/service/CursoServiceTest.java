/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arqsoftware.Examen3P.service;

import ec.edu.espe.arqsoftware.Examen3P.model.Curso;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author valen
 */
public class CursoServiceTest {
    
    public CursoServiceTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }

    /**
     * Test of obtenerPorArea method, of class CursoService.
     */
    @Test
    public void testObtenerPorArea() {
        System.out.println("obtenerPorArea");
        String area = "";
        CursoService instance = null;
        List<Curso> expResult = null;
        List<Curso> result = instance.obtenerPorArea(area);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of obtenerPorNombreSimilar method, of class CursoService.
     */
    @Test
    public void testObtenerPorNombreSimilar() {
        System.out.println("obtenerPorNombreSimilar");
        String nombre = "";
        CursoService instance = null;
        List<Curso> expResult = null;
        List<Curso> result = instance.obtenerPorNombreSimilar(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
