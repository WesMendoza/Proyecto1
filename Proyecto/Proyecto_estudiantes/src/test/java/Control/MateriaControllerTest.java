
package control;

import Model.Materia;
import Util.Validaciones;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Axell Castro
 */
public class MateriaControllerTest {
    
    
    @Test
    public void testAgregarMateriaCamposVacios() {
        System.out.println("Validar agregar materia con campos vacíos");
        String nombre = "";
        String creditos = "4";
        String profesor = "Profesor A";
        String descripcion = "Curso de Matemáticas Avanzadas";
        MateriaController instance = new MateriaController();
        String expResult = "Campos vacíos";
        String result = instance.addMateria(nombre, creditos, profesor, descripcion);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAgregarMateriaExitosamente() {
        System.out.println("Validar agregar materia exitosamente");
        String nombre = "Física";
        String creditos = "3";
        String profesor = "Profesor C";
        String descripcion = "Curso de Física Básica";
        MateriaController instance = new MateriaController();
        String expResult = "Materia agregada exitosamente.";
        String result = instance.addMateria(nombre, creditos, profesor, descripcion);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testActualizarMateriaExistente() {
        System.out.println("Validar actualizar materia existente");
        int id = 1;
        String nombre = "Matemáticas II";
        String creditos = "4";
        String profesor = "Profesor A";
        String descripcion = "Curso de Matemáticas Intermedias";
        MateriaController instance = new MateriaController();
        String expResult = "Materia actualizada exitosamente.";
        String result = instance.updateMateria(id, nombre, creditos, profesor, descripcion);
        assertEquals(expResult, result);
        Materia updatedMateria = instance.getMateriaById(id);
        assertEquals("Matemáticas II", updatedMateria.getNombre());
    }
    
    @Test
    public void testActualizarMateriaNoExistente() {
        System.out.println("Validar actualizar materia no existente");
        int id = 99;
        String nombre = "Física";
        String creditos = "3";
        String profesor = "Profesor C";
        String descripcion = "Curso de Física Básica";
        MateriaController instance = new MateriaController();
        String expResult = "Materia no encontrada.";
        String result = instance.updateMateria(id, nombre, creditos, profesor, descripcion);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEliminarMateriaExistente() {
        System.out.println("Validar eliminar materia existente");
        int id = 1;
        MateriaController instance = new MateriaController();
        String expResult = "Materia eliminada exitosamente.";
        String result = instance.deleteMateria(id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEliminarMateriaNoExistente() {
        System.out.println("Validar eliminar materia no existente");
        int id = 99;
        MateriaController instance = new MateriaController();
        String expResult = "Materia no encontrada.";
        String result = instance.deleteMateria(id);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testValidarMateriaNombreInvalido() {
        System.out.println("Validar materia con nombre inválido");
        Validaciones instance = new Validaciones();
        String result = instance.validarMateria("Matemat1cas", "4", "Profesor A", "Curso de Matemáticas Avanzadas");
        assertEquals("Nombre: Solo permite letras.", result);
    }
    
    @Test
    public void testValidarMateriaCreditosInvalidos() {
        System.out.println("Validar materia con créditos inválidos");
        Validaciones instance = new Validaciones();
        String result = instance.validarMateria("Matemáticas", "4a", "Profesor A", "Curso de Matemáticas Avanzadas");
        assertEquals("Creditos: Solo permite números.", result);
    }
    
}
