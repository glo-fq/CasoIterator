/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casoiterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gloriana
 */
public class Nodo implements IContainer<Nodo> {
    private int dato;
    private String tipo;
    private List<Nodo> punteros;
    
    public Nodo(int dato, String tipo, Nodo... punteros){
        this.dato = dato;
        this.tipo = tipo;
        this.punteros = Arrays.asList(punteros);
    }
    
    @Override
    public IIterator<Nodo> createIterator(){
        return new NodoIterator();
    }
    
    
    
    
    //Clase NodoIterator
    private class NodoIterator implements IIterator<Nodo>{
        //Aqui se recorre la estructura
        
        //Por que con linked list??
        private LinkedList<Nodo> lista = new LinkedList<>();
        //Esto de indice no se puede evitar usando ArrayList???
        private int indice = 0;
        
        public NodoIterator(){
            addRecursivo(Nodo.this);
        }
        
        public void addRecursivo(Nodo nodo){
            //Agregar todos los nodos
            //Lo hacemos recursivo o como?
        }
        
        @Override public boolean hasNext(){
            if(lista.isEmpty()){
                return false;
            }
            return indice < lista.size();
        }
        
        @Override public Nodo next(){
            if(!hasNext()){
                throw new RuntimeException("No hay más elementos.");
            }
            return lista.get(indice++);
        }
        
    }
    //Fin NodoIterator
    
    
    
    
    //Sets y gets
    
    public void setPunteros(List<Nodo> punteros){
        this.punteros = punteros;
    }
    
    public void addPuntero(Nodo puntero){
        if(puntero == null){ //No se por que aqui pregunta por el puntero y no por la lista 
            punteros = new ArrayList<>();
        }
        punteros.add(puntero);
    }
    
    @Override
    public String toString(){
        return "Nodo{" + " Dato= " + Integer.toString(dato) + ", Tipo= " + tipo + "}";
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public List<Nodo> getPunteros(){
        return punteros;
    }
    
}
