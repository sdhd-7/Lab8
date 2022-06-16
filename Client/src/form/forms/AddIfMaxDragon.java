/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package form.forms;

import classes.*;
import clie.ClientConnection;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author adgjw
 */
public class AddIfMaxDragon extends javax.swing.JDialog {

    /**
     * Creates new form NewDragon
     */


    private final ClientConnection con;

    private final String login;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JSpinner agef;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel character;
    private javax.swing.JComboBox<String> characterf;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    private javax.swing.JTextField namef;
    private javax.swing.JButton ok;
    private javax.swing.JLabel speak;
    private javax.swing.JComboBox<String> speakf;
    private javax.swing.JLabel type;
    private javax.swing.JComboBox<String> typef;
    private javax.swing.JLabel x;
    private javax.swing.JSpinner xf;
    private javax.swing.JLabel y;
    private javax.swing.JSpinner yf;

    public AddIfMaxDragon(java.awt.Frame parent, boolean modal, ClientConnection con, String login) {
        super(parent, modal);
        this.login = login;
        this.con = con;
        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/form/icons/icons8_dragon_15px.png"));
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

        jPanel1 = new javax.swing.JPanel();
        name = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        x = new javax.swing.JLabel();
        y = new javax.swing.JLabel();
        speak = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        character = new javax.swing.JLabel();
        namef = new javax.swing.JTextField();
        agef = new javax.swing.JSpinner();
        xf = new javax.swing.JSpinner();
        yf = new javax.swing.JSpinner();
        speakf = new javax.swing.JComboBox<>();
        typef = new javax.swing.JComboBox<>();
        characterf = new javax.swing.JComboBox<>();
        ok = new javax.swing.JButton();
        cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local"); // NOI18N
        setTitle(bundle.getString("dialog.newD")); // NOI18N
        setAlwaysOnTop(true);

        name.setText(bundle.getString("title.name")); // NOI18N

        age.setText(bundle.getString("title.age")); // NOI18N

        x.setText(bundle.getString("title.x")); // NOI18N

        y.setText(bundle.getString("title.y")); // NOI18N

        speak.setText(bundle.getString("title.speak")); // NOI18N

        type.setText(bundle.getString("title.type")); // NOI18N

        character.setText(bundle.getString("title.character")); // NOI18N

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("form/Bundle"); // NOI18N
        namef.setText(bundle1.getString("AddIfMaxDragon.namef.text_1")); // NOI18N

        agef.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));

        xf.setModel(new javax.swing.SpinnerNumberModel(0L, -198L, null, 1L));

        yf.setModel(new javax.swing.SpinnerNumberModel(0L, -198L, null, 1L));

        speakf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"YES", "NO"}));

        typef.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"WATER", "UNDERGROUND", "AIR", "FIRE"}));

        characterf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"WISE", "EVIL", "CHAOTIC_EVIL", "FICKLE"}));

        ok.setText(bundle1.getString("AddIfMaxDragon.ok.text_1")); // NOI18N
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        cancel.setText(bundle1.getString("AddIfMaxDragon.cancel.text_1")); // NOI18N
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(ok)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cancel))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(character, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(speak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(y, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(x))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(namef)
                                                        .addComponent(agef)
                                                        .addComponent(xf)
                                                        .addComponent(speakf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(yf)
                                                        .addComponent(typef, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(characterf, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(name)
                                        .addComponent(namef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(age)
                                        .addComponent(agef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(x)
                                        .addComponent(xf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(y)
                                        .addComponent(yf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(speak)
                                        .addComponent(speakf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(type)
                                        .addComponent(typef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(character)
                                        .addComponent(characterf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ok)
                                        .addComponent(cancel))
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void okActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okActionPerformed
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local");
        if (namef.getText().equals(""))
            JOptionPane.showMessageDialog(this, bundle.getString("error.empty"), null, JOptionPane.WARNING_MESSAGE);
        else {
            try {
                Dragon tmp = new Dragon();
                tmp.setName(namef.getText());

                tmp.setAge((int) agef.getValue());
                tmp.setSpeaking(true && speakf.getSelectedItem().equals("YES"));
                tmp.setCoordinates(new Coordinates((Long) xf.getValue(), (Long) yf.getValue()));
                switch (typef.getSelectedItem().toString()) {
                    case "UNDERGROUND" -> tmp.setType(DragonType.UNDERGROUND);
                    case "WATER" -> tmp.setType(DragonType.WATER);
                    case "AIR" -> tmp.setType(DragonType.AIR);
                    case "FIRE" -> tmp.setType(DragonType.FIRE);
                }
                tmp.setCreationDate(LocalDateTime.now());
                switch (characterf.getSelectedItem().toString()) {
                    case "EVIL" -> tmp.setCharacter(DragonCharacter.EVIL);
                    case "WISE" -> tmp.setCharacter(DragonCharacter.WISE);
                    case "CHAOTIC_EVIL" -> tmp.setCharacter(DragonCharacter.CHAOTIC_EVIL);
                    case "FICKLE" -> tmp.setCharacter(DragonCharacter.FICKLE);

                }
                tmp.setLogin(login);


                String ans = con.send(new MessagePacket("add", tmp, login));
                dispose();
                if (ans.equals("Элемент успешно добавлен."))
                    JOptionPane.showMessageDialog(this, bundle.getString("comm.suc"));
                else {
                    JOptionPane.showMessageDialog(this, bundle.getString("comm.err"));
                }
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(AddIfMaxDragon.class.getName()).log(Level.SEVERE, null, ex);
            }
            //dispose();
        }
    }//GEN-LAST:event_okActionPerformed
    // End of variables declaration//GEN-END:variables
}
