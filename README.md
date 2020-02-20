Ejercicio con POO: Gestión hospitalaria

Para realizar la gestión de un hospital se han definido las siguiente clases:

Paciente: representa un paciente normal que ingresa en el hospital, cada paciente tiene un identificador único que se genera consecutivamente cuando se crea el objeto y el nombre de la persona.  

Paciente Grave: hereda de la anterior clase, añadiendo un nuevo atributo que el grado de gravedad siendo los valores posible un enumerado TipoGravedad con las constante MUY_GRAVE, GRAVE, MENOS_GRAVE. 

Hospital: Tiene una relación de los pacientes ingresados, almacenando en una arrays de objetos paciente. Tiene los métodos básicos de gestión: ingreso en el hospital, alta hospitalaria, lista pacientes, buscar pacientes por id y obtener el paciente más urgente. Este último método devolverá si existe el paciente con mayor gravedad, y si hay dos pacientes con el mismo valor de gravedad el que tenga menor identificador. Si solo existen pacientes normales se devolverá igualmente el que tenga menor identificador.

Para realizar la gestión de la tabla, será siempre más eficiente si no se generan huecos y la tabla siempre esta ordenada por Id de paciente para poder realizar búsquedas rápidas de pacientes.

Completar las siguientes clases añadiendo nuevos atributos y completando métodos para que la clase TestHospital funcione correctamente.  

public class Paciente
{
    private static int numpaciente =0;
    private int id;
    private String nombre;

    public Paciente(String nombre)
    {
        this.nombre = nombre;
        numpaciente++;
        this.id = numpaciente;
    }
    
    public String toString(){
        return id +":"+nombre;
    }    

}

// Clase de tipo enumerado
public enum TipoGravedad
{
    MUY_GRAVE,GRAVE,MENOS_GRAVE;
}

public class PacienteGrave extends Paciente
{
  
    private TipoGravedad gravedad; 

    public PacienteGrave(String nombre, TipoGravedad gravedad)
    {
        super(nombre);
        ...
    }

    public String toString()
    {
        return "";
    }
}

public class Hospital
{ 
    private Paciente tpacientes[];
    private int contadorpacientes;

    public Hospital(int numpacientes)
    {
        tpacientes = new Paciente[numpacientes];
        contadorpacientes = 0;
    }

    // Ingreso de un paciente al hospital
    public boolean ingreso(Paciente p)
    {
        return true;
    }
    // Alta del paciente - se borra de la tabla
    public boolean alta ( int id_paciente){
     
      return true;   
    }    
    
    // Devuelve el paciente con el identidador indicado o null si no existe
    public Paciente buscar(int id){
    	
    	return null;
    }
    
    // Imprime por consola la lista ORDENADO por NOMBRE de pacientes ***

    public void listapacientes (){
     
    }    
       
    // Devuelve el mas grave o el caso de paciente con la misma gravedad el
    // que su identificador sea mas bajo.
    public Paciente pacienteMasUrgente(){
        
    return null;  
        
    }    
}
public class TestHospital
{
    public static void main (String argv[]){
        Hospital lapaz = new Hospital(10);
        
        lapaz.ingreso(new Paciente("Pepe"));
        lapaz.ingreso(new Paciente("Ana"));
        lapaz.ingreso(new PacienteGrave("luis",TipoGravedad.MENOS_GRAVE));
        lapaz.alta(2); // Se borra el paciente Ana
        
        lapaz.listapacientes();
        Paciente p = lapaz.buscar(3);  // Busco a luis
        System.out.println("BUSCAR: El paciente con id = 3 es "+p);
        
        lapaz.ingreso(new PacienteGrave("Jaime",TipoGravedad.MUY_GRAVE));
        lapaz.ingreso(new Paciente("Ramon"));
        lapaz.ingreso(new PacienteGrave("Maria",TipoGravedad.MUY_GRAVE));
        lapaz.listapacientes();
        
        // Debe mostrar a Jaime
        System.out.println("Paciente mas urgente:"+ lapaz.pacienteMasUrgente());      
    }         
       
}
