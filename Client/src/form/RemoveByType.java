/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form;

import classes.MessagePacket;
import clie.ClientConnection;

import javax.swing.*;

/**
 * @author adgjw
 */
public class RemoveByType extends javax.swing.JDialog {

    /**
     * Creates new form RemoveById
     */
    private final ClientConnection con;
    private final String login;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox<String> typeC;


    public RemoveByType(java.awt.Frame parent, boolean modal, ClientConnection con, String login) {
        super(parent, modal);
        this.login = login;
        this.con = con;
        initComponents();
        ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("/form/icons/icons8_dragon_15px.png"));
        this.setIconImage(icon.getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        typeC = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local"); // NOI18N
        jLabel1.setText(bundle.getString("comm.choose")); // NOI18N
        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("form/Bundle"); // NOI18N
        jLabel1.setToolTipText(bundle1.getString("RemoveByType.jLabel1.toolTipText")); // NOI18N

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        typeC.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"WATER", "UNDERGROUND", "AIR", "FIRE"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addComponent(typeC, 0, 120, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(typeC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1)
                                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String s = typeC.getSelectedItem().toString();
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local");
        try {
            String ans = con.send(new MessagePacket("remove_by_type", s, login));
            if (ans.equals("В коллекции нет драконов с таким типом или тип был введен неверно.")) {
                //dispose();
                JOptionPane.showMessageDialog(this, bundle.getString("title.notype"));
            } else {
                Integer count = Integer.parseInt(ans);
                dispose();
                JOptionPane.showMessageDialog(this, bundle.getString("title.removedel") + ans);
            }
            //TODO фикс ответов
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // End of variables declaration//GEN-END:variables
}
