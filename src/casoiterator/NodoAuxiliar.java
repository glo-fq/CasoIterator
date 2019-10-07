/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casoiterator;

import java.util.List;

/**
 *
 * @author Gloriana
 */
public class NodoAuxiliar extends Nodo {
    
    public NodoAuxiliar(int pDato){
        
        super(pDato);
        for(int i=1;i<=2;i++){
            punteros.put(i,null);
        }
    }
    public void agregarPuntero(NodoPrincipal nodo, int direccion){
        punteros.replace(direccion, nodo);
    }
}
