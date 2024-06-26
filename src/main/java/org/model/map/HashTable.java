/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.map;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.model.LinkedList.singly.circular.LinkedList;
import org.model.array.Array;

/**
 *
 * @author informatica
 */
public class HashTable<E> extends AbstractHashTable<E> {

    public Array<LinkedList<E>> tabla;
    int oddNearest;

    public Array<LinkedList<E>> getTabla() {
        return tabla;
    }

    public HashTable(int dimension) {
        this.oddNearest = dimension;
        this.tabla = new Array<>(dimension);
        for (int i = 0; i < dimension; i++) {
            tabla.add(new LinkedList<>());
        }
        previousOddNumber();
    }
//Inventado
//    private int dispersionFunction(String key) {
//        char[] caracteres = key.toCharArray();
//        int hash = 0;
//        for (int i = 0; i<caracteres.length; i++) {
//            hash += caracteres[i] * (i+1);
//        }
//        int indice = hash % oddNearest;    
//        return indice;
//    }
// 7399 7418 7414

//Multiplicacion de Hash    
//    private int dispersionFunction(String key) {
//        int factor = 31;
//        int hash = 0;
//        for (int i = 0; i < key.length(); i++) {
//            hash = (hash * factor) + key.charAt(i); 
//        }
//        return Math.abs(hash) % oddNearest; 
//    }
//4300 4302 4289
//Desplazamiento y resta
//    private int dispersionFunction(String key) {
//        int hash = 0;
//        for (int ii = 0; ii < key.length(); ii++) {
//            hash = (hash << 5) - hash + key.charAt(ii); // Utilizando una combinación de desplazamiento y resta
//        }
//        return Math.abs(hash) % oddNearest;
//    }
//4225, 4204, 4273
//Cuadrados medios
    private int dispersionFunction(String key) {
        int hash = 0;
        int square;
        int numDigits = 4; // Número de dígitos que deseamos en nuestro hash

        for (int ii = 0; ii < key.length(); ii++) {
            hash = (hash << 5) - hash + key.charAt(ii); // Utilizando una combinación de desplazamiento y resta
        }

        // Calcular el cuadrado del valor generado
        square = hash * hash;

        // Convertir el cuadrado en una cadena para obtener los dígitos centrales
        String squareStr = Integer.toString(square);

        // Calcular el índice central
        int startIndex = (squareStr.length() - numDigits) / 2;

        // Tomar los dígitos centrales y convertirlos en un número
        int hashValue = Integer.parseInt(squareStr.substring(startIndex, startIndex + numDigits));

        // Devolver el valor de dispersión
        return hashValue % oddNearest;
    }

//Hashing por division
//    private int dispersionFunction(String key) {
//        int hash = 0;
//        for (int i = 0; i < key.length(); i++) {
//            hash += key.charAt(i); // Sumamos los valores ASCII de los caracteres
//        }
//        return hash % oddNearest; // Tomamos el residuo para obtener el índice
//    }
// 9170 9164 9153
    private void previousOddNumber() {
        boolean worth = true;
        while (worth) {
            boolean internalConfirm = true;
            for (int i = 2; i < oddNearest / 2; i++) {
                if (oddNearest % i == 0) {
                    oddNearest--;
                    internalConfirm = false;
                    break;
                }
            }
            if (internalConfirm) {
                worth = false;
            }
        }
    }

    @Override
    public boolean put(String key, E element) {
        try {
            tabla.get(dispersionFunction(key)).add(element);
            return true;
        } catch (Exception e) {
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, e.getMessage(), e);
        }
        return false;
    }

    @Override
    public E get(String key) {
        try {
            return tabla.get(dispersionFunction(key)).peekLast();
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean remove(String key) {
        try {
            tabla.get(dispersionFunction(key)).pollLast();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
