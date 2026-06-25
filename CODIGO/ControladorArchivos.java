import java.util.ArrayList;
import java.io.BufferedReader;
import java.nio.file.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.Exception.*;

public class ControladorArchivos {
  //atributos veremos si hay alguno por definir.
  private int iterador = 0;
  
  //metodos
  public ArrayList<Materia> leerMaterias(){
    ArrayList<Materia> listaMaterias = new ArrayList<>();
    try {
      String nombreArchivo = "listaMaterias.txt";
      Path path = FileSystems.getDefault().getPath(nombreArchivo);
      BufferedReader br = Files.newBufferedReader(path);
      String linea;
      while ((linea = br.readLine()) != null){
        String nombre = crearObjeto(linea);
        String profesor = crearObjeto(linea);
        Materia aux = new Materia(nombre,profesor);
        listaMaterias.add(aux); 
        this.iterador = 0;
      }
      br.close();
      return listaMaterias;
    }
    catch(IOException ex){
      System.out.println(ex.getCause());
      System.out.println("No valido.");
    }
    return listaMaterias; 
  }
  
  
  
  public String crearObjeto(String w){
    String resul = "";
    int y = this.iterador;
    for (;w.charAt(y) != ';';y++){
      resul += w.charAt(y);
    }
    this.iterador = y+1;
    return resul;
  }
}
