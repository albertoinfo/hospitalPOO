
/**
 * Write a description of class Paciente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paciente
{
    // instance variables - replace the example below with your own
    private static int numpaciente =0;
    private int id;
    private String nombre;

    /**
     * Constructor for objects of class Paciente
     */
    public Paciente(String nombre)
    {
        this.nombre = nombre;
        numpaciente++;
        this.id = numpaciente;
    }
    
    public String toString(){
        return id +":"+nombre;
    }    
    
    public int getId(){
        return id;   
    }

    public String getNombre(){
        return nombre;
    }    
}
