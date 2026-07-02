import java.time.LocalDate;
import java.io.Serializable;

/**
 * 
 * Tarea Clase, representa una tarea del sistema.
 */

public class Tarea extends Actividad implements Notificar, Serializable{
    
    /**
     * Inicializacion vacia de la instancia.
     */
    public Tarea(){
        super();
    }
    /**
     * Inicializar los valores de la instancia.
     * 
     * @param nombre nombre de la tarea.
     * @param descripcion descripcion de la tarea.
     * @param fechaConclusion fecha de cierre de la tarea.
     */
    public Tarea(String nombre, String descripcion, LocalDate fechaConclusion){
        super(nombre,descripcion,fechaConclusion);
    }

    // Metodo de Notificar
    @Override
    public void notificarUsuario(){

    }
}
