package taller;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class Validaciones {

    String nombre;
    String apellido;
    String id;
    String fecha;
    Persona p = new Persona();

    public boolean validateDate(String fecha) {

        try {

            fecha = fecha;

            while (fecha.contains("[A-Za-z ]*$")) {
                JOptionPane.showMessageDialog(null, "Fecha incorrecta");
                fecha = "";
                fecha = JOptionPane.showInputDialog(null, "Digite una fecha valida");
            }

            try {
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
                formatoFecha.setLenient(false);
                formatoFecha.parse(fecha);
            } catch (ParseException e) {
                return false;
            }
        } catch (Exception e) {
        }
        return true;
    }

    public String getDate() {

        try {
            boolean res = true;
            res = this.validateDate(fecha);

            if (res == true) {
                //System.out.println("fecha valida");
            } else {
                JOptionPane.showMessageDialog(null, "Fecha incorrecta", ""
                        + "Zack's Hospital", JOptionPane.WARNING_MESSAGE);
                fecha = "";
                fecha = JOptionPane.showInputDialog(null, "La fecha tiene que ser en formato dd/MM/yyyy",
                        "HOSPITAL GENERAL", JOptionPane.DEFAULT_OPTION);
            }
        } catch (HeadlessException e) {
        }
        return String.valueOf(fecha);
    }

    public void NamePerson(String persona) {
        try {
            nombre = persona;

            while (nombre.matches("") || !nombre.matches("[A-Za-z]*$")) {
                nombre = JOptionPane.showInputDialog(null, "Tienes que ingresar un nombre");
            }
        } catch (Exception e) {

        }
    }

    public String getNamePerson() {
        return nombre;
    }

    public void LastName(String personaa) {
        try {
            apellido = personaa;

            while (apellido.matches("") || !apellido.matches("[A-Za-z]*$")) {
                apellido = JOptionPane.showInputDialog(null, "Tienes que ingresar un apellido");
            }
        } catch (Exception e) {

        }
    }

    public String getLastName() {
        return apellido;
    }

    public int personRegistered(String ide) {
        try {

            id = ide;

            while (id.matches("") || !id.matches("[0-9]{10}")) {

                id = JOptionPane.showInputDialog(null, "La identificación (ID) tiene que contener 10 números, Intentalo de nuevo");

            }
        } catch (Exception e) {

        }
        return Integer.parseInt(id);
    }

    public int getIdentificacion() {
        return Integer.parseInt(id);
    }

}
