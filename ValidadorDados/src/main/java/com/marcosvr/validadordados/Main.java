package com.marcosvr.validadordados;

import com.marcosvr.validadordados.view.TelaPrincipalView;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.multi.MultiLookAndFeel;

/**
 *
 * @author VINICIUS
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            TelaPrincipalView tela = new TelaPrincipalView();
            tela.setVisible(true);
        } catch (ClassNotFoundException ex) {
            System.out.println("Houve um erro na classe: " + ex.getMessage());
        } catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            System.out.println("Houve um erro: " + ex.getMessage());
        }
    }
}
