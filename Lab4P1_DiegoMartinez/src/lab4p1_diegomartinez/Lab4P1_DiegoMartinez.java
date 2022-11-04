//Diego Martinez
package lab4p1_diegomartinez;

import java.util.Scanner;

public class Lab4P1_DiegoMartinez {

    static Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Menu");
            System.out.println("1 -> Sumador Binario");
            System.out.println("2 -> Contains");
            System.out.println("3 -> Alpha");
            System.out.println("Ingrese la opcion que usted quiere: ");
            opcion = read.nextInt();

            switch (opcion) {
                case 1: {
                    String n1, n2;
                    System.out.println("1 -> Sumador Binario");
                    System.out.println("Ingrese su primer digito: ");
                    n1 = read.next();
                    System.out.println("Ingrese su segundo digito: ");
                    n2 = read.next();
                    do {
                        if (n1.length() != n2.length()) {
                            System.out.println("El segundo numero no valido, tienen que ser iguales de largo, vuelva a ingresar el numero");
                            n2 = read.next();
                        } else if (n2.length() != n1.length()) {
                            System.out.println("El primer numero no valido, tienen que ser iguales de largo, vuelva a ingresar el numero");
                            n1 = read.next();
                        }
                    } while (n1.length() != n2.length());
                    int c1 = 0, c2 = 0;
                    for (int i1 = 0; i1 < n1.length(); i1++) {
                        char b1 = n1.charAt(i1);
                        if ((int) b1 < 48 || (int) b1 > 49) {
                            c1++;
                        }
                    }
                    if (c1 != 0) {
                        System.out.println("El primer numero es invalido, solo use 0 o 1.");
                        n1 = read.next();
                    }
                    for (int i2 = 0; i2 < n2.length(); i2++) {
                        char b2 = n2.charAt(i2);
                        if ((int) b2 < 48 || (int) b2 > 49) {
                            c2++;
                        }
                    }
                    if (c2 != 0) {
                        System.out.println("El segundo numero es invalido, solo use 0 o 1.");
                        n2 = read.next();
                    }
                    sum(n1, n2);

                }
                break;
                case 2: {
                    String c1, c2;
                    System.out.println("2 -> Contains");
                    System.out.println("Introduzca su palabra");
                    read.nextLine();
                    c1 = read.nextLine();
                    System.out.println("Introduzca su cadena a ver si se encuentra adentro de la palabra");
                    c2 = read.nextLine();
                    if (c2.length() > c1.length()) {
                        System.out.println("El tamaño de la segunda cadena no puede ser mayor que el de la primera");
                        System.out.println("Introduzca su palabra");
                        c1 = read.nextLine();
                        System.out.println("Introduzca su cadena a ver si se encuentra adentro de la palabra");
                        c2 = read.nextLine();
                    }
                    contains(c1, c2);
                }
                break;
                case 3: {
                    String cad, cadl;
                    int c3 = 0;
                    System.out.println("3 -> Alpha");
                    System.out.println("Ingrese su cadena: ");
                    read.nextLine();
                    cad = read.nextLine();
                    cadl = cad.toLowerCase();
                    si_alpha(cadl, c3);
                }
                break;
            }//End Switch
        }//End Do
        while (opcion != 4);
    }//End Main

    public static void sum(String n1, String n2) {
        int c1;
        c1 = 0;
        String rem = "";
        for (int i = n1.length() - 1; i >= 0; i--) {
            if (c1 == 0) {
                if (n1.charAt(i) == '1' && n2.charAt(i) == '1') {
                    rem = 0 + rem;
                    c1 = 1;
                } else if (n1.charAt(i) == '0' && n2.charAt(i) == '1') {
                    rem = 1 + rem;
                    c1 = 0;
                } else if (n1.charAt(i) == '1' && n2.charAt(i) == '0') {
                    rem = 1 + rem;
                    c1 = 0;
                } else if (n1.charAt(i) == '0' && n2.charAt(i) == '0') {
                    rem = 0 + rem;
                    c1 = 0;
                }
            } else {
                if (n1.charAt(i) == '1' && n2.charAt(i) == '1') {
                    rem = 1 + rem;
                    c1 = 1;
                } else if (n1.charAt(i) == '0' && n2.charAt(i) == '1') {
                    rem = 0 + rem;
                    c1 = 1;
                } else if (n1.charAt(i) == '1' && n2.charAt(i) == '0') {
                    rem = 0 + rem;
                    c1 = 1;
                } else if (n1.charAt(i) == '0' && n2.charAt(i) == '0') {
                    rem = 1 + rem;
                    c1 = 0;
                }
            }
        }
        if (c1 == 1) {
            rem = 1 + rem;
        } 
        System.out.println("La suma es: " + rem);
    }//End sum

    public static void contains(String c1, String c2) {
        int c = 1, c1l, c2l;
        String s;
        c1l = c1.length();
        c2l = c2.length();
        for (int i = 0; i < c1l - (c2l - 1); i++) {
            s = c1.substring(i, c2l + i);
            if (s.equals(c2)) {
                System.out.println("La cadena " + c1 + " contiene a la cadena " + c2);
                c = 0;
            }
        }
        if (c == 1) {
            System.out.println("La cadena " + c1 + " no contiene a la cadena " + c2);
        }

    }//End Contains

    public static void si_alpha(String cadl, int c3) {
        for (int i = 0; i < cadl.length(); i++) {
            char b3 = cadl.charAt(i);
            if ((int) b3 < 97 || (int) b3 > 122) {
                c3++;
            }
        }
        if (c3 != 0) {
            System.out.println("La cadena contiene caracteres que no son letras");
        } else {
            System.out.println("La cadena solo contiene letras");
        }
    }//End Alpha
}//End Class
