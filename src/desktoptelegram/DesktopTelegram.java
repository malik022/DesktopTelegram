/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktoptelegram;

import javax.swing.JFrame;

/**
 *
 * @author dielson
 */
public class DesktopTelegram extends JFrame {

    public DesktopTelegram() {
        // init components
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesktopTelegram().setVisible(true);
            }
        });
    }
}
