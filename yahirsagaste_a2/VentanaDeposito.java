package YahirSagaste_A2;
import javax.swing.*;

public class VentanaDeposito extends JFrame {

    private JLabel lblCantidad;
    private JTextField txtCantidad;
    private JButton btnDepositar;
    private CuentaBancaria cuenta;
    private JFrame menu;

    public VentanaDeposito(CuentaBancaria cuenta, JFrame menu) {
        this.cuenta = cuenta;
        this.menu = menu;

        setTitle("Depósito - Banco Mexicano");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        lblCantidad = new JLabel("Cantidad a depositar:");
        lblCantidad.setBounds(30, 20, 200, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(30, 50, 200, 25);
        add(txtCantidad);

        btnDepositar = new JButton("Depositar");
        btnDepositar.setBounds(70, 100, 120, 30);
        add(btnDepositar);

        btnDepositar.addActionListener(e -> {
            try {
                double cantidad = Double.parseDouble(txtCantidad.getText());
                cuenta.depositar(cantidad);

                int option = JOptionPane.showConfirmDialog(
                    null, 
                    "¿Desea realizar otro depósito?", 
                    "Confirmación", 
                    JOptionPane.YES_NO_OPTION
                );

                if (option == JOptionPane.YES_OPTION) {
                    txtCantidad.setText("");
                } else {
                    menu.setVisible(true);
                    this.dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
            }
        });
    }
}
