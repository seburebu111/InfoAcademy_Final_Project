/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author Mustata Dumitru-Sebastian
 */
public enum CriteriuOrdonare implements Serializable{
    DUPA_NUME(new Comparator<Contact>(){
        public int compare(Contact c1, Contact c2){
            return c1.getNume().compareToIgnoreCase(c2.getNume());
        }
    }),
    DUPA_PRENUME(new Comparator<Contact>(){
        public int compare(Contact c1, Contact c2){
            return c1.getPrenume().compareToIgnoreCase(c2.getPrenume());
        }
    }),
    DUPA_NUMAR_TELEFON(new Comparator<Contact>(){
        public int compare(Contact c1, Contact c2){
            return c1.getNrTel().compareTo(c2.getNrTel());
        }
    }),
    DUPA_ZI_DE_NASTERE(new Comparator<Contact>(){
        public int compare(Contact c1, Contact c2){
            return c1.getZiNastere().compareTo(c2.getZiNastere());
        }
    });    
    Comparator<Contact> c;
    
    CriteriuOrdonare(Comparator<Contact> c){
        this.c = c;
    }
    public Comparator<Contact> getComparator(){
        return c;
    }
}
