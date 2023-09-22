import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConversorNotacion extends JFrame {
    public static JTextField textField;
    private JButton ejecutarButton;
    private JTable table;
    private DefaultTableModel tableModel;
    private String notacionInfija;
    private String notacionPostfija;
    private String notacionPrefija;

    public ConversorNotacion() {
        // Configura la ventana principal
        setTitle("Conversor de Notación");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Panel superior con el cuadro de texto y el botón de ejecutar
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        textField = new JTextField(20);
        ejecutarButton = new JButton("Ejecutar");
        topPanel.add(new JLabel("Notación Infija: "));
        topPanel.add(textField);
        topPanel.add(ejecutarButton);

        // Panel central con la tabla
        String[] columnNames = {"Notación Infija", "Notación Postfija", "Notación Prefija"};
        tableModel = new DefaultTableModel(columnNames, 0); // 0 indica que inicialmente no hay filas
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);

        ejecutarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notacionInfija = textField.getText();
                alg_pre p = new alg_pre();
                alg_post ap = new alg_post();
                
                textField.setText("");
                notacionPostfija = ap.ejecutarAlgoritmo(notacionInfija);
                notacionPrefija =  p.infixToPrefix(notacionInfija);
                
                // Agrega una nueva fila a la tabla con los resultados
                Object[] rowData = {notacionInfija, notacionPostfija, notacionPrefija};
                tableModel.addRow(rowData);
            }
        });
    }

    private String convertirPostfija(String notacionInfija) {
        return ""; // Implementa la conversión a notación Postfija
    }

    private String convertirPrefija(String notacionInfija) {
        return ""; // Implementa la conversión a notación Prefija
    }

    
}