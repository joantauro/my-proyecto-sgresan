/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Joel
 */
public class ValidacionUtil {
   public static final String PATTERN_LETRAS = "[^A-Za-z????????????? \\- ]";
    public static final String PATTERN_ALFA_NUMERICO = "[^A-Za-z0-9]";
    public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String PATTERN_NUMEROS = ".*[^0-9].*";

    public static boolean esNulo(String txt) {
        if (txt == null || txt.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean esRangoValido(String texto, int inicio, int fin) {
        if (esNulo(texto)) {
            return false;
        } else {
            if (texto.length() > fin || texto.length() < inicio) {
                return false;
            }
        }
        return true;
    }

    public static boolean esRangoValido(String texto, int fin) {
        return esRangoValido(texto, 0, fin);
    }

    public static boolean esSoloLetras(String texto) {
        Pattern pattern = Pattern.compile(PATTERN_LETRAS);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find() == true ? false : true;
    }

    public static boolean esAlfaNumerico(String texto) {
        Pattern pattern = Pattern.compile(PATTERN_ALFA_NUMERICO);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find() == true ? false : true;
    }

    public static boolean esCorreoValido(String texto) {
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find();
    }

    public static boolean esSoloNumero(String texto) {
        Pattern pattern = Pattern.compile(PATTERN_NUMEROS);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find() == true ? false : true;
    }


    public static boolean esFormatoFechaValido(String date, String formatoFecha) {
        SimpleDateFormat formato = new SimpleDateFormat(formatoFecha, Locale.getDefault());
        formato.setLenient(false);
        try {
            formato.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

 
    public static Timestamp getFechaActual() {
        return new Timestamp(new Date().getTime());
    }

    public static String getCadenaFechaActual(String formato) {
        Timestamp stamp = new Timestamp(new Date().getTime());
        DateFormat dateFormat = new SimpleDateFormat(formato);
        String fecha = dateFormat.format(stamp);
        return fecha;
    }

    public static boolean esFechaMayor(Date min, Date max) {

        return min.after(max) ? true : false;
    }

}
