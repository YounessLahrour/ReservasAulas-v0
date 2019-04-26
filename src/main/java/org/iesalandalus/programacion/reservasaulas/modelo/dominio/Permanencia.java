/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 *
 * @author Youness
 */
public class Permanencia {
    private LocalDate dia;
    private static final DateTimeFormatter FORMATO_DIA=DateTimeFormatter.ofPattern("dd/MM/uuuu");
    Tramo tramo;
    
    public Permanencia(LocalDate dia, Tramo tramo){
        setDia(dia);
        setTramo(tramo);
       
    }
    
    public Permanencia(Permanencia Permanencia1)throws IllegalArgumentException{
       if(Permanencia1==null){
           throw new IllegalArgumentException("No se puede copiar una permanencia nula.");
       } else {
           this.dia=Permanencia1.dia;
           this.tramo=Permanencia1.tramo;
       }
        
    }

    public LocalDate getDia() {
        return dia;
    }

    private void setDia(LocalDate dia)throws IllegalArgumentException {
       
        if(dia==null){
            throw new IllegalArgumentException("El día de una permanencia no puede ser nulo.");
        } else{
            this.dia = dia;
        }
        
            
            
        
        
    }

    public Tramo getTramo() {
        return tramo;
    }

    public void setTramo(Tramo tramo)throws IllegalArgumentException {
        
        if(tramo== null ){
            throw new IllegalArgumentException("El tramo de una permanencia no puede ser nulo.");
       
        } else 
            this.tramo = tramo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.dia);
        hash = 79 * hash + Objects.hashCode(this.tramo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Permanencia other = (Permanencia) obj;
        if (!Objects.equals(this.dia, other.dia)) {
            return false;
        }
        if (this.tramo != other.tramo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
         String diaParseado=dia.format(FORMATO_DIA);
         String tipoTramo="";
         if(getTramo()==Tramo.MANANA){
             tipoTramo="Mañana";
         }else {
             tipoTramo="Tarde";
         }
        
        
        return "[dia=" + diaParseado + ", tramo=" + tipoTramo + "]";
    }
    
    
    
}
