package com.dam.jon.entrega_2;

import java.util.Hashtable;

/**
 * Created by jon on 08/12/2016.
 */

public class OperationsAction {

    private Hashtable<Integer, Integer> hashtable_primos = new Hashtable<Integer, Integer>();

    private Integer primo;

    public Integer primoByPosicion(Integer pos){

        //Si la tabla contiene elementos Y el primo buscado se encuentra en ella lo retornamos
        //Si No comprobamos si es el primer número primo el que ns preguntan y retornamos un 1
        //Si No calculamos el número primo por la posicion y lo insertamos en la tabla de primos (key, value)

        this.primo = (this.hashtable_primos.size() > 0 && this.hashtable_primos.get(pos)!=null)? this.hashtable_primos.get(pos) : (pos == 1)? this.primo = 1 : calcularPrimo(pos);

        return this.primo;

    }

    private Integer calcularPrimo(Integer pos){
        //Inicializamos el resultado
        int resultado = 0;
        //Capturamos la posicion para poder jugar con ella si sobreescribir
        int posicion = pos;
        /* Empezamos a comprobar desde el número 2 ya que el número 1 siempre es primo
         * Y aunque sepamos que el 2 y 3 tambien son primos, hay que empezar por algun lado
        */
        int num_evl = 2;
        // Miestra la poscion sea Mayor que 1 todavía quedan numeros que comprobar
        while ( posicion > 1 ){
            //Si el numero A comprobar es primo UNA POSICIÓN MENOS NOS QUEDA PARA ADIVINAR EL DESEADO
            if( esPrimo(num_evl) )posicion -= 1;
            //Mientras no hayamos encontrado el número deseado Incrementamos el número a evaluar en 1 para proseguir
            if( posicion > 1 )num_evl += 1;
        }

        //Si hemos salido de la repitiva significa que ya hemos encontrado nuestro número primo
        resultado = num_evl;
        //Después de calcular el numero lo alamacenaremos en nuestra tabla (clave, valor)
        // donde uestra clave será la posicion para un acceso mas rapido la próxima vez que se solicite
        capturarPrimo(pos, resultado);
        //Retornamos el número primo calculado
        return resultado;
    }

    private static boolean esPrimo(int numero){
        //Establecemos el contador a 2 ya que hemos decidido que el la posicion Uno es el primo 1
        int contador = 2;
        //Inicializamos la comprobación a verdadero
        boolean primo=true;
        //Mientras no se diga que el número no es primo y el contador sea diferente que el número
        // a evaluar seguimos comprobando
        while ((primo) && (contador!=numero)){
            //Si el número % contador da de resto 0 no es primo
            if (numero % contador == 0)primo = false;
            //Incrementamos el contador para la siguiente comprobacion
            contador++;
        }
        //Devolvemos true o false si el numero a evaluar es primo o no
        return primo;
    }

    //Introducimos el nuevo número primo calculado en la tabla de número primos
    private void capturarPrimo (Integer pos, Integer primo){
        hashtable_primos.put(pos, primo);
    }

    public Hashtable<Integer, Integer> getHashtable_primos() {
        return hashtable_primos;
    }

    public void setHashtable_primos(Hashtable<Integer, Integer> hashtable_primos) {
        this.hashtable_primos = hashtable_primos;
    }
}
