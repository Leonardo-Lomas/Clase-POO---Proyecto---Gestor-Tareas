import java.time.LocalDate;
import java.io.Serializable;
public class Examen extends Actividad implements Notificar, Serializable{
    
    public Examen(){
        super();
    }

    public Examen(String nombre, String descripcion, LocalDate fechaConclusion){
        super(nombre,descripcion,fechaConclusion);
    }
    // Metodo de Notificar
    @Override
    public void notificarUsuario(){

    }
}
