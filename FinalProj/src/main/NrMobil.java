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
public class NrMobil extends NrTel implements Serializable{
    
    public NrMobil(String s){
        super(s);        
    }

    public boolean valideaza(String s) {
        if(s.length()!=10){
            return  false;
        }

        if(s.charAt(0)!='0' || s.charAt(1)!='7'){
            return false;      
        }
        return true;
    }
}
