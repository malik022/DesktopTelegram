package desktoptelegram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

/**
 * The main application window.
 * @author dielson
 */
public class DesktopTelegram extends javax.swing.JFrame {

    public DesktopTelegram() {
        setTitle("Desktop Telegram");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        messageItems = new ArrayList<MessageItem>();
        messageItems.add(new MessageItem("Contato 1", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 2", "assets/contactIconSmall.png"));
        messageItems.add(new MessageItem("Contato 3", "assets/contactIconSmall.png"));

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
    // variables ---------------------------------------------------------------
    JList messagesList;
    private List<MessageItem> messageItems;
}

class MessageItem extends javax.swing.JPanel {

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

class MessageItemRender extends JPanel implements ListCellRenderer {
    JLabel itemTitle;
    JLabel contactImage;

    public MessageItemRender() {
        System.out.println("Creating a new MessageItemRenderer()");
        setLayout(new BorderLayout());
        itemTitle = new JLabel();
        contactImage = new JLabel();
        add(contactImage, BorderLayout.WEST);
        add(itemTitle, BorderLayout.EAST);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        MessageItem item = (MessageItem) value;

        itemTitle.setText(item.getContactName());
//            ImageIcon icon = new ImageIcon(item.getIconPath());
        contactImage.setIcon(new ImageIcon(item.getIconPath()));
        if (isSelected) {
            setBackground(Color.yellow);
//                setForeground(Color.white);
        } else {
            setBackground(Color.white);
//                setForeground(Color.black);
        }
        return this;
    }
}
