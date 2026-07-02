/**
 * 
 * GestionActividad Interfaz, metodos relacionados a C.R.U.D.
 */
public interface GestionActividad {
    /**
     * Agregacion de una actividad.
     * 
     * @param actividad actividad (Tarea, Proyecto, Examen)
     */
    public abstract void agregarActividad(Actividad actividad);
    /**
     * Eliminacion de una actividad.
     * 
     * @param actividad actividad (Tarea, Proyecto, Examen)
     */
    public abstract void eliminarActividad(Actividad actividad);
}
