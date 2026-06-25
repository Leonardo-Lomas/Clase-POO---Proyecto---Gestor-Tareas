import java.time.LocalDate;
public class Examen extends Actividad implements Notificar{
    
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
