/**
 * 
 * App
 * Representa la clase inicial que lanza la aplicacion
 * No hay ningun uso mas
 * @author Leonardo Lomas
 * @author Miguel Gutierrez
 * @version 1.0.0
 */


public class App {
  /**
     * Inicializa un objeto de tipo menu, el cual lanza la aplicacion.
     * este ejecuta el metodo mn.principal() el cual lanza el menu principal que ve el usuario.
     */
  public static void main(String[] args){
    
    Menu mn = new Menu();
    mn.principal();
  }
}
