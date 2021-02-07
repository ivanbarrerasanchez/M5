/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodosuserypassivanb;

import java.util.*;

/**
 *
 * @author Ivan
 */
public class MetodosUserYPassIvanB_V2 {

    public static void completo(Scanner lector, String password, String[] usuarios, String[] nombres, String[] passw, 
    Date[] fecha, int[] k, String nom , String apellido1 , String apellido2, String nombreCompleto,
    String letraUser, String apellidoUser, String user, String contraAdmin, int seleccion, int seleccion2,
    int seleccion3, Date[] fechaUser){
        while (true) {
            System.out.println("Online - users software acces");
            System.out.println("-----------------------------");
            System.out.println("1. Entrar com administrador \n"
                    + "2. Entrar com usuari\n"
                    + "0. Sortir del programa\n");

            seleccion = lector.nextInt();
            if (seleccion >= 0 && seleccion <= 2) {
                if (seleccion == 0) {
                    break;
                }
                switch (seleccion) {
                    case 1:
                        lector.nextLine();
                        System.out.println("Introdueix la contraseña de l'administrador");
                        contraAdmin = lector.nextLine();
                        while (true) {
                            if (contraAdmin.equals("P@ssw0rd!")) {
                                System.out.println("Introdueix l'opcio desitjada");
                                System.out.println("----------------------------");
                                System.out.println("1. Mostrar tots els noms, cognoms i login dels usuaris\n"
                                        + "2. Saber quants usuaris hi ha donats d’alta\n"
                                        + "3. Saber quan va ser l'últim accés de l'usuari.\n"
                                        + "4. Donar de baixa un usuari\n"/*Consigo que se pueda dar de baja el usuario pero no consigo
                                        hacer que el siguiente usuario que se introduzca se coloque en la posición vacia*/
                                        + "5. Donar d’alta un usuari\n"
                                        + "0. Sortir del programa\n");
                            } else {
                                System.out.println("Contrasenya incorrecta");
                            }
                            seleccion3 = lector.nextInt();
                            if (seleccion3 >= 0 && seleccion3 <= 5) {
                                if (seleccion3 == 0) {
                                    break;
                                } else {
                                    switch (seleccion3) {

                                        case 1:
                                            //Printar todos los nombres y usuarios correspondientes
                                            showUsers(nombres, usuarios, fecha, k);
                                            break;
                                        case 2:
                                            activeUser(k);
                                            break;
                                        case 3:
                                            ultimUser(k, fechaUser, fecha, usuarios);
                                            break;
                                        case 4:
                                            /*No he conseguido que el siguiente usuario que se cree se coloque en la posicion
                                            del usuario dado de baja*/
                                            deleteUser(lector, usuarios, passw, nombres, fecha, k);
                                            break;
                                        case 5:
                                            addUser(lector, nom, apellido1, apellido2, letraUser,
                                                    apellidoUser, nombreCompleto, user, password,
                                                    fechaUser, usuarios, nombres, passw, fecha, k);
                                            break;
                                    }
                                    System.out.println("\n");
                                }
                            } else {
                                System.out.println("Introdueix una opció valida\n");
                            }
                        }
                        break;
                    case 2:
                        lector.nextLine();
                        System.out.println("Introdueix l'usuari: \n");
                        String logUser = lector.nextLine();
                        System.out.println("Introdueix la contraseña: \n");
                        String passUser = lector.nextLine();
                        for (int r = 0; r < usuarios.length; r++) {
                            if ((logUser.equals(usuarios[r])) && (passUser.equals(passw[r]))) {
                                while (true) {
                                    System.out.println("Introdueix l'opcio desitjada");
                                    System.out.println("----------------------------");
                                    System.out.println("1. Editar el nostre nom i cognoms\n"
                                            + "2. Generar un nou password\n"
                                            + "3. Donar-nos de baixa\n"
                                            + "0. Sortir del programa\n");

                                    seleccion2 = lector.nextInt();

                                    if (seleccion2 >= 0 && seleccion2 <= 3) {
                                        if (seleccion2 == 0) {
                                            break;
                                        }
                                    }
                                    switch (seleccion2) {
                                        case 1:
                                            /*Editar el nombre de usuario*/
                                            editUser(lector, usuarios, nom, apellido1, apellido2, letraUser,
                                                    apellidoUser, nombreCompleto, user, nombres);
                                            break;
                                        case 2:
                                            //Crear una contraseña nueva para el usuario introducido
                                            generatePass(lector, password, usuarios, passw);
                                            break;
                                        case 3:
                                            /*Elimina un usuario que entres por teclado*/
                                            deleteUser(lector, usuarios, passw, nombres, fecha, k);
                                            break;
                                    }

                                }
                                break;
                            } else {
                                System.out.println("L'usuari o la contrasenya son incorrectes");
                                break;
                            }
                        }
                }
            } else {
                System.out.println("Escull una opcio valida");
            }
        }
    }

    public static void showUsers(String nombres[], String usuarios[], Date fecha[], int k[]) {
        System.out.println("Els usuaris son: ");
        for (int j = 0; j < k[0]; j++) {
            System.out.println(nombres[j] + " " + usuarios[j] + " " + fecha[j]);
        }
    }

    public static void deleteUser(Scanner lector, String usuarios[], String passw[], String nombres[],
            Date fecha[], int k[]) {
        lector.nextLine();
        System.out.println("Introdueix el nom d'usuari");
        String bajaUser = lector.nextLine();

        for (int l = 0; l < k[0]; l++) {
            if (bajaUser.equals(usuarios[l])) {
                usuarios[l] = null;
                passw[l] = null;
                nombres[l] = null;
                fecha[l] = null;
                k[1]--;
            }
        }
        k[0]--;

        for (int j = 0; j < k[0]; j++) {
            if (usuarios[j] == null) {
                int h = j;
                h++;
                usuarios[j] = usuarios[h];
                passw[j] = passw[h];
                nombres[j] = nombres[h];
                fecha[j] = fecha[h];
                usuarios[h] = null;
                passw[h] = null;
                nombres[h] = null;
                fecha[h] = null;
            }
        }
    }

    public static void addUser(Scanner lector, String nom, String apellido1, String apellido2, String letraUser,
            String apellidoUser, String nombreCompleto, String user, String password,
            Date fechaUser[], String usuaris[], String noms[], String passwd[], Date fechas[], int k[]) {
        System.out.println("Escriu el  nom i cognoms de l'usuari\n");
        nom = lector.next();
        apellido1 = lector.next();
        apellido2 = lector.next();

        letraUser = nom.toLowerCase().substring(0, 1);
        apellidoUser = apellido1.toLowerCase();
        nombreCompleto = nom + " " + apellido1 + " " + apellido2;

        user = letraUser + apellidoUser;
        int login = user.length();

        String contraseña = "";
        for (int i = 0; i < 8; i++) {
            int numero = (int) (Math.random() * password.length());
            contraseña += password.charAt(numero);
        }

        if (k[2] == 0) {
            fechaUser[0] = new Date();
            usuaris[k[0]] = user;
            noms[k[0]] = nombreCompleto;
            passwd[k[0]] = contraseña;
            fechas[k[0]] = fechaUser[0];
            k[0]++;
            k[1]++;
            k[2]++;
            System.out.println("Usuari: " + user + "\nContrasenya: " + contraseña);
        } else {
            k[3] = 2;
            for (int j = 0; j < usuaris.length; j++) {
                if (user.equals(usuaris[j])) {
                    user = user.substring(0, login);
                    user += k[3];
                    k[3]++;
                    j = -1;
                }
            }
            fechaUser[0] = new Date();
            usuaris[k[0]] = user;
            noms[k[0]] = nombreCompleto;
            passwd[k[0]] = contraseña;
            fechas[k[0]] = fechaUser[0];
            k[0]++;
            k[1]++;
            System.out.println("Usuari: " + user + "\nContrasenya: " + contraseña);
        }
    }

    public static void editUser(Scanner lector, String usuarios[], String nom, String apellido1, String apellido2, String letraUser,
            String apellidoUser, String nombreCompleto, String user, String nombres[]) {
        lector.nextLine();
        System.out.println("Escribe el nombre de usuario");
        String editUser = lector.next();
        for (int z = 0; z < usuarios.length; z++) {
            if (editUser.equals(usuarios[z])) {
                System.out.println("Escriu el teu nom y cognoms");
                nom = lector.next();
                apellido1 = lector.next();
                apellido2 = lector.next();
                //Coger la letra del nombre, el apellido y crear el nombre completo
                letraUser = nom.toLowerCase().substring(0, 1);
                apellidoUser = apellido1.toLowerCase();
                nombreCompleto = nom + " " + apellido1 + " " + apellido2;
                //Crear el usuario a partir de la letra y el apellido
                user = letraUser + apellidoUser;

                usuarios[z] = user;
                nombres[z] = nombreCompleto;
                System.out.println("El teu nom d'usuari nou es " + user);
                break;
            } else {
                System.out.println("No existe ese usuario");
                break;
            }
        }
    }

    public static void generatePass(Scanner lector, String password, String usuarios[], String passw[]) {
        lector.nextLine();
        System.out.println("Introdueix el teu nom d'usuari");
        String newPassUser = lector.nextLine();
        String contraseña = "";
        for (int y = 0; y < usuarios.length; y++) {
            if (newPassUser.equals(usuarios[y])) {
                for (int i = 0; i < 8; i++) {
                    int numero = (int) (Math.random() * password.length());
                    contraseña += password.charAt(numero);
                }
                passw[y] = contraseña;
                System.out.println("La nova contraseña es " + passw[y]);
            }
        }
    }

    public static void activeUser(int k[]) {
        System.out.println("Els usuaris donats d'alta son " + k[1]);
    }

    public static void ultimUser(int k[], Date fechaUser[], Date fecha[], String usuarios[]) {
        for (int h = 0; h < k[0]; h++) {
            if (fechaUser[0].equals(fecha[h])) {
                System.out.println("L'ùltim usuari donat d'alta va ser "
                        + usuarios[h] + " " + fecha[h]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        Random random = new Random();

        String password = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String[] usuarios = new String[10];
        String[] nombres = new String[10];
        String[] passw = new String[10];
        Date[] fecha = new Date[10];
        int[] k = {0, 0, 0, 0};
        String nom = null, apellido1 = null, apellido2 = null, nombreCompleto = null;
        String letraUser = null, apellidoUser = null, user = null, contraAdmin = null;
        int seleccion = 0, seleccion2 = 0, seleccion3 = 0;
        Date[] fechaUser = new Date[1];
        
        completo(lector, password, usuarios, nombres, passw, fecha, k, nom, apellido1, apellido2, nombreCompleto,
        letraUser, apellidoUser, user, contraAdmin, seleccion, seleccion2, seleccion3, fechaUser);

    }
}
