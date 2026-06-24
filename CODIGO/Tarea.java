public class Tarea extends Actividad implements Notificar{
    
    public Tarea(){
        super();
    }

    public Tarea(String nombre, String descripcion, Date fechaConclusion){
        super(nombre,descripcion,fechaConclusion);
    }

    // Metodo de Notificar
    @Override
    public void notificarUsuario(){

    }
}
