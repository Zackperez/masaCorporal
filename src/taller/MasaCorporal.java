/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

/**
 *
 * @author Sony
 */
public class MasaCorporal {
    
    private double altura;
    private double peso;
    private int edad;
    private double IMC;
    private String estado;

    public MasaCorporal(double altura, double peso, int edad) {
        this.altura = altura;
        this.peso = peso;
        this.edad = edad;
    }
    
    public MasaCorporal (){
        
        
    }
    
    public String indiceMC(){
        if (edad>=0 && edad<=3) {
            if (calMasaC()<=14) {
             estado="Delgadez";   
            }else if (calMasaC()>14 && calMasaC()<=17.1) {
             estado="Normal";   
            }else if (calMasaC()>17.1 && calMasaC()<=18.1) {
             estado="Sobrepeso";   
            }else if (calMasaC()>18.1) {
             estado="Obeso";   
            }
   
        }else if (edad>3 && edad<=9) {
            if (calMasaC()<=13.8) {
             estado="Delgadez";   
            }else if (calMasaC()>13.8 && calMasaC()<=19) {
             estado="Normal";   
            }else if (calMasaC()>19 && calMasaC()<=21.7) {
             estado="Sobrepeso";   
            }else if (calMasaC()>21.7) {
             estado="Obeso";   
            }   
        }else if (edad>9 && edad<=12) {
          if (calMasaC()<=14.8) {
             estado="Delgadez";   
            }else if (calMasaC()>14.8 && calMasaC()<=21.7) {
             estado="Normal";   
            }else if (calMasaC()>21.7 && calMasaC()<=25.1) {
             estado="Sobrepeso";   
            }else if (calMasaC()>25.1) {
             estado="Obeso";   
            }  
        }else if (edad>12 && edad<=14) {
          if (calMasaC()<=15.8) {
             estado="Delgadez";   
            }else if (calMasaC()>15.8 && calMasaC()<=23.5) {
             estado="Normal";   
            }else if (calMasaC()>23.5 && calMasaC()<=27.1) {
             estado="Sobrepeso";   
            }else if (calMasaC()>27.1) {
             estado="Obeso";   
            }  
        }else if (edad>14 && edad<=16) {
          if (calMasaC()<=16.8) {
             estado="Delgadez";   
            }else if (calMasaC()>16.8 && calMasaC()<=24.5) {
             estado="Normal";   
            }else if (calMasaC()>24.5 && calMasaC()<=28.7) {
             estado="Sobrepeso";   
            }else if (calMasaC()>28.8) {
             estado="Obeso";   
            }  
        }else if (edad>16 && edad<=18){
           if (calMasaC()<=17.8) {
             estado="Delgadez";   
            }else if (calMasaC()>17.8 && calMasaC()<=25.5) {
             estado="Normal";   
            }else if (calMasaC()>25.5 && calMasaC()<=30.1) {
             estado="Sobrepeso";   
            }else if (calMasaC()>30.1) {
             estado="Obeso";   
            }
        }else if (edad>18) {
           if (calMasaC()<=18.4) {
             estado="Delgadez";   
            }else if (calMasaC()>18.4 && calMasaC()<25) {
             estado="Normal";   
            }else if (calMasaC()>=25 && calMasaC()<30) {
             estado="Sobrepeso";   
            }else if (calMasaC()>=30) {
             estado="Obeso";   
            }  
        }
        return estado;
    }

    public double calMasaC(){
    IMC=(double)Math.round(((peso/Math.pow(altura, 2))*10000) * 100d) / 100d;
    return IMC;
    }
    
    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }

    public int getEdad() {
        return edad;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }
    
    
    
}
