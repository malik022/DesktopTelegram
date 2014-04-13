package desktoptelegram;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 * The main application window.
 * @author dielson
 */
public class DesktopTelegram extends javax.swing.JFrame {

    // Constructor -------------------------------------------------------------
    public DesktopTelegram() {
        logger.setLevel(Level.ALL);
        initLookAndFeel();

        setTitle("Desktop Telegram");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        add(new TelegramMenuBar(), BorderLayout.NORTH);

        messageItems = new ArrayList<MessageItem>();
        messageItems.add(new MessageItem("Contato 1", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 2", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 3", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 4", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 5", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 6", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 7", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 8", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 9", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 10", "assets/contactIconSmall.png"));

        messagesList = new TelegramMessagesList(messageItems.toArray());
        JScrollPane scrollPane = new JScrollPane(messagesList);

        add(scrollPane, BorderLayout.WEST);
        pack();
        setLocationRelativeTo(null);
    }
    
    private void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DesktopTelegram().setVisible(true);
            }
        });
    }
    // variables ---------------------------------------------------------------
    JList messagesList;
    private List<MessageItem> messageItems;
    static final Logger logger = Logger.getLogger(DesktopTelegram.class.getName());
}
