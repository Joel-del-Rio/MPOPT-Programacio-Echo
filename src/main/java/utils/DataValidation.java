/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Francesc Perez 
 * @version 1.1.0
 */
public class DataValidation {

    public static boolean isNumber(char c) {
        return (48 <= c && c <= 57);
    }

    public static boolean isLetter(char c) {
        //The name can contain uppercase and lowercase letters, whitespace, 
        //hyphens and code control
//        return (97 <= c && c <= 122) || (65 <= c && c <= 90) || (c == 32) || (c == 45);
        return Character.isLetter(c) || c==32 || c==45;
    }

    public static String calculateNifLetter(String nifNoLetter) {
        String [] letter = {"T","R","W","A","G","M","Y","F","P","D","X","B",
            "N","J","Z","S","Q","V","H","L","C","K","E"};
        return nifNoLetter + letter[Integer.parseInt(nifNoLetter)%23];
    }

    private static final String PHONE_REGEX = "^\\+?[0-9]{1,4}?[-.\\s]?\\(?[0-9]{1,3}?\\)?[-.\\s]?[0-9]{1,4}[-.\\s]?[0-9]{1,4}[-.\\s]?[0-9]{1,9}$";
    private static final Pattern phonePattern = Pattern.compile(PHONE_REGEX);

    /**
     * Valida si una cadena de texto cumple con el formato de teléfono adecuado.
     * @param phoneNumber Cadena a validar
     * @return true si es válido, false en caso contrario
     */
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = phonePattern.matcher(phoneNumber);
        return matcher.matches();
    }
    
    
    private static final String POSTAL_CODE_REGEX = "^(\\d{5})(?:[-\\s]?\\d{4})?$";
    private static final Pattern postalCodePattern = Pattern.compile(POSTAL_CODE_REGEX);

    
    /**
     
     
     */
    public static boolean isValidPostalCode(String postalCode) {
        if (postalCode == null || postalCode.trim().isEmpty()) {
            return false;
        }
        Matcher matcher = postalCodePattern.matcher(postalCode);
        return matcher.matches();
    }
}
