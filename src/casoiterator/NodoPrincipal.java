/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casoiterator;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gloriana
 */
public class NodoPrincipal extends Nodo {
    
    public NodoPrincipal(int pDato){
        super(pDato);
        for(int i=1;i<=4;i++){
            punteros.put(i,null);
        }
        
        
    }
    
    public void agregarPuntero(NodoAuxiliar nodo, int direccion){
        punteros.replace(direccion, nodo);
        
        if(direccion == 1 || direccion == 2){
            nodo.agregarPuntero(this, 2);
        } else { //direccion 3 o 4
            nodo.agregarPuntero(this, 1);
        }
    }
}
