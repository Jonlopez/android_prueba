package com.dam.jon.entrega_2;

import java.util.Hashtable;

/**
 * Created by jon on 08/12/2016.
 */

public class OperationsAction {

    private Hashtable<Integer, Integer> hashtable_primos = new Hashtable<Integer, Integer>();
    private Integer primo;

    public Integer primoByPosicion(Integer pos){

        this.primo = (this.hashtable_primos.size() > 0 && this.hashtable_primos.get(pos)!=null)? this.hashtable_primos.get(pos) : calcularPrimo(pos);

        return this.primo;
    }

    private Integer calcularPrimo(Integer pos){

        Integer resultado = 0;
        int num_evl = 1;
        int posicion = pos;
        for (int x = 1; x<pos; x++)
        {
            if(esPrimo(num_evl)){
                if(posicion == 0){
                    resultado = num_evl;
                    break;
                }else{
                 posicion -= 1;
                }

            }else {
                if(x+1 == pos)
                    x -= 1;
            }
            num_evl += 1;
        }


        capturarPrimo(pos, resultado);

        return resultado;
    }

    private static boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }

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
