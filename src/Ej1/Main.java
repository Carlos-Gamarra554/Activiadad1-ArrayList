package Ej1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TelefonoMovil miTelefono = new TelefonoMovil("123-456-789");
        miTelefono.addNewContact(new Contacto("Juan Perez", "111-222-333"));
        miTelefono.addNewContact(new Contacto("Maria Lopez", "444-555-666"));
        miTelefono.addNewContact(new Contacto("Carlos Gomez", "777-888-999"));
        miTelefono.addNewContact(new Contacto("Pepito", "666"));
        int opcion = -1;

        while (opcion != 0) {
            System.out.print("0. Salir\n" +
                    "1. Imprimir contactos\n" +
                    "2. Agregar nuevo contacto\n" +
                    "3. Actualizar contacto existente\n" +
                    "4. Eliminar contactos\n" +
                    "5. Buscar contactos por nombre\n" +
                    "6. Imprimir menú\n" +
                    "Elige una opción: ");
            opcion = sc.nextInt();

            System.out.println("----------------------------------------------------------");
            switch (opcion) {
                case 0:
                    System.out.println("Saliendo de contactos...");
                    break;
                case 1:
                    miTelefono.printContacts();
                    System.out.println("----------------------------------------------------------");
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Introduce el nombre del nuevo contacto: ");
                    String nombre1 = sc.nextLine();

                    System.out.print("Ahora el número de teléfono: ");
                    String tel1 = sc.nextLine();

                    Contacto contacto = Contacto.createContact(nombre1,tel1);

                    if (miTelefono.queryContact(nombre1) == null) {
                        miTelefono.addNewContact(contacto);
                        System.out.println("Contacto agregado con éxito.");
                    } else {
                        System.out.println("Error: El contacto ya existe.");
                    }
                    System.out.println("----------------------------------------------------------");
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Introduce el nombre del contacto a modificar: ");
                    String nombreExistente = sc.nextLine();

                    if (miTelefono.queryContact(nombreExistente) != null) {
                        System.out.print("Introduce el nombre para el nuevo contacto: ");
                        String nombreNuevo = sc.nextLine();

                        System.out.print("Ahora el número de teléfono: ");
                        String telNuevo = sc.nextLine();

                        Contacto modificarContacto = new Contacto(nombreNuevo, telNuevo);
                        Contacto contactoExistente = miTelefono.queryContact(nombreExistente);

                        miTelefono.updateContact(contactoExistente, modificarContacto);
                        System.out.println("Contacto modificado exitosamente");
                    } else {
                        System.out.println("El contacto introducido no existe");
                    }
                    System.out.println("----------------------------------------------------------");
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Introduce el nombre del contacto a eliminar: ");
                    String nombre2 = sc.nextLine();

                    if (miTelefono.queryContact(nombre2) != null) {
                        miTelefono.removeContact(miTelefono.queryContact(nombre2));
                        System.out.println("Contacto eliminado exitosamente");
                    } else {
                        System.out.println("Error. El contacto no existe");
                    }
                    System.out.println("----------------------------------------------------------");
                    break;

                case 5:
                    sc.nextLine();
                    System.out.print("Introduce el nombre del contacto que quieres buscar: ");
                    String nombre3 = sc.nextLine();

                    if (miTelefono.queryContact(nombre3) != null) {
                        System.out.print("El usuario " + nombre3 + " sí existe. Información del contacto:\n");
                        System.out.println("Nombre: " + miTelefono.queryContact(nombre3).getName() + ", Teléfono: " + miTelefono.queryContact(nombre3).getPhoneNumber());
                    } else {
                        System.out.println("Error. EL contacto no existe");
                    }
                    System.out.println("----------------------------------------------------------");
                    break;

                case 6:
                    System.out.print("0. Salir\n" +
                            "1. Imprimir contactos\n" +
                            "2. Agregar nuevo contacto\n" +
                            "3. Actualizar contacto existente\n" +
                            "4. Eliminar contactos\n" +
                            "5. Buscar contactos por nombre\n" +
                            "6. Imprimir menú\n" +
                            "Elige una opción: ");
                    opcion = sc.nextInt();
                    System.out.println("----------------------------------------------------------");
                    break;

                    default:
                        System.out.println("Error: Opción no válida");
                        System.out.println("----------------------------------------------------------");
                        break;
            }
        }
    }
}