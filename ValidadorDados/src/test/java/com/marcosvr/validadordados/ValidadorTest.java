package com.marcosvr.validadordados;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author VINICIUS
 */
public class ValidadorTest {

    @Test
    public void testValidarCPF() {
        String cpfCorreto = "948.363.000-29";
        // String cpfCorretoII = "636.516.320-75";
        assertEquals(true, Validador.validarCPF(cpfCorreto));
    }

    @Test
    public void testValidarRG() {
        String rgCorreto = "45.528.981-5";
        assertEquals(true, Validador.validarRG(rgCorreto));
    }

    @Test
    public void testValidarCNPJ() {
        String cnpjCorreto = "38.911.283/0001-04";
        assertEquals(true, Validador.validarCNPJ(cnpjCorreto));
    }
}
