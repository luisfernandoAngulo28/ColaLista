/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDeNegocio;

/**
 *
 * @author Fernando
 */
public class Cola_Lista {

    private Nodo frente;
    private Nodo atras;
    private int cantidad;

    public Cola_Lista() {
        this.frente = null;
        this.atras = null;
        this.cantidad = 0;
    }

    public boolean vacia() {
        return frente == null;
    }

    public int cantidad() {
        return cantidad;
    }

    public void encolar(int elemento) {
        Nodo nuevoNodo = new Nodo(elemento);
        if (vacia()) {
            frente = nuevoNodo;
            atras = nuevoNodo;
        } else {
            atras.setEnlace(nuevoNodo);
            atras = nuevoNodo;
        }
        cantidad++;
    }

    public int decolar() {
        if (vacia()) {

            System.out.println("La cola está vacía");
        }
        int elemento = frente.getDato();
        if (frente == atras) {
            frente = null;
            atras = null;
        } else {
            frente = frente.getEnlace();
        }
        cantidad--;
        return elemento;
    }

    public int get() {
        if (vacia()) {
            System.out.println("La cola está vacía");
        }
        return frente.getDato();
    }

    public void intercambiar(Cola_Lista Q1, Cola_Lista Q2) {
        int cantidadQ1=Q1.cantidad();//5
        int cantidadQ2=Q2.cantidad();//6
        for (int i = 0; i < cantidadQ1; i++) {//5
            Q2.encolar(Q1.decolar());
        }
        for (int i = 0; i < cantidadQ2; i++) {//6
            Q1.encolar(Q2.decolar());
        }
    }

    
    public void intercambiarmitad(Cola_Lista Q1, Cola_Lista Q2) {
        int mitadQ1=Q1.cantidad()/2;//3
        int mitadQ2=Q2.cantidad()/2;//3
        for(int i=0;i<mitadQ1;i++ ){//3
            Q2.encolar(Q1.decolar());
        }
        for(int i=0;i<mitadQ2;i++ ){//3
            Q1.encolar(Q2.decolar());
        }
        for(int i=0;i<mitadQ2;i++ ){//3
            Q1.encolar(Q1.decolar());
            Q2.encolar(Q2.decolar());
        }



    }
    
    @Override
    public String toString() {
        Nodo nodoAux = frente;
        String s = "[";
        while (nodoAux != null) {
            s = s + nodoAux.getDato() + "|";
            nodoAux = nodoAux.getEnlace();
        }
        s = s.substring(0, s.length() - 1) + "]";
        return s;
    }

    public static void main(String[] args) {
       /* Cola_Lista Q1 = new Cola_Lista();
        Cola_Lista Q2 = new Cola_Lista();

        for (int i = 1; i < 6; i++) {
            Q1.encolar(i);
        }

        for (int i = 6; i < 12; i++) {
            Q2.encolar(i);
        }

        System.out.println("Q1: " + Q1);
        System.out.println("Q2: " + Q2);
        Q1.intercambiar(Q1, Q2);
        System.out.println("Q1: " + Q1);
        System.out.println("Q2: " + Q2);
        */ 
        Cola_Lista q1 = new Cola_Lista();
        Cola_Lista q2 = new Cola_Lista();

        for (int i = 1; i <= 6; i++) {
            q1.encolar(i);
        }

        for (int i = 7; i <= 12; i++) {
            q2.encolar(i);
        }

        System.out.println("Q1 " + q1);
        System.out.println("Q2  " + q2);

        q1.intercambiarmitad(q1,q2);

        System.out.println("Q1  " + q1);
        System.out.println("Q2 " + q2);
    }

}
