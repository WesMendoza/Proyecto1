package control;

import Model.Materia;
import Util.Validaciones;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Axell Castro
 */
public class MateriaController {

    /**
     * Lista que almacena todas las materias gestionadas por este controlador.
     */
    private final List<Materia> materias;

    /**
     * Instancia de Validaciones para validar datos relacionados con las
     * materias. las materias.
     */
    private final Validaciones validacion;

    /**
     * Constructor de la clase MateriaController. Inicializa la lista de
     * materias y la instancia de Validaciones. Además, agrega algunas materias
     * de ejemplo para propósitos de prueba.
     */
    public MateriaController() {
        this.materias = new ArrayList<>();
        this.validacion = new Validaciones();
    }

    /**
     * Obtiene todas las materias almacenadas.
     *
     * @return Lista de todas las materias.
     */
    public final List<Materia> getAllMaterias() {
        return materias;
    }

    /**
     * Obtiene una materia por su identificador.
     *
     * @param id El identificador de la materia a buscar.
     * @return La materia con el identificador especificado, o null si no se
     * encuentra.
     */
    public final Materia getMateriaById(final int id) {
        for (Materia materia : materias) {
            if (materia.getId() == id) {
                return materia;
            }
        }
        return null;
    }

    /**
     * Agrega una nueva materia.
     *
     * @param nombre El nombre de la materia.
     * @param creditos El número de créditos de la materia.
     * @param profesor El nombre del profesor de la materia.
     * @param descripcion La descripción de la materia.
     * @return Mensaje indicando el resultado de la operación.
     */
    public final String addMateria(
            final String nombre,
            final String creditos,
            final String profesor,
            final String descripcion) {
        String validationResult = validacion.validarMateria(
                nombre, creditos, profesor, descripcion);
        if (!validationResult.isEmpty()) {
            return validationResult;
        }

        int creditosInt = Integer.parseInt(creditos);

        Materia materia = new Materia(
                nombre, creditosInt, profesor, descripcion);
        materias.add(materia);
        return "Materia agregada exitosamente.";
    }

    /**
     * Actualiza una materia existente.
     *
     * @param id El identificador de la materia a actualizar.
     * @param nombre El nuevo nombre de la materia.
     * @param creditos El nuevo número de créditos de la materia.
     * @param profesor El nuevo nombre del profesor de la materia.
     * @param descripcion La nueva descripción de la materia.
     * @return Mensaje indicando el resultado de la operación.
     */
    public final String updateMateria(
            final int id,
            final String nombre,
            final String creditos,
            final String profesor,
            final String descripcion) {
        String validationResult = validacion.validarMateria(
                nombre, creditos, profesor, descripcion);
        if (!validationResult.isEmpty()) {
            return validationResult;
        }

        int creditosInt = Integer.parseInt(creditos);

        for (int i = 0; i < materias.size(); i++) {
            if (materias.get(i).getId() == id) {
                materias.set(i, new Materia(
                        id, nombre, creditosInt, profesor, descripcion));
                return "Materia actualizada exitosamente.";
            }
        }
        return "Materia no encontrada.";
    }

    /**
     * Elimina una materia por su identificador.
     *
     * @param id El identificador de la materia a eliminar.
     * @return Mensaje indicando el resultado de la operación.
     */
    public final String deleteMateria(final int id) {
        for (int i = 0; i < materias.size(); i++) {
            if (materias.get(i).getId() == id) {
                materias.remove(i);
                return "Materia eliminada exitosamente.";
            }
        }
        return "Materia no encontrada.";
    }

}
