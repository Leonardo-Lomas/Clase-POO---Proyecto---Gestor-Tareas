import java.time.LocalDate;
import java.io.Serializable;

/**
 * 
 * Examen Clase, representa los Examenes del sistema
 * 
 */

public class Examen extends Actividad implements Notificar, Serializable{
   
    /**
     * Constructor que herada de la clase abstracta Actividad.
     * Hereda el super contructor de la clase abstracta Actividad.
     */
    public Examen(){
        super();
    }
    /**
     * Constructor que inicializa los valores necesarios para la clase.
     * 
     * @param nombre nombre del examen.
     * @param descripcion descripcion del examen.
     * @param fechaConclusion fecha de cierre del examen.
     */
    public Examen(String nombre, String descripcion, LocalDate fechaConclusion){
        super(nombre,descripcion,fechaConclusion);
    }
    // Metodo de Notificar

    /**
     * Metodo para mandar notificaciones al usuario.
     */
    @Override
    public void notificarUsuario(){

    }
}
