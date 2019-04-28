/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.reservasaulas.modelo;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Aulas;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Profesores;
import org.iesalandalus.programacion.reservasaulas.modelo.dao.Reservas;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Aula;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Permanencia;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Profesor;
import org.iesalandalus.programacion.reservasaulas.modelo.dominio.Reserva;

/**
 *
 * @author Youness
 */
public class ModeloReservasAulas {
   private Profesores profesores;
   private Aulas aulas;
   private Reservas reservas;
    
    public ModeloReservasAulas(){
        this.profesores= new Profesores();
        this.aulas=new Aulas();
        this.reservas= new Reservas();
    }
    
    
   public Aula[] getAulas(){
       
       return aulas.getAulas();
   }
   
   public int getNumAulas(){
       return aulas.getNumAulas();
   }
   
   public String[] representarAulas(){
       return aulas.representar();
   }
    
   public Aula buscarAula(Aula aula) throws OperationNotSupportedException{
       return aulas.buscar(aula);
   }
   
   public void insertarAula(Aula aula) throws OperationNotSupportedException, IllegalArgumentException{
       aulas.insertar(aula);
   }
   
   public void borrarAula(Aula aula) throws OperationNotSupportedException, IllegalArgumentException{
       aulas.borrar(aula);
   }
   
   public Profesor[] getProfesores(){
       return profesores.getProfesores();
   }
   
   public int getNumProfesores(){
       return profesores.getNumProfesores();
   }
   
   public String[] representarProfesores(){
       return profesores.representar();
   }
   
   public Profesor buscarProfesor(Profesor profesor) throws OperationNotSupportedException{
       return profesores.buscar(profesor);
   }
   
   public void insertarProfesor(Profesor profesor) throws OperationNotSupportedException, IllegalArgumentException{
       profesores.insertar(profesor);
   }
   
   public void borrarProfesor(Profesor profesor) throws OperationNotSupportedException, IllegalArgumentException{
       profesores.borrar(profesor);
   }
   
   public Reserva[] getReservas(){
       return reservas.getReservas();
   }
   
   public int getNumReservas(){
       return reservas.getNumReservas();
   }
   
   public String[] representarReserva(){
       return reservas.representar();
   }
   
   public Reserva buscarReserva(Reserva reserva) throws OperationNotSupportedException{
       return reservas.buscar(reserva);
   }
   
   public void realizarReserva(Reserva reserva) throws OperationNotSupportedException, IllegalArgumentException{
       reservas.insertar(reserva);
   }
   
   public void anularReserva(Reserva reserva) throws OperationNotSupportedException, IllegalArgumentException{
       reservas.borrar(reserva);
   }
   
   public Reserva[] getReservasAula(Aula aula)throws IllegalArgumentException{
       return reservas.getReservasAula(aula);
   }
   
   public Reserva[] getReservasProfesor(Profesor profesor)throws IllegalArgumentException{
       return reservas.getReservasProfesor(profesor);
   }
   
   public Reserva[] getReservasPermanencia(Permanencia permanencia)throws IllegalArgumentException{
       return reservas.getReservasPermanencia(permanencia);
   }
   
   public boolean consultarDisponibilidad(Aula aula, Permanencia permanencia)throws IllegalArgumentException{
       return reservas.consultarDisponibilidad(aula, permanencia);
   }
}
