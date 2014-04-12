/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktoptelegram;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 *
 * @author dielson
 */
public class DesktopTelegram extends javax.swing.JFrame {

    public DesktopTelegram() {
        // init components
        setTitle("Desktop Telegram");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        messagesList = new DefaultListModel<String>();
        messagesList.addElement("Mensagem 1");
        messagesList.addElement("Mensagem 2");
        list = new JList(messagesList);
        JScrollPane scrollPane = new JScrollPane(list);

        add(scrollPane, BorderLayout.WEST);
        setSize(400, 300);
        pack();
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesktopTelegram().setVisible(true);
            }
        });
    }

    // variables
    DefaultListModel<String> messagesList;
    JList list;
}
