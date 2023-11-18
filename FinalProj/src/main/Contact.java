/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Mustata Dumitru-Sebastian
 */
public class Contact implements Serializable{
    private String nume;
    private String prenume;
    private NrTel nrTel;
    private LocalDate ziNastere;
    public Contact(String n, String p, String bd, NrTel nt){
        nrTel=nt;
        if(valideazaNume(n)==false)
            throw new RuntimeException("Nume invalid");
        nume=n;
        if(valideazaNume(p)==false)
            throw new RuntimeException("Prenume invalid");
        prenume=p;
        ziNastere=LocalDate.parse(bd, DateTimeFormatter.ofPattern("d/M/yyyy"));
        if(!ziNastere.isBefore(LocalDate.now()))
            throw new RuntimeException("Data de nastere invalida");
    }
    
    private boolean valideazaNume(String n){
        if(n.length()<2)
            return false;
        return true;
    }
    
    public boolean equals(Contact c2){
        if(nume.equalsIgnoreCase(c2.getNume()) && prenume.equalsIgnoreCase(c2.getPrenume()) && 
                ziNastere.equals(c2.getZiNastere()) && nrTel.equals(c2.getNrTel()))
            return true;
        return false;
    }
    public String toString(){
        return nume+" "+prenume+", "+nrTel.toString()+", "+ziNastere.toString();
    }

    public String getNume() {
        return nume;
    }
    public void setNume(String nume) {
        this.nume = nume;
    }
    public String getPrenume() {
        return prenume;
    }
    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }
    public NrTel getNrTel() {
        return nrTel;
    }
    public void setNrTel(NrTel nrTel) {
        this.nrTel = nrTel;
    }
    public LocalDate getZiNastere() {
        return ziNastere;
    }
    public void setZiNastere(LocalDate ziNastere) {
        this.ziNastere = ziNastere;
    }
    
    
            
}
