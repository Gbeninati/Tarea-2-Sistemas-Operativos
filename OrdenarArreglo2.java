import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class OrdenarArreglo2 {
  //Variable que guardara el arreglo a ordenar
  public static int[] a;

  /*****
	* public static void merge(int [] a,int i,int m,int d)
	******
	* Metodo que se encarga de ordenar un arreglo utilizando el algoritmo de Merge Sort
	******
	* Input:
	* int [] a: Corresponde al arrelgo a ordenar
  * int i: Correspode a la posicion izquierda del arreglo
	******
	* Returns:
	*   void
	*****/
  public static void merge(int [] a,int i,int m,int d){
    int derecha = m+1;
    while(i<=m && derecha <=d){
    if (a[i]<=a[derecha]){
        i++;
    }
    else{
        int temp = a[derecha];
           System.arraycopy(a, i, a, i+1, derecha-i);
           a[i]= temp;
           i++;
           derecha++;
           m++;
         }
       }
    }
    /*****
    * public static void mergeSort(int [] a,int i,int d)
    ******
    * Metodo que se encarga de dividir el arrelgo a desde la posicion i hasta la d en subarreglos de tamaño 1 para luego ordenar los elementos utilizando merge
    ******
    * Input:
    * int [] a: Corresponde al arrelgo a ordenar
    * int i: Correspode a la primera posicion desde donde se ordenara el arreglo
    * int d: Corresponde a la ultima posicion hasta donde se ordenara el arreglo
    ******
    * Returns:
    *   void
    *****/
    public static void mergeSort(int []a ,int i,int d){
      //Si la posicion izquierda continua siendo menor a la derecha, el arreglo puede dividirse
      if(i < d){
        // Se define la posicion media del arrelgo para asi dividirlo
        int m = (i+d)/2;
        //Cada mitad se divide llamando de manera recursiva a la funcion
        mergeSort(a, i, m);
        mergeSort(a, m+1,d);
        //Se unen nuevamente los subarreglos utilizando merge sort, es decir, los elementos del arrelgo desde la posicion i a la d se ordenan
        merge(a, i, m, d);
      }
    }

    /*****
    * public static class  Hebra extends Thread
    ******
    * Para utilizar hebras, se debe extender la clase Threads. Cada hebra correra el algoritmo merge sort para una parte del arreglo (desde la posicion i a la d)
    ******
    *****/
    public static class  Hebra extends Thread{
      // Variables que guardaran la posicion inicial y final del subarreglo del arreglo principal
      int i,d;
      public Hebra(int i,int d) {
        this.i = i;
        this.d = d;
      }
      @Override
      public void run(){
        mergeSort(a, i, d);
      }
    }

    /*****
    * public static void ordenar()
    ******
    * Metodo que se encarga de ordenar el arreglo a iniciado al principio del codigo utilizando dos hebras
    ******
    * Input:
    *   void
    ******
    * Returns:
    *   void
    *****/
    public static void ordenar()throws Exception{
      System.out.println("Tu arreglo sin ordenar corresponde a:\n");
      System.out.println(Arrays.toString(a));

      // Se inicializan 2 hebras, la primera realizara el algoritmo merge sort desde el comienzo del arreglo hasta la mitad de este, y la seunda lo realizara desde la mitad+1 hasta el final
      Hebra h1 = new Hebra(0,a.length/2);
      Hebra h2 = new Hebra((a.length/2)+1,a.length - 1);

      h1.start();
      h2.start();

      h1.join();
      h2.join();

      //Se realiza merge en los 2 subarregos obtenidos. Si se utilizan n hebras, se deben realizar merge entre los n subarreglos
      merge(a,0,a.length/2, a.length-1);
      System.out.println("Tu arreglo ordenado corresponde a:\n");
      System.out.println(Arrays.toString(a));
     }


     public static void main(String[] args) throws Exception{
       //Codigo utilizado para pedir por consola el arreglo
       int largo, numero;
       int cont = 0;
       System.out.println("Ingrese largo del arreglo");
       Scanner Large = new Scanner(System.in);
       largo = Large.nextInt();
       int[] valores = new int[largo];
       while(cont < largo){
         System.out.println("Ingrese numero de la posicion " + cont);
         Scanner Number = new Scanner(System.in);
         numero = Number.nextInt();
         valores[cont] = numero;
         cont++;
       }
       //Se iguala el areglo definido al comienzo con el entregado por consola
       a = valores;
       //Se ordena el arreglo
       ordenar();
    }
}
