import javax.swing.SwingUtilities;

public class main{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ConversorNotacion conversor = new ConversorNotacion();
                conversor.setVisible(true);
            }
        });
    }
}