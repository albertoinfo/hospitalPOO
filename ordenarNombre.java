
/**
 * Write a description of class ordenarNombre here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Comparator;
public class ordenarNombre implements Comparator<Paciente> 
{
    @Override
    public int compare(Paciente o1, Paciente o2) {
    return o1.getNombre().compareTo(o2.getNombre()); // Devuelve un entero positivo si la altura de o1 es mayor que la de o2
    }
}
