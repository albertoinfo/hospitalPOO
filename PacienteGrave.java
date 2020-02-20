
/**
 * Write a description of class PacienteGrave here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PacienteGrave extends Paciente
{
  
    private TipoGravedad gravedad; 

    /**
     * Constructor for objects of class PacienteGrave
     */
    public PacienteGrave(String nombre, TipoGravedad gravedad)
    {
        super(nombre);
        this.gravedad = gravedad;
    }

    public String toString()
    {
        return super.toString()+"["+gravedad+"]";
    }
    
    public TipoGravedad getGravedad(){
        return gravedad;
    }
}
