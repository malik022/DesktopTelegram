/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package desktoptelegram;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

/**
 *
 * @author dielson
 */
public class TelegramMenuBar extends JToolBar {
    JButton attachButton;

    public TelegramMenuBar() {
        attachButton = new JButton(new ImageIcon("assets/ic_attach.png"));
        add(attachButton);
    }

}
