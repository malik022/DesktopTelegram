package desktoptelegram;

import java.awt.BorderLayout;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 * The main application window.
 * @author dielson
 */
public class DesktopTelegram extends javax.swing.JFrame {

    public DesktopTelegram() {
        // init components
        setTitle("Desktop Telegram");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        modelList = new DefaultListModel<String>();
        modelList.addElement("Mensagem 1");
        modelList.addElement("Mensagem 2");

        messagesList = new JList(modelList);
        messagesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(messagesList);

        add(scrollPane, BorderLayout.WEST);
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
    DefaultListModel<String> modelList;
    JList messagesList;
}
