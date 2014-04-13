package desktoptelegram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 * The main application window.
 * @author dielson
 */
public class DesktopTelegram extends javax.swing.JFrame {

    public DesktopTelegram() {
        logger.setLevel(Level.ALL);
        setTitle("Desktop Telegram");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

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

        messagesList = new JList(messageItems.toArray());
        messagesList.setCellRenderer(new MessageItemRender());
        messagesList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(messagesList);

        add(scrollPane, BorderLayout.WEST);
        pack();
        setLocationRelativeTo(null);
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

/**
 * The model of the message item.
 * @author dielson
 */
class MessageItem extends javax.swing.JPanel {

    public MessageItem(String contactName, String iconPath) {
        this.contactName = contactName;
        this.iconPath = iconPath;
        msgPreview = "";
    }

    public String getContactName() {
        return contactName;
    }
    public String getMsgPreview() {
        return msgPreview;
    }
    public void setMsgPreview(String msgPreview) {
        this.msgPreview = msgPreview;
    }
    public String getIconPath() {
        return iconPath;
    }
    String contactName;
    String msgPreview;
    String iconPath;
}

/**
 * The renderer of the message item
 * @author dielson
 */
class MessageItemRender extends JPanel implements ListCellRenderer {
    JLabel itemTitle;
    JLabel msgPreview;
    JLabel contactImage;
    JPanel eastPanel;

    public MessageItemRender() {
        setLayout(new BorderLayout());
        itemTitle = new JLabel();
        itemTitle.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        msgPreview = new JLabel();
        contactImage = new JLabel();
        eastPanel = new JPanel(new BorderLayout());
        eastPanel.setBorder(new EmptyBorder(0, 10, 20, 10));
        eastPanel.setOpaque(false);
        add(contactImage, BorderLayout.WEST);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        eastPanel.add(itemTitle, BorderLayout.NORTH);
        eastPanel.add(msgPreview, BorderLayout.SOUTH);
        add(eastPanel, BorderLayout.EAST);
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        MessageItem item = (MessageItem) value;
        itemTitle.setText(item.getContactName());
        msgPreview.setText("Hey, how are you?");
        contactImage.setIcon(new ImageIcon(item.getIconPath()));
        if (isSelected) {
            setBackground(Color.blue);
            itemTitle.setForeground(Color.white);
            msgPreview.setForeground(Color.white);
        } else {
            setBackground(Color.white);
            itemTitle.setForeground(Color.black);
            msgPreview.setForeground(Color.black);
        }
        return this;
    }
}
