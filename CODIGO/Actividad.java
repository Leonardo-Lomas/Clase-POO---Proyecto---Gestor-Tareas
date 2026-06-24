public abstract class Actividad {
    protected String nombre;
    protected String descripcion;
    protected boolean estado;
    protected Date fechaConclusion;
    protected double calificacion;

    public Actividad(String nombre,String descripcion,Date fechaConclusion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaConclusion = fechaConclusion;
        this.estado = false;
    }

    public Actividad(){
        this.nombre = "Sin nombre";
        this.descripcion = "Sin descripcion";
        this.estado = false;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Date getFechaConclusion() {
        return fechaConclusion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setFechaConclusion(Date fechaConclusion) {
        this.fechaConclusion = fechaConclusion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
