/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;

/**
 *
 * @author Youness
 */
public class Profesores {
    private static final int MAX_PROFESORES=10;
  private int numProfesores;
  private Profesor coleccionProfesores[];
    
  public Profesores(){
      this.numProfesores = 0;
      coleccionProfesores = new Profesor[MAX_PROFESORES];
  }
  public Profesores(Profesores profesores1)throws IllegalArgumentException{
      if(profesores1==null){
          throw new IllegalArgumentException("No se pueden copiar profesores nulos.");
          
      }else {
          this.coleccionProfesores=profesores1.coleccionProfesores;
          this.numProfesores=profesores1.numProfesores;
      }
      
  }
  
  private void setAProfesores(Profesores profesores)throws IllegalArgumentException {
        if(profesores==null){
            throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
        }
        this.coleccionProfesores = coleccionProfesores;
        this.numProfesores=numProfesores;
    }
  
  private Profesor[] copiaProfundaProfesores(Profesor[] coleccionProfesores) {
		Profesor[] copiaProfunda = new Profesor[MAX_PROFESORES];
		for(int i = 0; i<copiaProfunda.length && coleccionProfesores[i]!=null; i++){
			copiaProfunda[i] = new Profesor(coleccionProfesores[i]);
                }
		return copiaProfunda;
	}
  
  public Profesor[] getProfesores(){
      
      
      return copiaProfundaProfesores(this.coleccionProfesores);
  }

    public int getNumProfesores() {
        return numProfesores;
    }
  
  private int buscarIndiceProfesor(Profesor profesor){
   
        
        int indice = -1;
       boolean existeProfesor=false;

        for (int i = 0; i < coleccionProfesores.length && existeProfesor!=true; i++) {
            if(coleccionProfesores[i]!=null){
             if (coleccionProfesores[i].equals(profesor)) {
                 indice= i;
                 existeProfesor=true;
                 
             } 
            }  else{
                 indice = i;
                 existeProfesor=true;
             }
            
            }

        
        return indice;
       
    }
  
   private boolean indiceNoSuperaTamano(int indice) {

        if (indice >= coleccionProfesores.length) {
            return false;
        } else {
            return true;
        }
    }
    
    private boolean indiceNoSuperaCapacida(int indice){
        
        if(indice>=MAX_PROFESORES){
            return false;
        }else{
        return true;
        }
    }
    
    public void insertar(Profesor profesor)throws OperationNotSupportedException, IllegalArgumentException{
      if(profesor==null){
            throw new IllegalArgumentException("No se puede insertar un profesor nulo.");
        }
      
      int indice=0;
          indice=buscarIndiceProfesor(profesor);
      if(coleccionProfesores[indice]!=null){
          throw new OperationNotSupportedException("El profesor ya existe.");
      }
      
     if (indiceNoSuperaTamano(indice) == true && indiceNoSuperaCapacida(indice)==true) {
        
             if(coleccionProfesores[indice]==null)
            coleccionProfesores[indice] = profesor;
            numProfesores++;
           
         }
         else {
            throw new OperationNotSupportedException("Error. La reserva de profesores estan llenas.");
        }
      
      
  }
    
     public Profesor buscar(Profesor profesor)throws OperationNotSupportedException{
      int indice=0;
     
          indice=buscarIndiceProfesor(profesor);
      
      if(indice==-1){
          return null;
      }else{
      return coleccionProfesores[indice];
      }
  }
     
     public void borrar(Profesor profesor)throws OperationNotSupportedException, IllegalArgumentException{
       if(profesor==null){
            throw new IllegalArgumentException("No se puede borrar un profesor nulo.");
        }
      int indice=0;
      indice=buscarIndiceProfesor(profesor);
      
      if(coleccionProfesores[indice]==null){
          throw new OperationNotSupportedException("El profesor a borrar no existe.");
      }else {
          coleccionProfesores[indice]=null;
          desplazarUnaPosicionHaciaIzquierda(indice);
          numProfesores--;
      }
  }
     
     private void desplazarUnaPosicionHaciaIzquierda(int indice) {

        for (int i = indice; i < coleccionProfesores.length && coleccionProfesores[i+1] != null; i++) {

            coleccionProfesores[i] = coleccionProfesores[i+1];
        }
            coleccionProfesores[numProfesores-1] = null;
        

    }
     
      public String[] representar(){
      String [] profesoresRepresentados= new String[numProfesores];
      for(int i=0; i<profesoresRepresentados.length; i++){
          profesoresRepresentados[i]=coleccionProfesores[i].toString();
      }
      
      return profesoresRepresentados;
  }
  
}
