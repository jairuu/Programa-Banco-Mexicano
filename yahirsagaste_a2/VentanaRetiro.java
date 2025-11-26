package YahirSagaste_A2;
import javax.swing.*;

public class VentanaRetiro extends JFrame {

    private JLabel lblCantidad;
    private JTextField txtCantidad;
    private JButton btnRetirar;
    private CuentaBancaria cuenta;
    private JFrame menu;

    public VentanaRetiro(CuentaBancaria cuenta, JFrame menu) {
        this.cuenta = cuenta;
        this.menu = menu;

        setTitle("Retiro - Banco Mexicano");
        setSize(300, 200);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        lblCantidad = new JLabel("Cantidad a retirar:");
        lblCantidad.setBounds(30, 20, 200, 25);
        add(lblCantidad);

        txtCantidad = new JTextField();
        txtCantidad.setBounds(30, 50, 200, 25);
        add(txtCantidad);

        btnRetirar = new JButton("Retirar");
        btnRetirar.setBounds(70, 100, 120, 30);
        add(btnRetirar);

        btnRetirar.addActionListener(e -> {
            try {
                double cantidad = Double.parseDouble(txtCantidad.getText());
                if (cuenta.retirar(cantidad)) {
                    JOptionPane.showMessageDialog(null, "Retiro exitoso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Fondos insuficientes.");
                }
                menu.setVisible(true);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ingrese un número válido");
            }
        });
    }
}
