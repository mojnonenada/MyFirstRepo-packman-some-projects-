import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Chat extends JFrame {

  //  ImageIcon butto = new ImageIcon("C:\\Users\\artur\\Desktop\\Chat\\res\\images.png");
    JButton sendMessage = new JButton("Send");
    JPanel jUp = new JPanel(new GridLayout());
    JPanel jDown = new JPanel(new GridLayout());
    JTextArea textArea = new JTextArea();
    JScrollPane scroll = new JScrollPane(textArea);
    JTextField textField = new JTextField();


    Chat() {
        setTitle("Chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(400,300);
        //create window

        textArea.setEnabled(false);
        textArea.setLineWrap(true);
        //textArea.setFont (Font.getFont("Italic"));
        //restriction on textArea

        sendMessage.addActionListener(e -> sendingMessage());
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendingMessage();
            }
        });
        //action

        jDown.add(textField);
        jDown.add(sendMessage);
        jUp.add(scroll);
        add(jUp);
        add("South", jDown);
        //add to JPanel

        setVisible(true);
    }

    private void sendingMessage() {
        String vivod = textField.getText();
        textArea.append(vivod+" " + "\n");
        textField.setText("");
        textField.grabFocus();
    }
}
