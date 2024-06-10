package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mendoza Wesner
 */
public class DatosEstudiantes {
    public static List<Estudiantes> obtenerEstudiantes() {
        List<Estudiantes> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiantes("0951887868", "Wesner", "Mendoza", "Software", 8));
        estudiantes.add(new Estudiantes("9876543210", "Maria", "Gomez", "Medicina", 3));
        estudiantes.add(new Estudiantes("4567890123", "Carlos", "Lopez", "Derecho", 1));
        return estudiantes;
    }
}
