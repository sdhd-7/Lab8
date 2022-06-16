package form.forms;


import classes.MessagePacket;
import clie.ClientConnection;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 * @author adgjw
 */
public class Login extends JFrame {

    /**
     * Creates new form login
     */
    private final ClientConnection con;

    private String logins;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem enL;
    private javax.swing.JMenuItem grL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JButton login;
    private javax.swing.JTextField logt;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JPasswordField passt;
    private javax.swing.JButton reg;
    private javax.swing.JMenuItem roL;
    private javax.swing.JMenuItem ruL;
    private javax.swing.JLabel welcome;

    public Login(ClientConnection tmp) {
        this.con = tmp;
        this.logins = "";
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

        mainpanel = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logt = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        passt = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        reg = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        enL = new javax.swing.JMenuItem();
        ruL = new javax.swing.JMenuItem();
        grL = new javax.swing.JMenuItem();
        roL = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/Bundle"); // NOI18N
        setTitle(bundle.getString("Login.title")); // NOI18N
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 500));
        setLocationByPlatform(true);

        mainpanel.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(0, 0, 0)));
        mainpanel.setToolTipText(bundle.getString("Login.mainpanel.toolTipText")); // NOI18N

        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("form/local"); // NOI18N
        welcome.setText(bundle1.getString("text.welcome")); // NOI18N

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(bundle1.getString("log.login")); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setVerifyInputWhenFocusTarget(false);

        logt.setName(""); // NOI18N
        logt.setNextFocusableComponent(passt);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(bundle1.getString("log.password")); // NOI18N
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        passt.setNextFocusableComponent(login);
        passt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passtKeyPressed(evt);
            }
        });

        login.setText(bundle1.getString("but.log")); // NOI18N
        login.setNextFocusableComponent(reg);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        reg.setText(bundle1.getString("but.reg")); // NOI18N
        reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(mainpanelLayout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(login)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(reg))
                                        .addGroup(mainpanelLayout.createSequentialGroup()
                                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(mainpanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, mainpanelLayout.createSequentialGroup()
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(12, 12, 12)))
                                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(passt, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                                        .addComponent(logt))))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addContainerGap(198, Short.MAX_VALUE)
                                .addComponent(welcome)
                                .addContainerGap(199, Short.MAX_VALUE))
        );
        mainpanelLayout.setVerticalGroup(
                mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(mainpanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(welcome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(passt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(mainpanelLayout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(3, 3, 3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                                .addGroup(mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(reg)
                                        .addComponent(login))
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        jMenu1.setText(bundle1.getString("lang")); // NOI18N

        enL.setIcon(new ImageIcon(getClass().getResource("/form/icons/icons8_great_britain_15px.png"))); // NOI18N
        enL.setText(bundle1.getString("lang.EN")); // NOI18N
        enL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enLActionPerformed(evt);
            }
        });
        jMenu1.add(enL);

        ruL.setIcon(new ImageIcon(getClass().getResource("/form/icons/icons8_russian_federation_15px_3.png"))); // NOI18N
        ruL.setText(bundle1.getString("lang.RU")); // NOI18N
        ruL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ruLActionPerformed(evt);
            }
        });
        jMenu1.add(ruL);

        grL.setIcon(new ImageIcon(getClass().getResource("/form/icons/icons8_greece_15px.png"))); // NOI18N
        grL.setText(bundle1.getString("lang.GR")); // NOI18N
        grL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grLActionPerformed(evt);
            }
        });
        jMenu1.add(grL);

        roL.setIcon(new ImageIcon(getClass().getResource("/form/icons/icons8_romania_15px.png"))); // NOI18N
        roL.setText(bundle1.getString("lang.RO")); // NOI18N
        roL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roLActionPerformed(evt);
            }
        });
        jMenu1.add(roL);

        jMenuItem5.setIcon(new ImageIcon(getClass().getResource("/form/icons/icons8_south_africa_15px.png"))); // NOI18N
        jMenuItem5.setText(bundle1.getString("lang.ZA")); // NOI18N
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mainpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updT() {
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local"); // NOI18N
        welcome.setText(bundle.getString("text.welcome")); // NOI18N
        jLabel1.setText(bundle.getString("log.login")); // NOI18N
        jLabel2.setText(bundle.getString("log.password")); // NOI18N
        login.setText(bundle.getString("but.log")); // NOI18N
        reg.setText(bundle.getString("but.reg")); // NOI18N


    }

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        try {
            java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local");
            String kek = con.send(new MessagePacket("login",
                    con.SHA512(String.valueOf(passt.getPassword())),
                    logt.getText()));
            if (kek.equalsIgnoreCase("Успешная авторизация")) {
                logins = logt.getText();
                dispose();
                JFrame major = new MajorNew(logins, con);
                major.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, bundle.getString("text.bad"), null, JOptionPane.WARNING_MESSAGE);

            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loginActionPerformed

    private void regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regActionPerformed
        try {
            java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local");
            MessagePacket p = new MessagePacket("newlogin",
                    con.SHA512(String.valueOf(passt.getPassword())),
                    logt.getText());
            int col = JColorChooser.showDialog(
                    Login.this,
                    "Choose Background Color",
                    Color.BLACK).getRGB();
            p.setCol(col);
            String kek = con.send(p);
            if (kek.equalsIgnoreCase("Успешное добавление пользователя и авторизация")) {
                logins = logt.getText();
                dispose();
                JFrame major = new MajorNew(logins, con);
                major.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, bundle.getString("text.badr"), null, JOptionPane.WARNING_MESSAGE);

            }
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_regActionPerformed

    private void passtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passtKeyPressed
        if (evt.getKeyCode() == 10) {
            loginActionPerformed(null);
        }
        //System.out.println(evt.getKeyCode());
    }//GEN-LAST:event_passtKeyPressed

    private void ruLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ruLActionPerformed
        Locale.setDefault(new Locale("ru", "RU"));
        updT();
    }//GEN-LAST:event_ruLActionPerformed

    private void enLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enLActionPerformed
        Locale.setDefault(new Locale("en"));
        updT();
    }//GEN-LAST:event_enLActionPerformed

    private void grLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grLActionPerformed
        Locale.setDefault(new Locale("el", "GR"));
        updT();
    }//GEN-LAST:event_grLActionPerformed

    private void roLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roLActionPerformed
        Locale.setDefault(new Locale("ro", "RO"));
        updT();
    }//GEN-LAST:event_roLActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Locale.setDefault(new Locale("en", "ZA"));
        updT();
    }//GEN-LAST:event_jMenuItem5ActionPerformed
    // End of variables declaration//GEN-END:variables
}
