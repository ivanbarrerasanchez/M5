/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosUserYPassIvanB;

import java.util.Scanner;
import java.util.Date;
/**
 *
 * @author Ivan
 */
public class MetodosUserYPassIvanB {

    /**
     * @param args the command line arguments
     */
    public static void complet(Scanner lector, int maxUser, String usuaris[][], int usuarisActius,
            String inicial[][], String passwd, boolean primerUser, String proba) {
        int eleccion;
        crearAdmin(maxUser, usuaris, proba);
        omplirMatriu(maxUser, inicial, proba);
        while (true) {
            System.out.println("Introdueix l'opcio desitjada:");
            System.out.println("0. Sortir\n"
                    + "1. Entrar com Usuari\n"
                    + "2. Entrar com Administrador\n"
                    + "-----------------------------");
            eleccion = lector.nextInt();
            lector.nextLine();
            if (eleccion == 0) {
                break;
            } else if (eleccion < 0 || eleccion > 4) {
                System.out.println("Introdueix un numero vàlid");
            } else {
                menu(eleccion, lector, maxUser, usuaris, usuarisActius, inicial, passwd, primerUser);
            }
        }
    }

    public static void crearAdmin(int usuaris, String matriu[][], String admin) {
        for (int i = 0; i < usuaris; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                if (i == 0) {
                    matriu[i][0] = "admi";
                    matriu[i][1] = "nis";
                    matriu[i][2] = "trador";
                    matriu[i][3] = "admin";
                    matriu[i][4] = "P@ssw0rd!";
                    break;
                }
                matriu[i][j] = admin;
            }
        }
    }

    public static void omplirMatriu(int usuaris, String matriu[][], String users) {
        for (int i = 0; i < usuaris; i++) {
            for (int j = 0; j < matriu[i].length; j++) {
                matriu[i][j] = users;
            }
        }
    }

    public static void menu(int eleccio, Scanner lector, int maxUser, String usuaris[][], int usuarisActius, String inicial[][],
            String passwd, boolean primerUser) {
        switch (eleccio) {
            case 1:
                System.out.println("Introdueix l'usuari:");
                String seleccio = lector.nextLine();
                System.out.println("Introdueix la contrasenya:");
                String passUser = lector.nextLine();
                int numUsuari = 0;
                boolean login = false;
                for (int i = 0; i < maxUser; i++) {
                    if (passUser.equals(usuaris[i][4])) {
                        login = true;
                        numUsuari = i;
                        break;
                    }
                }
                if (login == true) {
                    System.out.printf("Benvolgut Usuari %s\n", eleccio);
                    while (true) {
                        System.out.println("Introdueix l'opció desitjada\n"
                                + "0. Sortir\n"
                                + "1. Editar nom i cognoms\n"
                                + "2. Generar contrasenya\n"
                                + "3. Baixa d'usuari");
                        eleccio = lector.nextInt();
                        lector.nextLine();
                        if (eleccio > 5 || eleccio < 0) {
                            System.out.println("Introdueix un numero vàlid");
                        } else if (eleccio == 0) {
                            break;
                        } else {
                            menuUsuari(eleccio, usuaris, lector, numUsuari, inicial, maxUser);
                        }
                    }
                } else {
                    System.out.println("Contrasenya incorrecta.");
                    break;
                }
                break;
            case 2:
                System.out.println("Introdueix la contrasenya:");
                String pass = lector.nextLine();
                if (pass.equals(usuaris[0][4])) {
                    System.out.println("\nBenvolgut administrador");
                    while (true) {
                        System.out.println("Introdueix l'opcio desitjada:\n"
                                + "0. Salir\n"
                                + "1. Veure usuaris\n"
                                + "2. Mostrar numero d'usuaris\n"
                                + "3. Últim acces\n"
                                + "4. Donar de baixa un usuari\n"
                                + "5. Donar d'alta un usuari");
                        eleccio = lector.nextInt();
                        lector.nextLine();
                        if (eleccio > 5 || eleccio < 0) {
                            System.out.println("Introdueix un numero vàlid");
                        } else if (eleccio == 0) {
                            break;
                        } else {
                            menuAdmin(eleccio, maxUser, usuaris, usuarisActius, inicial, lector, passwd, primerUser);
                        }
                    }
                } else {
                    System.out.println("Contrasenya incorrecta");
                    break;
                }
            default:
                break;
        }
    }

    public static void menuAdmin(int eleccio, int maxUser, String usuaris[][], int usuarisActius,
            String inicial[][], Scanner lector, String passwd, boolean primerUsuari) {
        switch (eleccio) {
            case 1:
                admin1(maxUser, usuaris);
                break;
            case 2:
                admin2(usuarisActius);
                break;
            case 3:
                admin3();
                break;
            case 4:
                admin4(lector, maxUser, usuaris, inicial);
                break;
            case 5:
                admin5(usuarisActius, usuaris, lector, primerUsuari, passwd);
                break;
            default:
                break;
        }
    }

    public static void menuUsuari(int eleccio, String usuaris[][], Scanner lector, int numUsuari,
            String inicial[][], int maxUser) {
        switch (eleccio) {
            case 1:
                usuari1(usuaris, lector, numUsuari);
                break;
            case 2:
                usuari2(usuaris, lector, numUsuari);
                break;
            case 3:
                usuari3(usuaris, numUsuari, maxUser, inicial);
                break;
            default:
                break;
        }
    }

    public static void admin1(int usuaris, String matriu[][]) {
        System.out.println("Nom     Cognom1    Cognom2    Usuari      Pass");
        for (int i = 0; i < usuaris; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%-10s", matriu[i][j]);
            }
            System.out.println("");
        }
    }

    public static void admin2(int usuaris) {
        System.out.printf("Ara mateix hi ha : %d usuaris %n", usuaris);
    }

    public static void admin3() {
        java.util.Date dataInici = new Date();
        System.out.println(dataInici + "\n");
    }

    public static void admin4(Scanner lector, int usuaris, String matriu[][], String inicial[][]) {
        boolean baixaUsuari = false;
        System.out.println("Introdueix l'usuari a donar de baixa");
        String baixa = lector.nextLine();
        for (int i = 0; i < usuaris; i++) {
            if (matriu[i][3].equals(baixa)) {
                System.out.println("Usuari esborrat");
                for (int j = 0; j < 5; j++) {
                    matriu[i][j] = "";
                }
                baixaUsuari = true;
                break;
            }
        }
        for (int m = 0; m < usuaris; m++) {
            for (int i = 0; i < matriu[i].length; i++) {
                if (matriu[i][0].equals("")) {
                    i++;
                    for (int j = 0; j < 5; j++) {
                        inicial[i][j] = matriu[i][j];
                        matriu[i][j] = "";
                        matriu[--i][j] = inicial[++i][j];
                    }
                    i--;
                }
            }
        }
        if (baixaUsuari == false) {
            System.out.println("No s'ha trobat");
        }
    }

    public static void admin5(int usuarisActius, String usuaris[][], Scanner lector, boolean primerUsuari, String passwd) {
        int posicioUsuari = usuarisActius;
        for (int j = 0, i = usuarisActius; j < usuaris[i].length; j++) {
            switch (j) {
                case 0:
                    recullNom(usuaris, i, j, lector);
                    break;
                case 1:
                    recullCognom1(usuaris, i, j, lector);
                    break;
                case 2:
                    recullCognom2(usuaris, i, j, lector);
                    break;
                case 3:
                    String lletraUser = usuaris[i][0].toLowerCase().substring(0, 1);
                    String cognomUser = usuaris[i][1].toLowerCase();
                    String user = lletraUser + cognomUser;
                    
                    if (usuarisActius == 1) {
                        System.out.println("Ets el primer :)");
                        usuaris[i][j] = user;
                        primerUsuari = true;
                    }
                    crearUsuaris(usuaris, usuarisActius, primerUsuari, user, lletraUser, cognomUser, posicioUsuari);
                    break;
                case 4:
                    String pass = "";
                    generarPasswd(passwd, usuarisActius, usuaris, pass);
                    if (primerUsuari == true) {
                        usuaris[usuarisActius][4] = pass;
                    }
                    break;
                default:
                    break;
            }   usuarisActius++;
        }
    }

    public static void recullNom(String matriu[][], int y, int j, Scanner lector) {
        System.out.println("Introdueix el teu nom");
        matriu[y][j] = lector.nextLine();
    }
    public static void recullCognom1(String matriu[][], int y, int j, Scanner lector) {
        System.out.println("Introdueix el teu primer cognom");
        matriu[y][j] = lector.nextLine();
    }
    public static void recullCognom2(String matriu[][], int y, int j, Scanner lector) {
        System.out.println("Introdueix el teu segon cognom");
        matriu[y][j] = lector.nextLine();
    }

    public static void crearUsuaris(String matriu[][], int usuarisActius, boolean primerUsuari,
            String user, String lletraUsuari, String cognomUsuari, int posicioUsuari) {
        int duplicados = 0;
        for (int k = 0; k < usuarisActius; k++) {
            if (matriu[k][3].equals(user)) {
                duplicados++;
                user = lletraUsuari + cognomUsuari + duplicados;
            }
        }
        if (duplicados == 0) {
            System.out.println("Nuevo usuario creado!");
            matriu[posicioUsuari][3] = lletraUsuari + cognomUsuari;
        } else {
            System.out.println("El usuario ya existe! Le asignare un numero.");
            matriu[posicioUsuari][3] = lletraUsuari + cognomUsuari + duplicados;
        }
        usuarisActius++;
    }

    public static void generarPasswd(String nomComplet, int usuarisActius, String matriu[][], String passw) {
        for (int l = 0; l <= 8; l++) {
            int numero = (int) (Math.random() * nomComplet.length());
            passw += nomComplet.charAt(numero);
        }
    }

    public static void usuari1(String matriu[][], Scanner lector, int numUsuari) {
        System.out.println("Introdueix el nou nom");
        matriu[numUsuari][0] = lector.nextLine();
        System.out.println("Introdueix el nou cognom 1");
        matriu[numUsuari][1] = lector.nextLine();
        System.out.println("Introdueix el nou cognom 2");
        matriu[numUsuari][2] = lector.nextLine();
    }

    public static void usuari2(String matriu[][], Scanner lector, int numUsuari) {
        System.out.println("Introdueix la nova contrasenya");
        matriu[numUsuari][4] = lector.nextLine();
    }

    public static void usuari3(String matriu[][], int numUsuari, int maxUser, String inicial[][]) {
        for (int i = 0; i < numUsuari; i++) {
            for (int j = 0; j < 5; j++) {
                matriu[numUsuari][j] = "";
            }
        }
        System.out.println("Usuari esborrat");
        for (int m = 0; m < maxUser; m++) {
            for (int i = 0; i < matriu[i].length; i++) {
                if (matriu[i][0].equals("")) {
                    i++;
                    for (int j = 0; j < 5; j++) {
                        inicial[i][j] = matriu[i][j];
                        matriu[i][j] = "";
                        matriu[--i][j] = inicial[++i][j];
                    }
                    i--;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int maxUser = 10;
        int usuarisActius = 1;
        boolean primerUsuari = false;
        String[][] usuarios = new String[maxUser][5];
        String[][] inicial = new String[maxUser][5];
        String proba = " ";
        String passwd = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        complet(lector, maxUser, usuarios, usuarisActius, inicial, passwd, primerUsuari, proba);
    }
}