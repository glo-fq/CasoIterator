/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casoiterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gloriana
 */
public abstract class Nodo implements IContainer<Nodo> {
    private int dato;
    protected HashMap<Integer,Nodo> punteros = new HashMap<>();
    
    public Nodo(int pDato){
        dato = pDato;
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
            //Agregar si es la raiz
            if(lista.isEmpty()){
                for (int i=1; i<=4;i++){
                    if(nodo.punteros.get(i)!= null){
                          //Agrega auxiliares antes y despues
                          lista.add(nodo.punteros.get(i));
                          //Agrega principal en el medio
                          if(i==2){
                              lista.add(nodo);
                          }
                    }
                }                
            }
            //Si ya no es el nodo principal de la raiz
            else{
                //Agrego primero el principal
                lista.add(nodo);
                //Agrego los siguientes 2 auxiliares si existen
                for(int i =3; i<=4;i++){
                    if(nodo.punteros.get(i)!= null){             
                        lista.add(nodo.punteros.get(i));
                    }
                }
                
            }
            //Obtiene el siguiente principal para iterar sobre el
            
            //Para el auxiliar superior derecho
           if(nodo.punteros.get(3)!=null){
               
                    Nodo n =nodo.punteros.get(3);
                    //Verifica que el principal existe
                    if (n.punteros.get(2)!=null){
                        addRecursivo(n.punteros.get(2));
                    }
           }
           //Para el auxiliar inferior derecho
           else if((nodo.punteros.get(4)!=null)){
                    Nodo n =nodo.punteros.get(4);
                    //Verifica que el principal existe
                    if(n.punteros.get(2)!=null){
                    addRecursivo(n.punteros.get(2));
                    }
           }
            
            
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
    
    @Override
    public String toString(){
        
        return "Nodo{" + " Dato= " + Integer.toString(dato) + "}";
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }


}
