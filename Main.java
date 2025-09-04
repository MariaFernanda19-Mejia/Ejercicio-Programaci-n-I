package co.edu.uniquindio.biblioteca;

import co.edu.uniquindio.biblioteca.model.Biblioteca;
import co.edu.uniquindio.biblioteca.model.Cliente;
import co.edu.uniquindio.biblioteca.model.Empleado;
import co.edu.uniquindio.biblioteca.model.Libro;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = inicializarDatos();

        int opcion = 0;
        do {
            mostrarMenu();
            opcion = leerEntero("Ingrese la opción del menú");
            switch (opcion) {
                case 1:
                    String resultado = crearCliente(biblioteca);
                    System.out.println("Información del cliente: " + resultado);
                    break;
                case 2:
                    Cliente cliente = obtenerCliente(biblioteca);
                    int edad = leerEntero("Ingrese la edad del cliente a validar");
                    String resultadoValidacion = validarEdadCliente(cliente, edad);
                    System.out.println("Resultado de la operación: " + resultadoValidacion);
                    break;
                case 3: // Crear empleado
                    String resultado2 = crearEmpleado(biblioteca);
                    System.out.println("Información del empleado: " + resultado2);
                    break;
                case 4: // Crear libro
                    String resultado3 = crearLibro(biblioteca);
                    System.out.println("Información del libro: " + resultado3);
                    break;
                case 5: // Validar libro
                    String nombreLibro = leerStringConsola("Ingrese nombre del libro:");
                    String resultadoValidacionLibro = validarLibro(biblioteca, nombreLibro);
                    System.out.println("Resultado de la operación: " + resultadoValidacionLibro);
                    break;
                case 6: // Salir
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        } while (opcion != 6);
    }


    private static String validarLibro(Biblioteca biblioteca, String nombre) {
        for (Libro libro : biblioteca.getListaLibros()) {
            if (libro.getNombre().equalsIgnoreCase(nombre)) {
                return "Este libro se encuentra en la biblioteca.";
            }
        }
        return "El libro no se encuentra en la biblioteca.";
    }


    private static Libro obtenerLibro(Biblioteca biblioteca) {
        String nombreLibro = leerStringConsola("Ingrese nombre del libro a buscar:");
        Libro libroEncontrado = null;
        for (Libro libro : biblioteca.getListaLibros()) {
            if (libro.getNombre().equalsIgnoreCase(nombreLibro)) {
                libroEncontrado = libro;
                break;
            }
        }
        return libroEncontrado;
    }

    private static String validarEdadCliente(Cliente cliente, int edad) {
        if (cliente != null) {
            if (cliente.getEdad() == edad) {
                return "La edad del cliente es válida.";
            } else {
                return "La edad del cliente no es válida.";
            }
        } else {
            return "No se puede validar, el cliente no existe.";
        }
    }

    private static Cliente obtenerCliente(Biblioteca biblioteca) {
        int idCliente = leerEntero("Ingrese el id del cliente a buscar");
        Cliente clienteEncontrado = null;
        for (Cliente cliente : biblioteca.getListaClientes()) {
            if (cliente.getId() == idCliente) {
                clienteEncontrado = cliente;
                break;
            }
        }
        return clienteEncontrado;
    }

    private static Biblioteca inicializarDatos() {
        // Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca("UQ");

        // ---------- Cliente inicial ----------
        Cliente cliente = new Cliente();
        cliente.setNombre("Juan");
        cliente.setApellido("Perez");
        cliente.setCorreo("mefejemse@sdm");
        cliente.setEdad(30);
        cliente.setId(1);
        biblioteca.getListaClientes().add(cliente);

        // ---------- Empleado inicial ----------
        Empleado empleado = new Empleado();
        empleado.setNombre("Laura");
        empleado.setApellido("Gomez");
        empleado.setId(100);
        empleado.setEdad(28);
        empleado.setSalario(2500000);
        biblioteca.getListaEmpleados().add(empleado);

        // ---------- Libro inicial ----------
        Libro libro = new Libro();
        libro.setNombre("Cien Años de Soledad");
        libro.setGenero("Novela");
        libro.setAutor("Gabriel García Márquez");
        libro.setAnio(1967);
        libro.setEditorial("Editorial Sudamericana");
        biblioteca.getListaLibros().add(libro);

        // Otro libro opcional
        Libro libro2 = new Libro();
        libro2.setNombre("El Principito");
        libro2.setGenero("Fábula");
        libro2.setAutor("Antoine de Saint-Exupéry");
        libro2.setAnio(1943);
        libro2.setEditorial("Reynal & Hitchcock");
        biblioteca.getListaLibros().add(libro2);

        return biblioteca;
    }


    public static String crearCliente(Biblioteca biblioteca) {
        String nombre = leerStringConsola("Ingrese el nombre del cliente");
        String apellido = leerStringConsola("Ingrese el apellido del cliente");
        String correo = leerStringConsola("Ingrese el correo del cliente");
        int id = leerEntero("Ingrese el id del cliente: ");
        int edad = leerEntero("Ingrese la edad del cliente:");

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setCorreo(correo);
        cliente.setId(id);
        cliente.setEdad(edad);

        biblioteca.getListaClientes().add(cliente);

        return cliente.toString();
    }

    public static String crearEmpleado(Biblioteca biblioteca) {
        String nombre = leerStringConsola("Ingrese el nombre del empleado");
        String apellido = leerStringConsola("Ingrese el apellido del empleado");
        int id = leerEntero("Ingrese el id del empleado:");
        int edad = leerEntero("Ingrese la edad del empleado: ");
        int salario = leerEntero("Ingrese el salario del empleado: ");

        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setId(id);
        empleado.setEdad(edad);
        empleado.setSalario(salario);

        biblioteca.getListaEmpleados().add(empleado);

        return empleado.toString();
    }

    private static String crearLibro(Biblioteca biblioteca) {
        String nombre = leerStringConsola("Ingrese el nombre del libro: ");
        String genero = leerStringConsola("Ingrese el género: ");
        String autor = leerStringConsola("Ingrese el autor: ");
        int anio = leerEntero("Ingrese el año de publicación: ");
        String editorial = leerStringConsola("Ingrese la editorial: ");

        Libro libro = new Libro();
        libro.setNombre(nombre);
        libro.setGenero(genero);
        libro.setAutor(autor);
        libro.setAnio(anio);
        libro.setEditorial(editorial);

        biblioteca.getListaLibros().add(libro);

        return libro.toString();
    }

    private static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        return Integer.parseInt(teclado.nextLine());
    }

    public static String leerStringConsola(String mensaje) {
        System.out.println(mensaje);
        Scanner teclado = new Scanner(System.in);
        return teclado.nextLine();
    }

    public static void mostrarMenu() {
        System.out.println("Opciones disponibles:");
        System.out.println("1 - Crear Cliente");
        System.out.println("2 - Validar edad del cliente");
        System.out.println("3 - Crear empleado");
        System.out.println("4 - Crear libro");
        System.out.println("5 - Validar libro");
        System.out.println("6 - Salir");
    }
}
