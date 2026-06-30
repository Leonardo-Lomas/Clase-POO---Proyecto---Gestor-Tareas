import java.time.LocalDate;
import java.io.Serializable;
public class Tarea extends Actividad implements Notificar, Serializable{
    
    public Tarea(){
        super();
    }

    public Tarea(String nombre, String descripcion, LocalDate fechaConclusion){
        super(nombre,descripcion,fechaConclusion);
    }

    // Metodo de Notificar
    @Override
    public void notificarUsuario(){

    }
}
