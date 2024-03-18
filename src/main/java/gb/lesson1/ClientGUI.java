package gb.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ClientGUI extends JFrame {


    Container container = getContentPane();
    private static final int WINDOW_HEIGHT = 550;
    private static final int WINDOW_WIDTH = 450;
    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JPanel panelMessage = new JPanel(new GridLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfUsername = new JTextField("username");
    private final JTextField tfPassword = new JTextField("PASSWORD");

    private final JButton btnLogin = new JButton("Login");

    private final JTextArea log = new JTextArea();
    private final JTextArea userTextField = new JTextArea();

    ClientGUI() {
        setWindow();

        ActionListener myButtonsListener = new ButtonsListener();
        btnLogin.addActionListener(myButtonsListener);
        btnSend.addActionListener(myButtonsListener);


    }

    public void setWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat client");
        setResizable(false);


        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(tfUsername);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        add(panelTop, BorderLayout.NORTH);


        panelMessage.add(userTextField);
        add(panelMessage, BorderLayout.CENTER);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);
        add(panelBottom, BorderLayout.SOUTH);

        setVisible(true);
    }

    class ButtonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Login")) {
                btnLogin.setText("Login");
                userTextField.setText("Вы успешно подключились! \n");
            }
            else {

                userTextField.setText("Подключение не удалось!");
            }
            if (command.equals("Send")) {
                btnSend.setText("Send");
                userTextField.setText(tfMessage.getText());
                ServerWindow.message(tfMessage.getText());
            }
        }
    }
}



