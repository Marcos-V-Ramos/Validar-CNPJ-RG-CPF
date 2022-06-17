package com.marcosvr.validadordados;

/**
 *
 * @author VINICIUS
 */
public class Validador {
    
    public static boolean validarCPF(String CPF) {
        String cpfFormatado = CPF.replace(".", "").replace("-", "");
        int noveDigitosMultiplicados = 0;
        int dozeDigitosMultiplicados = 0;
        
        int contadorNoveDigitos = 10;
        int contadorDezDigitos = 11;
        
        int restoNoveDigitos = 0;
        int restoDezDigitos = 0;
        
        boolean ehValidoPrimeiroDigito = false;
        boolean ehValidoSegundoDigito = false;
        
        // VALIDAR PRIMEIRO DIGITO.
        for (int i = 0; i < cpfFormatado.length() - 2; i++) {
            noveDigitosMultiplicados += Character.getNumericValue(cpfFormatado.charAt(i)) * contadorNoveDigitos;
            contadorNoveDigitos--;
        }
        
        restoNoveDigitos = (noveDigitosMultiplicados * 10) % 11;
        if (restoNoveDigitos == 10) {
            ehValidoPrimeiroDigito = Character.getNumericValue(cpfFormatado.charAt(9)) == 0;
        } else {
            ehValidoPrimeiroDigito = Character.getNumericValue(cpfFormatado.charAt(9)) == restoNoveDigitos; 
        }
        
        // VALIDAR SEGUNDO DIGITO.
        for (int i = 0; i < cpfFormatado.length() - 1; i++) {
            dozeDigitosMultiplicados += Character.getNumericValue(cpfFormatado.charAt(i)) * contadorDezDigitos;
            contadorDezDigitos--;
        }
        
        restoDezDigitos = (dozeDigitosMultiplicados * 10) % 11;
        if (restoDezDigitos == 10) {
            ehValidoSegundoDigito = Character.getNumericValue(cpfFormatado.charAt(10)) == 0;
        } else {
            ehValidoSegundoDigito = Character.getNumericValue(cpfFormatado.charAt(10)) == restoDezDigitos;
        }
        
        return ehValidoPrimeiroDigito && ehValidoSegundoDigito;
    }
    
    public static boolean validarRG(String RG) {
        String RGFormatado = RG.replace(".", "").replace("-", "");
        int somaOitoDigitos = 0;
        int contadorOitoDigitos = 2;
        int restoOitoDigitos = 0;
        char digitoVerificador;
        
        for(int i = 0; i < RGFormatado.length() - 1; i++) {
            somaOitoDigitos += Character.getNumericValue(RGFormatado.charAt(i)) * contadorOitoDigitos;
            contadorOitoDigitos++;
        }
        restoOitoDigitos = somaOitoDigitos % 11;
        
        if (11 - restoOitoDigitos == 10) {
            digitoVerificador = 'X';
        } else if (11 - restoOitoDigitos == 0) {
            digitoVerificador = '0';
        } else {
            digitoVerificador = Character.forDigit(11 - restoOitoDigitos, 10);
        }
        System.out.println(RGFormatado.charAt(8) + " " + digitoVerificador);
        return RGFormatado.charAt(8) == digitoVerificador;
    }
    
    public static boolean validarCNPJ(String CNPJ) {
        String CNPJformatado = CNPJ.replace(".", "").replace("/", "").replace("-", "");
        int contadorDozeDigitos = 5;
        int somaDozeDigitos = 0;
        int restoDozeDigitos = 0;
        
        int somaTrezeDigitos = 0;
        int restoTrezeDigitos = 0;
        
        char primeiroDigitoVerificador;
        char segundoDigitoVerificador;
        
        // Calcular o primeiro dígito verificador:
        for (int i = 0; i < 4; i++) {
            somaDozeDigitos += Character.getNumericValue(CNPJformatado.charAt(i)) * contadorDozeDigitos;
            contadorDozeDigitos--;
            // System.out.print(CNPJformatado.charAt(i) + " ");
        }
        contadorDozeDigitos = 9;
        for (int i = 4; i < 12; i++) {
            somaDozeDigitos += Character.getNumericValue(CNPJformatado.charAt(i)) * contadorDozeDigitos;
            contadorDozeDigitos--;
            // System.out.print(CNPJformatado.charAt(i) + " ");
        }
        
        restoDozeDigitos = somaDozeDigitos % 11;
        if (restoDozeDigitos < 2) {
            primeiroDigitoVerificador = '0';
        } else {
            primeiroDigitoVerificador = Character.forDigit(11 - restoDozeDigitos, 10);
        }
        
        // Calcular o segundo dígito verificador:
        contadorDozeDigitos = 6;
        for (int i = 0; i < 5; i++) {
            somaTrezeDigitos += Character.getNumericValue(CNPJformatado.charAt(i)) * contadorDozeDigitos;
            contadorDozeDigitos--;
        }
        contadorDozeDigitos = 9;
        for (int i = 5; i < 13; i++) {
            somaTrezeDigitos += Character.getNumericValue(CNPJformatado.charAt(i)) * contadorDozeDigitos;
            contadorDozeDigitos--;
            System.out.print(CNPJformatado.charAt(i) + " ");
        }
        
        restoTrezeDigitos = somaTrezeDigitos % 11;
        if (restoTrezeDigitos < 2) {
            segundoDigitoVerificador = '0';
        } else {
            segundoDigitoVerificador = Character.forDigit(11 - restoTrezeDigitos, 10);
        }
        System.out.println(somaTrezeDigitos);
        
        return primeiroDigitoVerificador == CNPJformatado.charAt(12) && segundoDigitoVerificador == CNPJformatado.charAt(13);
    }    
}
