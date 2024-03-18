package gb.lesson1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;



public class ServerWindow extends JFrame {

    private static final int WINDOW_HEIGHT = 550;
    private static final int WINDOW_WIDTH = 500;
    public static final JButton btnStart = new JButton("Start");
    private static final JButton btnStop = new JButton("Stop");
    private static final TextField message = new TextField("");
    public static final String logSave = "src/main/java/gb/lesson1/log.txt";

    ServerWindow() {


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Chat server");
        setResizable(false);
        btnStart.setActionCommand("Запустить");
        btnStop.setActionCommand("Остановить");
        message.setText("");
        ActionListener myButtonsListener = new ButtonsListener();


        btnStart.addActionListener(myButtonsListener);
        btnStop.addActionListener(myButtonsListener);

        JPanel panText = new JPanel(new GridLayout());
        panText.add(message);
        add(panText, BorderLayout.CENTER);

        JPanel panBottom = new JPanel(new GridLayout(1, 2));
        panBottom.add(btnStart);
        panBottom.add(btnStop);
        add(panBottom, BorderLayout.SOUTH);
        setVisible(true);
    }
    public static void message(String t) {
        message.setText(t + "\n");

        saveInLog(t + "\n");
    }
    static class ButtonsListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Остановить")) {
                btnStart.setText("Старт");
                btnStop.setText("Стоп");
                message.setText("Сервер отключен");
            } else {
                btnStart.setText("Запущено");
                btnStop.setText("Остановить");
                message.setText("Сервер запущен");
            }


        }
    }
    private static void saveInLog(String text){
        try (FileWriter writer = new FileWriter(logSave, true)){
            writer.write(text);
            writer.write("\n");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}











