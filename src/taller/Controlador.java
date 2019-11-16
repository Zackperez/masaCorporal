/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller;

import java.awt.HeadlessException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Sony
 */
public class Controlador {

    ArrayList<Persona> classroom = new ArrayList();
    ArrayList<MasaCorporal> historialMC = new ArrayList();
    MasaCorporal masa = new MasaCorporal();
    Persona p = new Persona();
    Validaciones vali = new Validaciones();

    public Controlador() {

        this.loadMenu();
    }

    private void loadMenu() {

        try {
            int opc = Integer.parseInt(JOptionPane.showInputDialog("-------\n"
                    + "Elije una opcion\n"
                    + "1.- Añadir personas\n"
                    + "2. Mostrar datos de persona\n"
                    + "3. Borrar persona" + "\n"
                    + "4. Calcular Masa Corporal" + "\n"
                    + "5. Salir del programa"));

            this.optionSelected(opc);
        } catch (NumberFormatException e) {
        }
    }

    private void optionSelected(int opc) {

        try {
            switch (opc) {

                case 1:
                    addPerson();
                    break;

                case 2:
                    MostrarPersona();
                    break;

                case 3:
                    this.removePerson(Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de Identificación")));
                    break;

                case 4:

                    menuCalcularMC();

                    break;

                case 5:

                    System.exit(0);

                    break;

//                default:
//
//                    JOptionPane.showMessageDialog(null, "Elige una de las opciones que aparecen en pantalla");
//                    this.loadMenu();
            }
        } catch (NumberFormatException e) {

        }
    }

    private void addPerson() {

        int opc;
        do {
            vali.NamePerson(JOptionPane.showInputDialog("Ingrese su nombre"));
            vali.LastName(JOptionPane.showInputDialog("Ingrese su Apellido"));
            vali.personRegistered(JOptionPane.showInputDialog("Ingrese su numero de identificacion (10)"));
            vali.validateDate(JOptionPane.showInputDialog("Ingrese su fecha de nacimiento"));
            classroom.add(new Persona(vali.getNamePerson(), vali.getLastName(), vali.getIdentificacion(), vali.getDate()));

            opc = (JOptionPane.showConfirmDialog(null, "¿Desea registrar mas?", "Zack'sHospital", JOptionPane.YES_NO_OPTION));
        } while (opc == 0);
        this.loadMenu();

    }

    private void MostrarPersona() {

        try {
            if (classroom.isEmpty()) {

                JOptionPane.showMessageDialog(null, "No hay usuarios registrados");
            } else {

                // SIMPLE DETALLE, SI HAY MENOS DE 2 PERSONAS, SE MOSTRARÁ EL MENSAJE EN SINGULAR
                // SI HAY MAS DE 1 PERSONA, SE MOSTRARÁ EL MENSAJE EN PLURAL
                if (classroom.size() < 2) {
                    JOptionPane.showMessageDialog(null, "Hay " + classroom.size() + " persona registrada, se mostrará la informacion detallada");
                } else {
                    JOptionPane.showMessageDialog(null, "Hay " + classroom.size() + " personas registradas, se mostrará la informacion detallada");
                }

                for (int i = 0; i < classroom.size(); i++) {

                    JOptionPane.showMessageDialog(null, "Nombre: " + classroom.get(i).getNombre() + "\n"
                            + "Apellido: " + classroom.get(i).getApellido() + "\n"
                            + "Identificacion: " + classroom.get(i).getIdentificacion() + "\n"
                            + "Fecha de nacimiento: " + classroom.get(i).getFecha_nacimiento());

                }
            }
            this.loadMenu();

        } catch (Exception e) {

            this.loadMenu();
        }
    }

    private void removePerson(int persona) {

        persona = vali.personRegistered(String.valueOf(persona));

        if (classroom.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No hay persona para borrar");

        }

        for (int i = 0; i < classroom.size(); i++) {

            if (persona == classroom.get(i).getIdentificacion()) {

                int opc = Integer.parseInt(JOptionPane.showInputDialog("Se borraran todos los datos almacenados de " + classroom.get(i).getNombre() + ", estas seguro?" + "\n"
                        + "1. PARA BORRAR " + "\n"
                        + "2. PARA CANCELAR"));

                if (opc == 1) {
                    classroom.remove(i);
                    JOptionPane.showMessageDialog(null, "Se ha borrado satisfactoriamente");
                } else if (opc == 2) {
                    JOptionPane.showMessageDialog(null, "No se borró ningun dato");
                }
            }

        }
        this.loadMenu();

    }

    private void menuCalcularMC() {

        int opc = 0;
        int persona;
        try {
            opc = Integer.parseInt(JOptionPane.showInputDialog("-------\n"
                    + "Elije una opcion\n"
                    + "1.- Calcular IMC\n"
                    + "2. Mostrar datos de persona\n"
                    + "3. Regresar al menú principal"));

        } catch (NumberFormatException e) {
        } // FINAL TRY CATCH

        switch (opc) {

            case 1:

                this.calcularMC(persona = Integer.parseInt(JOptionPane.showInputDialog("Ingresa numero de identificación")));

                break;

            case 2:
                
                showMC(Integer.parseInt(JOptionPane.showInputDialog("Ingrese nmero de cedula")));

                break;

            case 3:

                this.loadMenu();

                break;

        }

    } //TERMINA METODO

    private void showMC(int persona) {

        int opc = 0;

        persona = vali.personRegistered(String.valueOf(persona));

        if (classroom.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No hay persona(s) registradas");

        } else {

            for (int i = 0; i < classroom.size(); i++) {

                if (persona == classroom.get(i).getIdentificacion()) {

                    JOptionPane.showMessageDialog(null, "Datos: "+"\n"
                            + "Nombre: " + classroom.get(i).getNombre() +"\n"
                            +" Cedula Ciudadana=  " + classroom.get(i).getIdentificacion()+"\n"
                            + " Masa Corporal : "+masa.calMasaC()+"\n"
                            + "Indice de Masa Corporal: "+masa.indiceMC());
                }
            }

        }
        this.menuCalcularMC();
    }
    

    private void calcularMC(int persona) {

        int opc = 0;

        persona = vali.personRegistered(String.valueOf(persona));

        if (classroom.isEmpty()) {

            JOptionPane.showMessageDialog(null, "No hay persona(s) registradas");

        } else {

            for (int i = 0; i < classroom.size(); i++) {

                if (persona == classroom.get(i).getIdentificacion()) {

                    JOptionPane.showMessageDialog(null, "Datos:  Nombre: " + classroom.get(i).getNombre() + " Cedula Ciudadana=  " + classroom.get(i).getIdentificacion());
                }
            }

            masa.setAltura(Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu altura en centímetros")));
            masa.setPeso(Integer.parseInt(JOptionPane.showInputDialog("Ingresa tu peso")));
            masa.setEdad(Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos años tienes?")));

            historialMC.add(new MasaCorporal(masa.getAltura(), masa.getPeso(), masa.getEdad()));

            masa.calMasaC();

        }
        this.menuCalcularMC();
    }
}
