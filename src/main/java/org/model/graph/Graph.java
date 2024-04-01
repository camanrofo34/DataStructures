/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.model.graph;

import org.model.ArrayList.ArrayList;
import org.model.array.Array;
import org.model.priorityQueue.list.PriorityQueue;
import org.model.util.iterator.Iterator;

/**
 *
 * @author PC 4060TI
 */
public class Graph {

    private int vertices;
    private ArrayList<ArrayList<Arista>> listaAdyacencia;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            listaAdyacencia.add(new ArrayList<Arista>());
        }
    }

    public void agregarAristaDirigida(int origen, int destino, int peso) {
        listaAdyacencia.get(origen).add(new Arista(destino, peso));
    }

    public void agregarAristaNoDirigida(int origen, int destino, int peso) {
        agregarAristaDirigida(origen, destino, peso);
        agregarAristaDirigida(destino, origen, peso);
    }

    private int comparar(Arista a, Arista b) {
        return a.getPeso() - b.getPeso();
    }

    public Array<Integer> dijkstra(int src) {
        Array<Integer> distancia = new Array<>(vertices); // la distancia más corta de cada vértice desde src
        Array<Boolean> visitado = new Array<>(vertices); // el vértice es visitado o no

        while (distancia.size() != vertices) {
            distancia.add(Integer.MAX_VALUE);
        }
        while (visitado.size() != vertices) {
            visitado.add(false);
        }
        PriorityQueue<Arista> pq = new PriorityQueue<>(500);
        pq.insert(new Arista(src, 0));
        distancia.set(src, 0);
        while (!pq.isEmpty()) {
            Arista x = pq.extract(); // Extraer el vértice con la distancia más corta desde src
            int u = x.getDestino();
            visitado.set(u, true);
            Iterator<Arista> iter = listaAdyacencia.get(u).iterator();
            // Iterar sobre los vecinos de u y actualizar sus distancias
            while (iter.hasNext()) {
                Arista y = iter.next();
                int v = y.getDestino();
                int peso = y.getPeso();
                // Comprobar si el vértice v no es visitado
                // Si el nuevo camino a través de u ofrece menos costo, entonces actualizar el arreglo de distancia y agregarlo a cp
                if (!visitado.get(v) && distancia.get(u) + peso < distancia.get(v)) {
                    distancia.set(v, distancia.get(u) + peso);
                    pq.insert(new Arista(v, distancia.get(v)));
                }
            }
        }
        return distancia;
    }
    
    public static void main(String[] args) {
        Graph grafo = new Graph(11);
        grafo.agregarAristaNoDirigida(0, 1, 30);
        grafo.agregarAristaNoDirigida(0, 2, 40);
        grafo.agregarAristaNoDirigida(0, 3, 50);
        grafo.agregarAristaNoDirigida(0, 5, 50);
        grafo.agregarAristaNoDirigida(2, 8, 80);
        grafo.agregarAristaNoDirigida(2, 9, 120);
        grafo.agregarAristaNoDirigida(2, 10, 110);
        grafo.agregarAristaNoDirigida(3, 4, 20);
        grafo.agregarAristaNoDirigida(4, 5, 65);
        grafo.agregarAristaNoDirigida(5, 6, 80);
        grafo.agregarAristaNoDirigida(6, 7, 30);
        grafo.agregarAristaNoDirigida(6, 8, 145);
        
        Iterator<Integer> iterator = grafo.dijkstra(0).iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
