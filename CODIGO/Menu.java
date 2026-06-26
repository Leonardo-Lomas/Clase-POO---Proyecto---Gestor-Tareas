import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.IndexOutOfBoundsException;
import java.time.LocalDate;

public class Menu {
  //atributos por pensar si aplica en este caso...
  private ArrayList<Materia> listaMaterias;
  private ControladorArchivos controladorArchivos;
  //metodos...
  public Menu(){
    /*---------------------------------------------
    Se crea una instancia de la clase controlador para
    obtener la lista de materias
    ------------------------------------------------ */
    ControladorArchivos ca = new ControladorArchivos();
    listaMaterias = ca.leerMaterias();
  }

  public void principal(){
    int seleccion;
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Materias");
    
    do{

      /*------------------------------------
      Se imprime la lista de materias
      -------------------------------------- */
      for(int i = 0; i<=listaMaterias.size() - 1;i++){
      System.out.println("1.- "+listaMaterias.get(i).getNombre());
      }
      
      System.out.print("Selecion: ");
      /*-------------------------------------------------------
      Try, en caso de que la entrada no sea un entero o que
      no corresponda a un elemento de la lista
      --------------------------------------------------------- */

      try{
        
        /*-----------------------------------------------------------
        Se le resta 1 a la input, porque cuando se imprimieron las materias
        se les mostro con un numero mayor a el de su indice
        ------------------------------------------------------------- */
        seleccion = sc.nextInt() - 1; 
        this.menuMateria(seleccion);

      }catch(InputMismatchException ex){
        System.out.println("Seleccion no valida");
      }catch(IndexOutOfBoundsException ex){
        System.out.println("Seleccion no valida");
      }
    }while(true);
  }

  public void menuMateria(int index){

    // Declaracion de variables importantes para facil lectura del codigo
    int seleccion;
    Scanner sc = new Scanner(System.in);
    Materia materia = listaMaterias.get(index);

    // Un do-while para que en caso de una excepcion pueda volverse a iniciarse el metodo
    do{
      System.out.println(materia.getNombre());
      System.out.println("Profesor: "+ materia.getProfesor());
        
      System.out.println("1.- Proyectos");
      System.out.print("2.- Tareas");
      System.out.println("3.- Examenes");
      
      /*------------------------------------------------
      Try, en caso de que la input no sea de tipo entero
      -------------------------------------------------- */
      try{
        
        // Un do-while para asegurarse de que la seleccion es un 1 o un 2
        do{

          seleccion = sc.nextInt();
          if(seleccion == 1 || seleccion == 2 || seleccion == 3){
            break;
          }

        }while(true);

        switch (seleccion) {
          case 1:
            this.menuProyectos(materia);
            break;
          case 2:
            this.menuTareas(materia);
            break;
          case3:
            this.menuExamenes(materia);
            break;
        }

      }catch(InputMismatchException ex){
        System.out.println("Seleccion no valida");
      }
    }while(true);
  }

  public void menuTareas(Materia materia){
    ArrayList<Actividad> actividades = materia.getListaActividades();
    Scanner sc = new Scanner(System.in);
    int seleccion;
    
    do{
      /*-------------------------------------
      Se buscan y imprimen las tareas
      ------------------------------------*/
      for(int i = 0; i<= actividades.size() - 1 ; i++){
        if(actividades.get(i) instanceof Tarea){  
          System.out.println(i +".- " + actividades.get(i).getNombre());
        }
      }

      System.out.println("50.- Agregar una nueva Tarea");
      System.out.println("51.- Regresar");
      System.out.print("Seleccion: ");

      /*------------------------------------------------------
        Try, en caso de que el numero leido se salga de el ArrayList
        o  el usuario introdusca un caracter por alguna razon
        -------------------------------------------------------- */
        try{

          /*------------------------------------------------------
          Se comprueba que el elemento seleccionado si corresponde
          al index de un proyecto o es alguna de las opciones dadas
          -------------------------------------------------------- */
          seleccion = sc.nextInt();

          if((actividades.get(seleccion) instanceof Proyecto) == false && seleccion != 50 && seleccion != 51){
          System.out.println("Seleccion no valida");
          }

                switch (seleccion){
            case 50:
              this.menuAgregarActividadMateria(materia,new Tarea());
              break;
            
            case 51:
              //Si se inserta un 51, entra en el switch y se usar "return"
              //para terminar el procesamiento del metodo             
              return;

            default:
              this.menuTarea(materia,(Tarea)actividades.get(seleccion));
              break;
        }

        }catch(InputMismatchException ex){
          System.out.println("Seleccion no valida");
        }catch(IndexOutOfBoundsException ex){
          System.out.println("Seleccion no valida");
        }


    }while(true);
  }

  public void menuProyectos(Materia materia){
    ArrayList<Actividad> actividades = materia.getListaActividades();
    Scanner sc = new Scanner(System.in);
    int seleccion;


    do{

      /*-------------------------------------
      Se buscan y imprimen los proyectos
      ------------------------------------*/    
      for(int i = 0; i<= actividades.size() - 1 ; i++){
        if(actividades.get(i) instanceof Proyecto){  
          System.out.println(i +".- " + actividades.get(i).getNombre());
        }
      }

      System.out.println("50.- Agregar un nuevo proyecto");
      System.out.println("51.- Regresar");
      System.out.print("Seleccion: ");

      /*------------------------------------------------------
      Try, en caso de que el numero leido se salga de el ArrayList
      o  el usuario introdusca un caracter por alguna razon
      -------------------------------------------------------- */
      try{

        /*------------------------------------------------------
        Se comprueba que el elemento seleccionado si corresponde
        al index de un proyecto o es alguna de las opciones dadas
        -------------------------------------------------------- */
        seleccion = sc.nextInt();

        if((actividades.get(seleccion) instanceof Proyecto) == false && seleccion != 50 && seleccion != 51){
        System.out.println("Seleccion no valida");
        }


        switch (seleccion){
        case 50:
          this.menuAgregarActividadMateria(materia,new Proyecto());
          break;
          
        case 51:
          //Si se inserta un 51, entra en el switch y se usar "return"
          //para terminar el procesamiento del metodo          
          return;

        default:
          this.menuProyecto((Proyecto)actividades.get(seleccion));
          break;
        }
      }catch(InputMismatchException ex){
        System.out.println("Seleccion no valida");
      }catch(IndexOutOfBoundsException ex){
        System.out.println("Seleccion no valida");
      }

    }while(true);
  }

  public void menuAgregarActividadProyecto(Proyecto proyecto){

    // Se inicializan las variables que se utilizaran
    LocalDate fecha;
    Scanner sc = new Scanner(System.in);
    String entrada;

    // Proyecto solo puede tener adentro tareas
    Tarea nuevaTarea = new Tarea();
    int dia,mes,año;
    
    /*-----------------------------------------------
    El try es por si se introduce algo que no sea una
    String
    ------------------------------------------------- */
    try{
    System.out.print("Nombre de la tarea: ");
    entrada = sc.nextLine();
    nuevaTarea.setNombre(entrada);

    System.out.print("Descripcion: ");
    entrada = sc.nextLine();
    nuevaTarea.setDescripcion(entrada);

    System.out.println("Fecha de conclusion");
    System.out.println("Año: ");
    año = sc.nextInt();

    System.out.println("Mes: ");
    mes = sc.nextInt();

    System.out.println("Dia: ");
    dia = sc.nextInt();

    fecha = LocalDate.of(año, mes, dia);
    nuevaTarea.setFechaConclusion(fecha);

    proyecto.agregarActividad(nuevaTarea);
      
    }catch(InputMismatchException ex){

      /*---------------------------------------------------
      En caso de una excepcion, se agrega la actividad con
      los datos que si se hayan agregado hasta ese punto,
      el resto seran los datos del constructor sin parametros
      ----------------------------------------------------- */
      System.out.println("El valor introducido no es correcto, se regresara al menu anterior");
      System.out.println("Cualquier cambio realizado a la tarea antes de este punto se efectuara");
      proyecto.agregarActividad(nuevaTarea);
    }
  }

  public void menuAgregarActividadMateria(Materia materia,Actividad actividad){
    
    try{
    LocalDate fecha;
    Scanner sc = new Scanner(System.in);
    String entrada;
    int dia,mes,año;
    
    System.out.print("Nombre: ");
    entrada = sc.nextLine();
    actividad.setNombre(entrada);

    System.out.print("Descripcion: ");
    entrada = sc.nextLine();
    actividad.setDescripcion(entrada);

    System.out.println("Fecha de conclusion");
    System.out.println("Año: ");
    año = sc.nextInt();

    System.out.println("Mes: ");
    mes = sc.nextInt();

    System.out.println("Dia: ");
    dia = sc.nextInt();

    fecha = LocalDate.of(año, mes, dia);
    actividad.setFechaConclusion(fecha);

    materia.agregarActividad(actividad);

    }catch(InputMismatchException ex){
      /*---------------------------------------------------
      En caso de una excepcion, se agrega la actividad con
      los datos que si se hayan agregado hasta ese punto,
      el resto seran los datos del constructor sin parametros
      ----------------------------------------------------- */
      System.out.println("El valor introducido no es correcto, se regresara al menu anterior");
      System.out.println("Cualquier cambio realizado a la actividad antes de este punto se efectuara");
      materia.agregarActividad(actividad);
    }

  }

  public void menuEliminarActividadMateria(Materia materia){

  }

  public void menuEliminarActividadProyecto(Proyecto proyecto){


  }


  public void menuActividad(Materia materia,Actividad actividad){
    Scanner sc = new Scanner(System.in);
    int seleccion;

    do{
      System.out.println(actividad.getNombre());
      System.out.println(actividad.getDescripcion());
      System.out.println(actividad.getFechaConclusion());
      System.out.println(actividad.getCalificacion());
      System.out.println(actividad.getFechaConclusion()+"\n");
      if(actividad instanceof Proyecto){

        System.out.println("actividads del proyecto: ");
        for(int i = 0; i < ((Proyecto) actividad).getListaActividades().size(); i++){
          System.out.println(((Proyecto) actividad).getListaActividades().get(i));
        }

        System.out.println("1.- Marcar como terminada");
        System.out.println("2.- Editar");
        System.out.println("3.- Eliminar");
        System.out.println("4.- Tareas");        
        System.out.println("5.- Regresar");
        System.out.print("Seleccion: ");
      }else{
      System.out.println("1.- Marcar como terminada");
      System.out.println("2.- Editar");
      System.out.println("3.- Eliminar");
      System.out.println("4.- Regresar");
      System.out.print("Seleccion: ");
      }
      try{
        seleccion = sc.nextInt();
        switch (seleccion) {
          case 1:
            actividad.setEstado(true);
            break;
          case 2:
            this.menuEditarActividad(actividad);
            break;
          case 3:
            materia.eliminarActividad(actividad);
            break;
          default:
            break;
        }

        if(actividad instanceof Proyecto){
        switch (seleccion) {
          case 4:
            this.menuTareas(actividad);
            break;
          case 5:
            return;

          default:
            System.out.println("Seleccion no valida");  
            break;
        }
        }else{
          if(seleccion == 4){
            return;
          }else{ System.out.println("Seleccion no valida");}
        }
      }catch(InputMismatchException ex){
        System.out.println("Seleccion no valida");
      }
    }while(true);

  }

  public void menuEditarActividad(Actividad actividad){
    
  }
}
