import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame2 extends JFrame {

    public MainFrame2() {
        super("Selección de Operación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(2, 1));

        JButton button1 = new JButton("Números Normales");
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new CifrasSignificativasGUI();
            }
        });
        mainPanel.add(button1);

        JButton button2 = new JButton("Notación Científica");
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new NotacionCientificaFrame();
            }
        });
        mainPanel.add(button2);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame2();
            }
        });
    }
}

class CifrasSignificativasGUI extends JFrame {

    private JTextField inputField;
    private JTextArea resultArea;

    public CifrasSignificativasGUI() {
        super("Cifras Significativas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        inputField = new JTextField();
        mainPanel.add(inputField);

        JButton calculateButton = new JButton("Calcular Cifras Significativas");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCifrasSignificativas();
            }
        });
        mainPanel.add(calculateButton);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        mainPanel.add(resultArea);

        add(mainPanel);
        setVisible(true);
    }

    private void mostrarCifrasSignificativas() {
        try {
            String inputText = inputField.getText();
            String numeroSinCeros = inputText.replaceAll("^-?0+(?!$)", ""); // Cambiado de replaceFirst a replaceAll para considerar negativos
            resultArea.setText("Cifras Significativas: " + numeroSinCeros);
        } catch (NumberFormatException ex) {
            resultArea.setText("Error: Ingresa un número válido.");
        }
    }
}

class NotacionCientificaFrame extends JFrame {

    public NotacionCientificaFrame() {
        super("Notación Científica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 2));

        JTextField baseField = new JTextField();
        mainPanel.add(new JLabel("Base:"));
        mainPanel.add(baseField);

        JTextField exponentField = new JTextField();
        mainPanel.add(new JLabel("Exponente:"));
        mainPanel.add(exponentField);

        JButton calculateButton = new JButton("Calcular");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double base = Double.parseDouble(baseField.getText());
                    int exponente = Integer.parseInt(exponentField.getText());
                    double resultado = base * Math.pow(10, exponente);
                    JOptionPane.showMessageDialog(null, "Resultado: " + resultado, "Resultado", JOptionPane.PLAIN_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Error: Ingresa un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(calculateButton);

        add(mainPanel);
        setVisible(true);
    }
}