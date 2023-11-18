/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;

/**
 *
 * @author Mustata Dumitru-Sebastian
 */
public abstract class NrTel implements Comparable, Serializable{
    protected String nrTel;
    
    public NrTel(String s){
        if(valideaza(s)==false){
            throw new RuntimeException("Numar de telefon invalid");
        }
        nrTel=s;
    }
    
    protected abstract boolean valideaza(String s);

    public String toString() {
        return nrTel;
    }
    public int compareTo(Object tel2){
        return  nrTel.compareTo(tel2.toString());
    }
    public boolean equals(NrTel tel2){
        return  nrTel.equals(tel2.toString());
    }
}
