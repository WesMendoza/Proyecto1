package Model;

import Vista.Estudiante;
import javax.swing.table.AbstractTableModel;
import java.util.List;
/**
 *
 * @author WDMS
 */
public class Tabla_estudiante extends AbstractTableModel {
    private final String[] columnNames = {"Cédula", "Nombre", "Apellido", "Carrera", "Semestre"};
    private final List<Estudiantes> estudiantes;
    
    public Tabla_estudiante(List<Estudiantes> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int getRowCount() {
        return estudiantes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Estudiantes alumno = estudiantes.get(rowIndex);
        switch (columnIndex) {
            case 0: return alumno.getCedula();
            case 1: return alumno.getNombre();
            case 2: return alumno.getApellido();
            case 3: return alumno.getCarrera();
            case 4: return alumno.getSemestre();
            default: return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
   
}
