package graficotortuga;

import java.util.Scanner;

public class GraficoTortuga {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    int[][] piso = new int[40][40];//crea un arreglo bidimensional de 40 lugares x 40 lugares
    int respuesta;//guarda las respuestas del usuario
    int ultFila = 0, ultCol = 0;//recuerda la ultima posicion de la tortuga
    int pasos;//aloja cuantos pasos hace la tortuga
    int movDer = 1;//segun el valor de la variable es donde tiene que ir para poder hacer ese giro
    int movIzq = 1;//segun el valor de la variable es donde tiene que ir para poder hacer ese giro
    boolean plumaArriba = false, plumaAbajo = false, derecha = false, izquierda = false;
    
    //llena el arreglo bidimensional con 0
    for (int fila = 0; fila < 40; fila++) {
      for (int columna = 0; columna < 40; columna++) {
        piso[fila][columna] = 0;
      }
    }
    printMenu();
    respuesta = Integer.parseInt(reader.nextLine());
    while (respuesta != 9) {//si eligen 9 el programa termina

      if (respuesta == 1) {//plumaArriba
        plumaArriba = true;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      } else if (respuesta == 2) {//plumaAbajo
        plumaArriba = false;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      } else if (respuesta == 3) {//derecha
        derecha = true;
        izquierda = false;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      } else if (respuesta == 4) {//izquierda
        derecha = false;
        izquierda = true;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      } else if ((respuesta == 5) && (derecha == true) && (movDer == 1) && (plumaArriba == false)) {//se mueve a la derecha dibujando
        System.out.print("Cuantos pasos?: ");
        pasos = Integer.parseInt(reader.nextLine());//pregunta cuantos espacios
        for (int i = 0; i < pasos; i++) {
          piso[ultFila][ultCol + i] = 1;
        }
        ultCol += pasos - 1;//asigna la nueva posicion
        movDer = 2;
        movIzq = 2;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      }
      if ((respuesta == 5) && (derecha == true) && (movDer == 1) && (plumaArriba == true)) {//se mueve a la derecha sin dibujar
        System.out.print("Cuantos pasos?: ");
        pasos = Integer.parseInt(reader.nextLine());//pregunta cuantos espacios
        ultCol += pasos;//asigna la nueva posicion
        movDer = 2;
        movIzq = 2;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      }
      if ((respuesta == 5) && (derecha == true) && (movDer == 2) && (plumaArriba == false)) {//se mueve a la derecha dibujando
        System.out.print("Cuantos pasos?: ");
        pasos = Integer.parseInt(reader.nextLine());//pregunta cuantos espacios
        for (int i = 0; i < pasos; i++) {
          piso[ultFila + i][ultCol] = 1;
        }
        ultFila += pasos - 1;
        movDer = 3;
        movIzq = 1;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      }
      if ((respuesta == 5) && (derecha == true) && (movDer == 2) && (plumaArriba == true)) {//se mueve a la derecha sin dibujar
        System.out.print("Cuantos pasos?: ");
        pasos = Integer.parseInt(reader.nextLine());//pregunta cuantos espacios
        ultFila += pasos - 1;
        movDer = 3;
        movIzq = 1;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      }
      if ((respuesta == 5) && (derecha == true) && (movDer == 3) && (plumaArriba == false)) {//se mueve a la derecha dibujando
        System.out.print("Cuantos pasos?: ");
        pasos = Integer.parseInt(reader.nextLine());//pregunta cuantos espacios
        for (int i = 0; i < pasos; i++) {
          piso[ultFila][ultCol - i] = 1;
        }
        ultCol -= pasos - 1;//asigna la nueva posicion
        movDer = 4;
        movIzq = 3;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      }
      if ((respuesta == 5) && (derecha == true) && (movDer == 3) && (plumaArriba == true)) {//se mueve a la derecha sin dibujar
        System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
        pasos = Integer.parseInt(reader.nextLine());
        ultCol -= pasos - 1;//asigna la nueva posicion
        movDer=4;
        movIzq = 3;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      }
      if ((respuesta == 5) && (derecha == true) && (movDer == 4) && (plumaArriba == false)) {//se mueve a la derecha dibujando
        System.out.print("Cuantos pasos?: ");
        pasos = Integer.parseInt(reader.nextLine());//pregunta cuantos espacios
        for (int i = 0; i < pasos; i++) {
          piso[ultFila - i][ultCol] = 1;
        }
        ultFila -= pasos - 1;//asigna la nueva posicion
        movDer = 1;
        movIzq = 4;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      }
      if ((respuesta == 5) && (derecha == true) && (movDer == 4) && (plumaArriba == true)) {//se mueve a la derecha sin dibujar
        System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
        pasos = Integer.parseInt(reader.nextLine());
        ultFila -= pasos - 1;//asigna la nueva posicion
        movDer = 1;
        movIzq = 4;
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      }
      //movimientos a la izquierda 
      if ((respuesta == 5) && (izquierda == true)) {

        if ((movIzq == 1) && (plumaArriba == false)) {//se mueve a la izquierda dibujando
          System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
          pasos = Integer.parseInt(reader.nextLine());
          for (int i = 0; i < pasos; i++) {
            piso[ultFila][ultCol + i] = 1;
          }
          ultCol += pasos - 1;//asigna la nueva posicion
          movIzq = 2;
          movDer = 2;
          printMenu();
          respuesta = Integer.parseInt(reader.nextLine());
        } else if ((movIzq == 1) && (plumaArriba == true)) {//se mueve a la izquierda sin dibujar
          System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
          pasos = Integer.parseInt(reader.nextLine());
          ultCol += pasos - 1;//asigna la nueva posicion
          movIzq = 2;
          movDer = 2;
          printMenu();
          respuesta = Integer.parseInt(reader.nextLine());
        } else if ((movIzq == 2) && (plumaArriba == false)) {//se mueve a la izquierda dibujando
          System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
          pasos = Integer.parseInt(reader.nextLine());
          for (int i = 0; i < pasos; i++) {
            piso[ultFila - i][ultCol] = 1;
          }
          ultFila -= pasos - 1;//asigna la nueva posicion
          movDer = 1;
          movIzq = 4;
          printMenu();
          respuesta = Integer.parseInt(reader.nextLine());
        } else if ((movIzq == 2) && (plumaArriba == true)) {//se mueve a la izquierda sin dibujar
          System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
          pasos = Integer.parseInt(reader.nextLine());
          ultFila -= pasos - 1;//asigna la nueva posicion
          movDer = 1;
          movIzq = 4;
          printMenu();
          respuesta = Integer.parseInt(reader.nextLine());
        }else if ((movIzq == 3) && (plumaArriba == false)) {//se mueve a la izquierda dibujando
          System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
          pasos = Integer.parseInt(reader.nextLine());
          for (int i = 0; i < pasos; i++) {
            piso[ultFila + i][ultCol] = 1;
          }
          ultFila += pasos - 1;//asigna la nueva posicion
          movDer = 3;
          movIzq = 1;
          printMenu();
          respuesta = Integer.parseInt(reader.nextLine());
        } else if ((movIzq == 3) && (plumaArriba == true)) {//se mueve a la izquierda sin dibujar
          System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
          pasos = Integer.parseInt(reader.nextLine());
          ultFila += pasos - 1;//asigna la nueva posicion
          movDer = 3;
          movIzq = 1;
          printMenu();
          respuesta = Integer.parseInt(reader.nextLine());
        }else if ((movIzq == 4) && (plumaArriba == false)) {//se mueve a la izquierda dibujando
          System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
          pasos = Integer.parseInt(reader.nextLine());
          for (int i = 0; i < pasos; i++) {
            piso[ultFila][ultCol - i] = 1;
          }
          ultCol -= pasos - 1;//asigna la nueva posicion
          movIzq = 3;
          movDer = 2;
          printMenu();
          respuesta = Integer.parseInt(reader.nextLine());
        } else if ((movIzq == 4) && (plumaArriba == true)) {//se mueve a la izquierda sin dibujar
          System.out.print("Cuantos pasos?: ");//pregunta cuantos espacios
          pasos = Integer.parseInt(reader.nextLine());
          ultCol -= pasos - 1;//asigna la nueva posicion
          movIzq = 3;
          movDer = 2;
          printMenu();
          respuesta = Integer.parseInt(reader.nextLine());
        }
      } else if (respuesta == 6) {//imprime el piso
        mostrarGrafico(piso);
        printMenu();
        respuesta = Integer.parseInt(reader.nextLine());
      }
    }
  }
  //metodo para imprimir el menu

  public static void printMenu() {
    System.out.println("1-Pluma Arriba\t\t"
      + "2-Pluma Abajo\n"
      + "3-Voltear Derecha\t"
      + "4-Voltear Izquierda\n"
      + "5-Avanzar x espacios\t"
      + "6-Mostrar Grafico\n"
      + "9-Salir");
  }

  //metodo para imprimir el piso
  public static void mostrarGrafico(int[][] arreglo) {
    for (int fila = 0; fila < 20; fila++) {
      for (int columna = 0; columna < 20; columna++) {
        if (arreglo[fila][columna] == 0) {
          System.out.print(" ");
        } else {
          System.out.print("*");
        }
      }
      System.out.println();
    }
  }

}
