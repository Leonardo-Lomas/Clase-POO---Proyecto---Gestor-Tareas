public class Menu {
  //atributos por pensar si aplica en este caso...
  private ArrayList<Materia> listaMaterias;
  private ControladorArchivos controladorArchivos;
  //metodos...
  public Menu(){
    controladorArchivos = new ControladorArchivos();
    listaMaterias = ca.leerMaterias();
  
  }
}
