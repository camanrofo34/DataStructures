/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.map;

import java.util.Random;
import org.model.LinkedList.singly.circular.LinkedList;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class HashTry {
    
    public static void main(String[] args) {
        int dimensionTabla = 10000; // Tamaño de la tabla hash (primo para una mejor dispersión)
        HashTable<String> hashTable = new HashTable<>(dimensionTabla);

        // Generar 10,000 valores aleatorios
        for (int i = 0; i < 10000; i++) {
            String clave = generarClaveAleatoria();
            hashTable.put(clave, "Valor" + i);
        }

        // Contar colisiones
        int colisiones = contarColisiones(hashTable);
        System.out.println("Número de colisiones: " + colisiones);
    }

    // Método para generar una clave aleatoria
    private static String generarClaveAleatoria() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        int length = random.nextInt(10) + 1; // Longitud de la clave entre 1 y 10 caracteres
        for (int i = 0; i < length; i++) {
            char c = (char) (random.nextInt(26) + 'a'); // Caracter aleatorio en minúscula
            sb.append(c);
        }
        return sb.toString();
    }

    // Método para contar colisiones en la tabla hash
    private static <E> int contarColisiones(HashTable<E> hashTable) {
        int colisiones = 0;
        Iterator<LinkedList<E>> iterator = hashTable.tabla.iterator();
        while(iterator.hasNext()) {
            LinkedList<E> list = iterator.next();
            if (list.size() > 1) { // Si hay más de un elemento en la lista, hay una colisión
                colisiones += list.size() - 1;
            }
        }
        return colisiones;
    }
}
