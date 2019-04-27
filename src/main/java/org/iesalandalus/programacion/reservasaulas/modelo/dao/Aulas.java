/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo.dao;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;

/**
 *
 * @author Youness
 */
public class Aulas {
  private static final int MAX_AULAS=10;
  private int numAulas;
  private Aula coleccionAulas[];
  
  public Aulas(){
      this.numAulas = 0;
      coleccionAulas = new Aula[MAX_AULAS];
  }
  public Aulas(Aulas aulas1)throws IllegalArgumentException{
      if(aulas1==null){
          throw new IllegalArgumentException("No se pueden copiar aulas nulas.");
          
      }else {
          this.coleccionAulas=aulas1.coleccionAulas;
          this.numAulas=aulas1.numAulas;
      }
      
  }

    private void setAulas(Aulas aulas)throws IllegalArgumentException {
        if(aulas==null){
            throw new IllegalArgumentException("No se puede insertar un aula nula.");
        }
        this.coleccionAulas = coleccionAulas;
        this.numAulas=numAulas;
    }
  
  private Aula[] copiaProfundaAulas(Aula[] coleccionAulas) {
		Aula[] copiaProfunda = new Aula[MAX_AULAS];
		for(int i = 0; i<copiaProfunda.length && coleccionAulas[i]!=null; i++){
			copiaProfunda[i] = new Aula(coleccionAulas[i]);
                }
		return copiaProfunda;
	}
  
  public Aula[] getAulas(){
      
      
      return copiaProfundaAulas(this.coleccionAulas);
  }

    public int getNumAulas() {
        return numAulas;
    }
    
    private int buscarIndiceAula(Aula aula){
   
        
        int indice = -1;
       boolean existeAula=false;

        for (int i = 0; i < coleccionAulas.length && existeAula!=true; i++) {
            if(coleccionAulas[i]!=null){
             if (coleccionAulas[i].equals(aula)) {
                 indice= i;
                 existeAula=true;
                 
             } 
            }  else{
                 indice = i;
                 existeAula=true;
             }
            
            }

        
        return indice;
       
    }
    
    private boolean indiceNoSuperaTamano(int indice) {

        if (indice >= coleccionAulas.length) {
            return false;
        } else {
            return true;
        }
    }
    
    private boolean indiceNoSuperaCapacida(int indice){
        
        if(indice>=MAX_AULAS){
            return false;
        }else{
        return true;
        }
    }
    
    
    
    
  public void insertar(Aula aula)throws OperationNotSupportedException, IllegalArgumentException{
      if(aula==null){
            throw new IllegalArgumentException("No se puede insertar un aula nula.");
        }
      
      int indice=0;
          indice=buscarIndiceAula(aula);
      if(coleccionAulas[indice]!=null){
          throw new OperationNotSupportedException("El aula ya existe.");
      }
      
     if (indiceNoSuperaTamano(indice) == true && indiceNoSuperaCapacida(indice)==true) {
        
             if(coleccionAulas[indice]==null)
            coleccionAulas[indice] = aula;
            numAulas++;
           
         }
         else {
            throw new OperationNotSupportedException("Error. La reserva de aulas estan llenas.");
        }
      
      
  }
  
  public Aula buscar(Aula aula)throws OperationNotSupportedException{
      int indice=0;
     
          indice=buscarIndiceAula(aula);
      
      if(indice==-1){
          return null;
      }else{
      return coleccionAulas[indice];
      }
  }
  
  public void borrar(Aula aula)throws OperationNotSupportedException, IllegalArgumentException{
       if(aula==null){
            throw new IllegalArgumentException("No se puede borrar un aula nula.");
        }
      int indice=0;
      indice=buscarIndiceAula(aula);
      
      if(coleccionAulas[indice]==null){
          throw new OperationNotSupportedException("El aula a borrar no existe.");
      }else {
          coleccionAulas[indice]=null;
          desplazarUnaPosicionHaciaIzquierda(indice);
          numAulas--;
      }
  }
  
   private void desplazarUnaPosicionHaciaIzquierda(int indice) {

        for (int i = indice; i < coleccionAulas.length && coleccionAulas[i+1] != null; i++) {

            coleccionAulas[i] = coleccionAulas[i+1];
        }
            coleccionAulas[numAulas-1] = null;
        

    }
  
  public String[] representar(){
      String [] aulasRepresentadas= new String[numAulas];
      for(int i=0; i<aulasRepresentadas.length; i++){
          aulasRepresentadas[i]=coleccionAulas[i].toString();
      }
      
      return aulasRepresentadas;
  }
    
}
