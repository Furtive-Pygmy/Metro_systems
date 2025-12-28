package metro_system;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.JComboBox;

/**
 *
 * @author sparsh
 */
public class addfare extends javax.swing.JInternalFrame {

    private final FareDAO fareDAO = new FareDAO();

    /**
     * Creates new form addfare
     */
    public addfare() {
        initComponents();
        loadRoutes();
    }

    /* =======================
       UI Helper Methods
       ======================= */

    private void loadRoutes() {
        try {
            List<String> routes = fareDAO.getRoutes();
            for (String route : routes) {
                jComboBox2.addItem(route);
                jComboBox3.addItem(route);
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    private void loadStations(JComboBox<String> targetCombo, String route) {
        try {
            targetCombo.removeAllItems();
            targetCombo.addItem("choose station");

            List<String> stations = fareDAO.getStationsForRoute(route);
            for (String station : stations) {
                targetCombo.addItem(station);
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    private void showError(Exception e) {
        JOptionPane.showMessageDialog(
                this,
                e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    /* =======================
       Generated UI Code
       ======================= */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Add Fare Info.");

        jLabel1.setText("From");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose route" }));
        jComboBox2.addActionListener(this::jComboBox2ActionPerformed);

        jLabel2.setText("To:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Choose route" }));
        jComboBox3.addActionListener(this::jComboBox3ActionPerformed);

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "choose route first" }));
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "choose route first" }));

        jLabel3.setText("Fare (Rs.)");
        jLabel4.setText("Travelling Time");
        jLabel5.setText("Mins.");
        jLabel6.setText("Distance");
        jLabel7.setText("Kms.");
        jLabel8.setText("Stations in between");

        jButton1.setText("Save");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, 0, 220, Short.MAX_VALUE)
                    .addComponent(jComboBox3, 0, 220, Short.MAX_VALUE)
                    .addComponent(jTextField1)
                    .addComponent(jTextField2)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox4, 0, 200, Short.MAX_VALUE)
                    .addComponent(jComboBox5, 0, 200, Short.MAX_VALUE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox2)
                    .addComponent(jComboBox4))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox3)
                    .addComponent(jComboBox5))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2)
                    .addComponent(jLabel5))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3)
                    .addComponent(jLabel7))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4))
                .addGap(40, 40, 40)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /* =======================
       Event Handlers
       ======================= */

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox2.getSelectedIndex() > 0) {
            loadStations(jComboBox4, (String) jComboBox2.getSelectedItem());
        }
    }

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {
        if (jComboBox3.getSelectedIndex() > 0) {
            loadStations(jComboBox5, (String) jComboBox3.getSelectedItem());
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            Fare fare = new Fare(
                    (String) jComboBox2.getSelectedItem(),
                    (String) jComboBox3.getSelectedItem(),
                    (String) jComboBox4.getSelectedItem(),
                    (String) jComboBox5.getSelectedItem(),
                    jTextField1.getText(),
                    jTextField2.getText(),
                    jTextField3.getText(),
                    jTextField4.getText()
            );

            if (fareDAO.insertFare(fare)) {
                JOptionPane.showMessageDialog(this, "Information stored successfully");
            }
        } catch (Exception e) {
            showError(e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
