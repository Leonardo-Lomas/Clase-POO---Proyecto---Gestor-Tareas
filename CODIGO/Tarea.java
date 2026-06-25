import java.time.LocalDate;
public class Tarea extends Actividad implements Notificar{
    
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
