package metro_system;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class addbalance extends javax.swing.JInternalFrame {

    private final SmartCardService smartCardService;
    private String selectedCardId;

    public addbalance() {
        initComponents();
        smartCardService = new SmartCardService();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        searchSmartCards();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        addBalanceToCard();
    }

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
        loadSelectedCardBalance();
    }

    // UI LOGIC (SHORT METHODS)
    private void searchSmartCards() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);

        for (SmartCard card : smartCardService.searchCards(
                jTextField1.getText(),
                jTextField2.getText())) {

            model.addRow(new Object[]{
                card.getCardId(),
                card.getName(),
                card.getMobile(),
                card.getCardType()
            });
        }
    }

    private void addBalanceToCard() {
        if (selectedCardId == null) {
            JOptionPane.showMessageDialog(this, "Please select a card first.");
            return;
        }

        double amount = Double.parseDouble(jTextField4.getText());
        double newBalance = smartCardService.addBalance(selectedCardId, amount);

        jTextField5.setText(String.valueOf(newBalance));
        JOptionPane.showMessageDialog(this, "Balance updated successfully.");
    }

    private void loadSelectedCardBalance() {
        int row = jTable1.getSelectedRow();
        selectedCardId = jTable1.getValueAt(row, 0).toString();

        double balance = smartCardService.getBalance(selectedCardId);
        jTextField3.setText(String.valueOf(balance));
    }

    // =========================
    // DROP Drag GENERATED UI CODE
    // =========================
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Add balance to Card");

        jButton1.setText("Search");
        jButton1.addActionListener(evt -> jButton1ActionPerformed(evt));

        jButton2.setText("Add Balance");
        jButton2.addActionListener(evt -> jButton2ActionPerformed(evt));

        jLabel3.setText("Smartcard No.");
        jLabel5.setText("Name");
        jLabel6.setText("Current Balance");
        jLabel7.setText("Money to add");
        jLabel8.setText("New Balance");

        jTable1.setModel(new DefaultTableModel(
            new Object[][] {},
            new String[] {"Smartcard No.", "Name", "Mobile No.", "Card type"}
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20))
        );

        pack();
    }

    // =========================
    // VARIABLES
    // =========================
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
}
