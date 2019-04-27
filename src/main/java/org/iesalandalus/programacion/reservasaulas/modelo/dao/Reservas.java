/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/**
 *
 * @author Youness
 */
public class Reservas {
    private static final int MAX_RESERVAS=10;
  private int numReservas;
  private Reserva coleccionReservas[];
  
  public Reservas(){
      this.numReservas = 0;
      coleccionReservas = new Reserva[MAX_RESERVAS];
  }
  
  public Reservas(Reservas reservas1)throws IllegalArgumentException{
      if(reservas1==null){
          throw new IllegalArgumentException("No se pueden copiar reservas nulas.");
          
      }else {
          this.coleccionReservas=reservas1.coleccionReservas;
          this.numReservas=reservas1.numReservas;
      }
      
  }
  
  private void setReservas(Reservas reservas)throws IllegalArgumentException {
        if(reservas==null){
            throw new IllegalArgumentException("No se puede insertar una reserva nula.");
        }
        this.coleccionReservas = coleccionReservas;
        this.numReservas=numReservas;
    }
    
  private Reserva[] copiaProfundaReservas(Reserva[] coleccionReservas) {
		Reserva[] copiaProfunda = new Reserva[MAX_RESERVAS];
		for(int i = 0; i<copiaProfunda.length && coleccionReservas[i]!=null; i++){
			copiaProfunda[i] = new Reserva(coleccionReservas[i]);
                }
		return copiaProfunda;
	}
  
  public Reserva[] getReservas(){
      
      
      return copiaProfundaReservas(this.coleccionReservas);
  }

    public int getNumReservas() {
        return numReservas;
    }
  
  private int buscarIndiceReserva(Reserva reserva){
   
        
        int indice = -1;
       boolean existeReserva=false;

        for (int i = 0; i < coleccionReservas.length && existeReserva!=true; i++) {
            if(coleccionReservas[i]!=null){
             if (coleccionReservas[i].equals(reserva)) {
                 indice= i;
                 existeReserva=true;
                 
             } 
            }  else{
                 indice = i;
                 existeReserva=true;
             }
            
            }

        
        return indice;
       
    }
  
  private boolean indiceNoSuperaTamano(int indice) {

        if (indice >= coleccionReservas.length) {
            return false;
        } else {
            return true;
        }
    }
  
  private boolean indiceNoSuperaCapacida(int indice){
        
        if(indice>=MAX_RESERVAS){
            return false;
        }else{
        return true;
        }
    }
  
  public void insertar(Reserva reserva)throws OperationNotSupportedException, IllegalArgumentException{
      if(reserva==null){
            throw new IllegalArgumentException("No se puede realizar una reserva nula.");
        }
      
      int indice=0;
          indice=buscarIndiceReserva(reserva);
      if(coleccionReservas[indice]!=null){
          throw new OperationNotSupportedException("La reserva ya existe.");
      }
      
     if (indiceNoSuperaTamano(indice) == true && indiceNoSuperaCapacida(indice)==true) {
        
             if(coleccionReservas[indice]==null)
            coleccionReservas[indice] = reserva;
            numReservas++;
           
         }
         else {
            throw new OperationNotSupportedException("Error. La reserva de reservas estan llenas.");
        }
      
      
  }
  
  public Reserva buscar(Reserva reserva)throws OperationNotSupportedException{
      int indice=0;
     
          indice=buscarIndiceReserva(reserva);
      
      if(indice==-1){
          return null;
      }else{
      return coleccionReservas[indice];
      }
  }
  
  public void borrar(Reserva reserva)throws OperationNotSupportedException, IllegalArgumentException{
       if(reserva==null){
            throw new IllegalArgumentException("No se puede anular una reserva nula.");
        }
      int indice=0;
      indice=buscarIndiceReserva(reserva);
      
      if(coleccionReservas[indice]==null){
          throw new OperationNotSupportedException("La reserva a anular no existe.");
      }else {
          coleccionReservas[indice]=null;
          desplazarUnaPosicionHaciaIzquierda(indice);
          numReservas--;
      }
  }
  
  private void desplazarUnaPosicionHaciaIzquierda(int indice) {

        for (int i = indice; i < coleccionReservas.length && coleccionReservas[i+1] != null; i++) {

            coleccionReservas[i] = coleccionReservas[i+1];
        }
            coleccionReservas[numReservas-1] = null;
        

    }
  
  public String[] representar(){
      String [] reservasRepresentadas= new String[numReservas];
      for(int i=0; i<reservasRepresentadas.length; i++){
          reservasRepresentadas[i]=coleccionReservas[i].toString();
      }
      
      return reservasRepresentadas;
  }
  
  public Reserva[] getReservasProfesor(Profesor profesor)throws IllegalArgumentException{
      if(profesor==null){
          throw new IllegalArgumentException("No se puede tener reservas de un profesor nulo.");
      }
      
      Reserva[] reservasProfesor= new Reserva[MAX_RESERVAS];
      int contador=0;
      
      for(int i=0; i < numReservas ;i++){
          if(coleccionReservas[i].getProfesor().equals(profesor)){
              reservasProfesor[contador]=new Reserva(coleccionReservas[i]);
              contador++;
          }
      }
      
      return reservasProfesor;
  }
  
  public Reserva[] getReservasAula(Aula aula)throws IllegalArgumentException{
      if(aula==null){
          throw new IllegalArgumentException("No se puede tener reservas de un aula nulo.");
      }
      
      Reserva[] reservasAula= new Reserva[MAX_RESERVAS];
      int contador=0;
      
      for(int i=0; i < numReservas ;i++){
          if(coleccionReservas[i].getAula().equals(aula)){
              reservasAula[contador]=new Reserva(coleccionReservas[i]);
              contador++;
          }
      }
      
      return reservasAula;
  }
  
  public Reserva[] getReservasPermanencia(Permanencia permanencia)throws IllegalArgumentException{
      if(permanencia==null){
          throw new IllegalArgumentException("No se puede tener reservas de una permanencia nula.");
      }
      
      Reserva[] reservasPermanencia= new Reserva[MAX_RESERVAS];
      int contador=0;
      
      for(int i=0; i < numReservas ;i++){
          if(coleccionReservas[i].getPermanencia().equals(permanencia)){
              reservasPermanencia[contador]=new Reserva(coleccionReservas[i]);
              contador++;
          }
      }
      
      return reservasPermanencia;
  }
  
  public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia)throws IllegalArgumentException{
      if(aula==null){
          throw new IllegalArgumentException("No se puede consultar la disponibilidad de un aula nula.");
      }
      if(permanencia==null){
          throw new IllegalArgumentException("No se puede consultar la disponibilidad de una permanencia nula.");
      }
      
      for(int i=0; i< coleccionReservas.length && coleccionReservas[i]!=null; i++){
          if(coleccionReservas[i].getAula().equals(aula) && coleccionReservas[i].getPermanencia().equals(permanencia)){
              return false;
          }
      }
      
      
      return true;
  }
  
}
