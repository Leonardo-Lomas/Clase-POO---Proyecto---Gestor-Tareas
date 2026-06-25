public class Menu {
  //atributos por pensar si aplica en este caso...
  private ArrayList<Materia> listaMaterias;
  //metodos...
  public Menu(){
    ControladorArchivos ca = new ControladorArchivos();
    listaMaterias = ca.leerMaterias();
  }
}
