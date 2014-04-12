package desktoptelegram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
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
        
        messageItems = new ArrayList<MessageItem>();
        messageItems.add(new MessageItem("Contato 1", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 2", "assets/contactIconSmall.png"));

//        modelList = new DefaultListModel<MessageItem>();
//        modelList.addElement(new MessageItem("Mensagem 1"));
//        modelList.addElement(new MessageItem("Mensagem 2"));

        messagesList = new JList(messageItems.toArray());
        messagesList.setCellRenderer(new MessageItemRender());
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
    DefaultListModel<MessageItem> modelList;
    JList messagesList;
    List<MessageItem> messageItems;
    
    private class MessageItem extends javax.swing.JPanel {

        public MessageItem(String contactName, String iconPath) {
            this.contactName = contactName;
            this.iconPath = iconPath;
        }
        public String getContactName() {
            return contactName;
        }
        public String getIconPath() {
            return iconPath;
        }
        String contactName;
        String iconPath;
    }
    
    private class MessageItemRender extends JLabel implements ListCellRenderer {
        private final Color HIGHLIGHT_COLOR = new Color(0, 0, 128);

        public MessageItemRender() {
            setOpaque(true);
        }

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            MessageItem item = (MessageItem) value;
            setText(item.getContactName());
            ImageIcon icon = new ImageIcon(item.getIconPath());
            setIcon(icon);
            if (isSelected) {
                setBackground(Color.blue);
                setForeground(Color.white);
            } else {
                setBackground(Color.white);
                setForeground(Color.black);
            }
            return this;
        }
        
    }
}
