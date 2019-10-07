/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casoiterator;

/**
 *
 * @author Gloriana
 */
public class CasoIterator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        NodoAuxiliar aux1 = new NodoAuxiliar(1);
        NodoAuxiliar aux2 = new NodoAuxiliar(2);
        NodoAuxiliar aux4 = new NodoAuxiliar(4);
        NodoAuxiliar aux5 = new NodoAuxiliar(5);
        NodoAuxiliar aux7 = new NodoAuxiliar(7);
        NodoAuxiliar aux10 = new NodoAuxiliar(10);
        
        NodoPrincipal principal3 = new NodoPrincipal(3);
        NodoPrincipal principal6 = new NodoPrincipal(6);
        NodoPrincipal principal9 = new NodoPrincipal(9);
        
        principal3.agregarPuntero(aux1, 1);
        principal3.agregarPuntero(aux2, 2);
        principal3.agregarPuntero(aux4, 3);
        principal3.agregarPuntero(aux5, 4);
        
        principal6.agregarPuntero(aux4, 1);
        principal6.agregarPuntero(aux5, 2);
        principal6.agregarPuntero(aux7, 3);
        
        principal9.agregarPuntero(aux7, 1);
        principal9.agregarPuntero(aux10, 4);
        
        IIterator<Nodo> nodoIterator = principal3.createIterator();
        
        while(nodoIterator.hasNext()){
            Nodo nodo = nodoIterator.next();
            System.out.println("nodo> " + nodo.toString());
        }
        
        
    }
    
}
