/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Sony
 */
public class Persona {
    
  public Persona(String name, String ape, int id, String fecha) {
        this.nombre = name;
        this.apellido = ape;
        this.identificacion = id;
        this.fecha_nacimiento = fecha;
    }
    
    public String nombre;
    public String apellido;
    public String fecha_nacimiento;
    public int identificacion;
    public String genero;
    public String direccion;
    public String email;
    public String telefono;
    public String celular;

    public Persona() {
    }

    public Persona(String nombre, String apellido, String fecha_nacimiento, int identificacion, String genero, String direccion, String email, String telefono, String celular) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.identificacion = identificacion;
        this.genero = genero;
        this.direccion = direccion;
        this.email = email;
        this.telefono = telefono;
        this.celular = celular;
    }
    
    public Persona (String name){
        this.nombre= name;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
        public int getEdad() {
     LocalDate hoy = LocalDate.now();
     DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     LocalDate fn = LocalDate.parse(this.fecha_nacimiento, fmt);
     Period periodo = Period.between(fn, hoy);
        return periodo.getYears();
    }
        
            public String getFullnombre() {      
      
        return this.nombre+" "+this.apellido;
    }
    
}
