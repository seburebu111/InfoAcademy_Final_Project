/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author Mustata Dumitru-Sebastian
 */
public class Agenda implements Serializable{
    private List<Contact> lista = new ArrayList<Contact>();
    
    private transient Predicate<Contact> filtru;
    private CriteriuOrdonare criteriuOrdonare;
    
    public void filtrareNrFix(){
        filtru = c -> c.getNrTel() instanceof NrFix;
    }
    public void filtrareNrMobil(){
        filtru = c -> c.getNrTel() instanceof NrMobil;
    }
    public void filtrareNascutiLunaCurenta(){
        filtru = c -> c.getZiNastere().getMonthValue() == LocalDate.now().getMonthValue();
    }
    public void filtrareNascutiZiuaCurenta(){
        filtru = c -> c.getZiNastere().getMonthValue() == LocalDate.now().getMonthValue() && c.getZiNastere().getDayOfMonth() == LocalDate.now().getDayOfMonth();
    }
    public void filtrarePersonalizata(String s){
        filtru = c -> c.toString().toLowerCase().contains(s.toLowerCase());
    }
    public void faraFiltru(){
        filtru = c -> true;
    }
    public void ordoneaza(CriteriuOrdonare co){
        criteriuOrdonare = co;
    }
    public void adauga(Contact newc){
        for(Contact c:lista){
            if(c.equals(newc))
                throw new RuntimeException("Acest contact este deja existent:\n"+newc.toString());
        }
        lista.add(newc);
    }
    public void adaugaMaiMulti(Agenda newa){
        newa.faraFiltru();
        for(Contact c : newa.contacte()){
            adauga(c);
        }
    }
    public void sterge(Contact c){
        lista.remove(c);
    }
    public void modifica(Contact oldc, Contact newc){
        sterge(oldc);
        adauga(newc);
    }
    
    public List<Contact> contacte(){
        return lista.stream()
                .filter(filtru)
                .sorted(criteriuOrdonare.getComparator())
                .collect(Collectors.toList());
    }
}
