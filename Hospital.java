
/**
 * Write a description of class Hospital here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 */
import java.util.Arrays;

public class Hospital
{
    // instance variables - replace the example below with your own
    private Paciente tpacientes[];
    private int numPacientesActual;

    /**
     * Constructor for objects of class Hospital
     */
    public Hospital(int numpacientes)
    {
        tpacientes = new Paciente[numpacientes];
        numPacientesActual =0;
    }

    public boolean ingreso(Paciente p)
    {
       boolean resu = false;
       if (numPacientesActual < tpacientes.length){
           tpacientes[numPacientesActual] = p;
           numPacientesActual++;
           resu = true;
        }
      return resu;  
    }
    
    // Devuelve el paciente con el identidador indicado o null si no existe
    // Busqueda secuencia
    public Paciente buscar(int id){
    	 for (int i=0; i < numPacientesActual; i++){
    	    if ( tpacientes[i].getId()== id){
    	        return tpacientes[i];
    	   }   
         }   
    	return null;
    }
    
    
    
    public Paciente buscarb(int id){
      int izda = 0;
      int dcha = numPacientesActual -1;
      Paciente p = null;
      boolean encontrado = false;
      while ( (izda <= dcha) && ( !encontrado ) ){
          int medio = (izda+dcha)/2;
          if ( tpacientes[medio].getId() == id ){
               p = tpacientes[medio];
               encontrado = true;
          } else {
              if ( tpacientes[medio].getId() < id ){
                  izda = medio +1;
                }
              else {
                  dcha = medio -1;
                }    
          }        
        }
      return p;
    }    
    
    
    /**
     * Alta de paciente a partir de su id
     */
    public boolean alta ( int id_paciente){
     
        boolean resu = false;
        for (int i=0; i < numPacientesActual; i++){
            if ( tpacientes[i].getId() == id_paciente){
                tpacientes[i] = null;
                // Desplazo
                for (int j= i; j < numPacientesActual-1; j++){
                    tpacientes[j] = tpacientes[j+1];
                }
                resu = true;
                numPacientesActual--;
                break;
            }
        }
        return resu;
    }    
    
    /**
     * Alta de paciente a partir de su id
     */
    public boolean alta ( Paciente p){
        return alta(p.getId());
    }    
    
    
    public boolean listapacientes (){
        
      boolean resu = false;  
      Arrays.sort(tpacientes,0,numPacientesActual, new ordenarNombre());
      if ( numPacientesActual >0){
        System.out.println(" LISTADO DE PACIENTES ");
        System.out.println(" =================================== ");
        for (int i=0; i< numPacientesActual; i++){
           System.out.println(tpacientes[i]);
        }
       }  
      return resu;
    }    
    
    
    // Devuelve el mas grave o el caso de paciente con la misma gravedad el
    // que su identificador sea mas bajo
    
    public Paciente pacienteMasUrgente(){
        
        Paciente max = null;
        PacienteGrave maxg = null;
        if (numPacientesActual == 0){
            return null;
        }    
        // En dos ciclos
        for (int i=0; i< numPacientesActual; i++){
          Paciente p = tpacientes[i];  
           if ( p instanceof PacienteGrave){
            PacienteGrave aux = (PacienteGrave) p;
            if ( maxg != null ){
                // Comparo con el paciente grave maximo provisional
                if ( aux.getGravedad().ordinal() > maxg.getGravedad().ordinal()){
                    maxg = aux;
                } else if (  aux.getGravedad() == maxg.getGravedad() &&
                             aux.getId() < maxg.getId()){
                    maxg = aux;
                }    
            }
            else{
                // No hay ningun maximo con gravedad provisonal
                maxg = aux;
            }    
          }
          else {
          // No es un paciente con gravedad
          // Si hay maximo con gravedad no comparo los normales
          if ( maxg == null){
              if ( max != null){
                  if ( p.getId() < max.getId()){
                      max = p;
                    }
                }
                else{
                 max = p;
                }      
            }                   
        }
        }
        if ( maxg != null ) return  maxg;
        return max;
   }    
    
    
    
    public Paciente pacienteMasUrgente2(){
        
       
        if (numPacientesActual == 0){
            return null;
        }    
        PacienteGrave maxg = null;
        // Busco si hay paciente con gravedad 
        for (int i=0; i< numPacientesActual; i++){
            Paciente p = tpacientes[i];  
           if ( p instanceof PacienteGrave){
            PacienteGrave aux = (PacienteGrave) p;
            if ( maxg != null ){
                // Comparo con el paciente grave maximo provisional
                if ( aux.getGravedad().ordinal() > maxg.getGravedad().ordinal()){
                    maxg = aux;
                } else if (  aux.getGravedad() == maxg.getGravedad() &&
                             aux.getId() < maxg.getId()){
                    maxg = aux;
                }    
            }
            else{
                // No hay ningun maximo con gravedad provisonal
                maxg = aux;
            }    
          }
        } 
        // SI es null es que no hay un paciente con gravedad
        // Devuelvo el primero SINO devuelvo el paciente con gravedad maxima
        if ( maxg == null){
            return tpacientes[0];
        } else {
            return maxg;
        }
        
   }    
}
