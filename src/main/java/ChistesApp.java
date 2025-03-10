import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChistesApp {
    private static final String[] chistes = {
            "1. ¿Por qué los pájaros no usan Facebook? Porque ya tienen Twitter!",
            "2. ¿Cómo se dice pañuelo en chino? Saka-moko!",
            "3. Mamá, en el colegio me llaman distraído. -Juanito, tu casa es la de enfrente!",
            "4. ¿Por qué el libro de matemáticas está triste? Porque tiene demasiados problemas.",
            "5. ¿Qué hace una abeja en el gimnasio? Zum-ba!"
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Chistes App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JTextArea chistesArea = new JTextArea();
        chistesArea.setEditable(false);
        for (String chiste : chistes) {
            chistesArea.append(chiste + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(chistesArea);

        JTextField inputField = new JTextField();
        JButton siguienteButton = new JButton("Enviar");

        siguienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputField.getText();
                try {
                    int numero = Integer.parseInt(inputText);
                    if (numero == 5) {
                        JOptionPane.showMessageDialog(frame, "Por el culo te la hinco!", "Respuesta Correcta", JOptionPane.INFORMATION_MESSAGE);
                    } else if (numero >= 1 && numero <= 4) {
                        JOptionPane.showMessageDialog(frame, "Has seleccionado el chiste" + numero, "Información", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Introduce el NUMERO de chistes QUE HAY", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Introduce un NUMERO", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(new JLabel("¿Cuantos chistes hay?"), BorderLayout.WEST);
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(siguienteButton, BorderLayout.EAST);

        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(inputPanel, BorderLayout.SOUTH);

        frame.add(panel);
        frame.setVisible(true);
    }
}
