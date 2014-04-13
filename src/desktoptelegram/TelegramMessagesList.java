package desktoptelegram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

/**
 * The messages list component
 * @author dielson
 */
public class TelegramMessagesList extends JList {

    public TelegramMessagesList(Object objects[]) {
        super(objects);
        setCellRenderer(new MessageItemRender());
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }
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