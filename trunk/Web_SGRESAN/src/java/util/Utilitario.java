/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Monica
 */
public class Utilitario {
    
    public static final String PATTERN_LETRAS = "[^A-Za-zñÑáéíóúüÁÉÍÓÚ \\- ]";
    public static final String PATTERN_ALFA_NUMERICO = "[^A-Za-z0-9]";
    public static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String PATTERN_NUMEROS = ".*[^0-9].*";
    
    
    public static boolean validaNulo(String p){
        if(p == null || p.trim().length() == 0){
            return true;
        }
        return false;
    }
    
    public static boolean validaCantidad(String p, int cant){
        if(p == null || p.trim().length() != cant){
            return true;
        }
        return false;
    }
    
    public static void mensajeError(String p){
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, p, p));
    }
    
    public static boolean esSoloLetras(String texto) {
        Pattern pattern = Pattern.compile(PATTERN_LETRAS);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find() != true ? false : true;
    }

    public static boolean esAlfaNumerico(String texto) {
        Pattern pattern = Pattern.compile(PATTERN_ALFA_NUMERICO);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find() != true;
    }

    public static boolean esCorreoValido(String texto) {
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find();
    }

    public static boolean esSoloNumero(String texto) {
        Pattern pattern = Pattern.compile(PATTERN_NUMEROS);
        Matcher matcher = pattern.matcher(texto);
        return matcher.find() != true ? false : true;
    }
}
