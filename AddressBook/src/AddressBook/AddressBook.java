package AddressBook;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class AddressBook {

    public static void main(String[] args) {

        Scanner sn = new Scanner(System.in);
        sn.useDelimiter("\n");
        boolean salir = false;
        int opcion;
        
        HashMap<String, Integer> agenda = new HashMap<>();
        
        
        Menu teclado = new Menu();
        
        String nombre;
        int telefono;

        
        while (!salir) {

            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Existe contacto");
            System.out.println("5. Eliminar contacto");
            System.out.println("6. Salir");
            try {
                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:

                        
                        nombre = teclado.pedirString("Introduce el nombre").toLowerCase().trim();
                        telefono = teclado.pedirInt("Introduce el telefono");
                        
                        
                        if(!agenda.containsKey(nombre)){
                            agenda.put(nombre.toLowerCase().trim(), telefono);
                            System.out.println("Se ha añadido el contacto");
                        }else{
                            System.out.println("Ya existe el contacto");
                        }
                        
                        break;
                    case 2:
                        
                        
                        if(agenda.entrySet().isEmpty()){
                            System.out.println("No hay contactos");
                        }else{
                            
                            for(Map.Entry<String, Integer> entry: agenda.entrySet()){
                                System.out.println("Nombre: "+entry.getKey()+" Telefono:"+entry.getValue());
                            }
                        }
                        
                        break;
                    case 3:

                        
                        nombre = teclado.pedirString("Introduce el nombre").toLowerCase().trim();
                        
                        
                        if(agenda.containsKey(nombre)){
                            System.out.println("El telefono es "+agenda.get(nombre));
                        }else{
                            System.out.println("El contacto no existe");
                        }
                        
                        break;
                    case 4:
                        
                        
                        nombre = teclado.pedirString("Introduce el nombre").toLowerCase().trim();
                        
                       
                        if(agenda.containsKey(nombre)){
                            System.out.println("El contacto existe");
                        }else{
                            System.out.println("El contacto no existe");
                        }
                        break;
                    case 5:

                        
                        nombre = teclado.pedirString("Introduce el nombre").toLowerCase().trim();
                        
                        
                        if(agenda.containsKey(nombre)){
                            agenda.remove(nombre);
                            System.out.println("El contacto se ha borrado");
                        }else{
                            System.out.println("El contacto no existe");
                        }
                        
                        break;
                    case 6:

                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 6");
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }

        }

    }

}
