
/**
 * Write a description of class TestHospital here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TestHospital
{
    public static void main (String argv[]){
        Hospital lapaz = new Hospital(12);
        
        lapaz.ingreso(new Paciente("Pepe"));
        lapaz.ingreso(new Paciente("Ana"));
        lapaz.ingreso(new PacienteGrave("Luis",TipoGravedad.MENOS_GRAVE));
        lapaz.ingreso(new Paciente("Ramon"));
        lapaz.alta(2); // Se borra el paciente Ana
        
        lapaz.listapacientes();
        Paciente p = lapaz.buscar(3);  // Busco a luis
        System.out.println("BUSCAR: El paciente con id = 3 es "+p);
        
        
        lapaz.ingreso(new PacienteGrave("Jaime",TipoGravedad.MUY_GRAVE));
        lapaz.ingreso(new Paciente("Ramon"));
        lapaz.ingreso(new PacienteGrave("Luis Jose",TipoGravedad.MENOS_GRAVE));
        lapaz.ingreso(new PacienteGrave("Maria",TipoGravedad.MUY_GRAVE));
        PacienteGrave p1 = new PacienteGrave("Eva",TipoGravedad.GRAVE);
        Paciente      p2 = new Paciente("Fernando");
        lapaz.ingreso(p1);
        lapaz.ingreso(p2);
         
       
        lapaz.listapacientes();
        
        // Debe mostrar a Jaime
        System.out.println("Paciente mas urgente:"+ lapaz.pacienteMasUrgente2());
        
    }         
       
}
