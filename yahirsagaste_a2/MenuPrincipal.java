package YahirSagaste_A2;
import javax.swing.*;

/**
 *
 * @author Yahir Sagaste
 */
public class MenuPrincipal extends JFrame {

    private JButton btnDeposito, btnRetiro, btnSaldo, btnSalir;
    private CuentaBancaria cuenta;

    public MenuPrincipal() {
        cuenta = new CuentaBancaria();

        setTitle("Banco Mexicano - Menú Principal");
        setSize(350, 250);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        btnDeposito = new JButton("Depósito");
        btnDeposito.setBounds(100, 20, 150, 30);
        add(btnDeposito);

        btnRetiro = new JButton("Retiro");
        btnRetiro.setBounds(100, 60, 150, 30);
        add(btnRetiro);

        btnSaldo = new JButton("Saldo");
        btnSaldo.setBounds(100, 100, 150, 30);
        add(btnSaldo);

        btnSalir = new JButton("Salir");
        btnSalir.setBounds(100, 140, 150, 30);
        add(btnSalir);

        btnDeposito.addActionListener(e -> {
            new VentanaDeposito(cuenta, this).setVisible(true);
            this.setVisible(false);
        });

        btnRetiro.addActionListener(e -> {
            new VentanaRetiro(cuenta, this).setVisible(true);
            this.setVisible(false);
        });

        btnSaldo.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Saldo actual: $" + cuenta.getSaldo());
        });

        btnSalir.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "La sesión ha sido cerrada.");System.exit(0);
        });
    }
    public static void main(String[] args) {
        new MenuPrincipal().setVisible(true);
    }
}
