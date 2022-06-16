package form.forms;


import classes.Dragon;
import classes.DragonCharacter;
import classes.MessagePacket;
import clie.ClientConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;


public class MajorNew extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public final ClientConnection con;
    public final String logins;
    public List<Dragon> dragons = Collections.synchronizedList(new LinkedList<>());
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem add;
    private javax.swing.JMenuItem addifmax;
    private javax.swing.JMenu addm;
    private javax.swing.JMenuItem age;
    private javax.swing.JMenu comm;
    private javax.swing.JMenuItem help;
    private javax.swing.JMenu helpc;
    private javax.swing.JMenuItem history;
    private javax.swing.JComboBox<String> huinya;
    private javax.swing.JMenuItem info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu otherc;
    private javax.swing.JMenuItem removebyid;
    private javax.swing.JMenuItem removebytype;
    private javax.swing.JMenu removem;
    private javax.swing.JTable table;
    private javax.swing.JTabbedPane tablepane;
    private javax.swing.JMenuItem update;
    private javax.swing.JButton visual;

    public MajorNew(String logins, ClientConnection tmp) {
        this.con = tmp;
        this.logins = logins;

        initComponents();
        ImageIcon icon = new ImageIcon(getClass().getResource("/form/icons/icons8_dragon_15px.png"));
        this.setIconImage(icon.getImage());
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local");
        table.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        bundle.getString("title.id"), bundle.getString("title.name"), bundle.getString("title.x"),
                        bundle.getString("title.y"), bundle.getString("title.age"),
                        bundle.getString("title.speak"), bundle.getString("title.type"),
                        bundle.getString("title.character"),
                        bundle.getString("title.date"), bundle.getString("title.login")
                }
        ) {
            final Class[] types = new Class[]{
                    Long.class, String.class,
                    Long.class, Long.class,
                    Integer.class, Boolean.class,
                    String.class, String.class,
                    String.class, String.class
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });

        tablepane.addTab("Dragon", new DragonV(this));

        Runnable task = () -> {
            while (true) {
                getdata();
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MajorNew.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };

        Thread t = new Thread(task);
        t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        huinya = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        visual = new javax.swing.JButton();
        tablepane = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        comm = new javax.swing.JMenu();
        addm = new javax.swing.JMenu();
        add = new javax.swing.JMenuItem();
        addifmax = new javax.swing.JMenuItem();
        removem = new javax.swing.JMenu();
        removebyid = new javax.swing.JMenuItem();
        removebytype = new javax.swing.JMenuItem();
        helpc = new javax.swing.JMenu();
        help = new javax.swing.JMenuItem();
        history = new javax.swing.JMenuItem();
        info = new javax.swing.JMenuItem();
        otherc = new javax.swing.JMenu();
        update = new javax.swing.JMenuItem();
        age = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Dragon grimoire - user: " + logins);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocation(new java.awt.Point(500, 500));
        setLocationByPlatform(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        huinya.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"<none>", "WISE", "EVIL", "CHAOTIC_EVIL", "FICKLE"}));

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local"); // NOI18N
        jLabel1.setText(bundle.getString("comm.filter")); // NOI18N

        visual.setText(bundle.getString("vis")); // NOI18N
        visual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                visualActionPerformed(evt);
            }
        });

        table.setAutoCreateRowSorter(true);
        table.setModel(new DefaultTableModel(
                new Object[][]{

                },
                new String[]{
                        "ID", "Name", "Coordinate X", "Coordinate Y", "Age", "Speaking", "Type", "Character", "Date Creation", "Login"
                }
        ) {
            final Class[] types = new Class[]{
                    Long.class, String.class, Long.class, Long.class, Integer.class, Boolean.class, String.class, String.class, String.class, String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setShowGrid(true);
        jScrollPane1.setViewportView(table);

        tablepane.addTab("table", jScrollPane1);

        comm.setText(bundle.getString("comm.name")); // NOI18N

        addm.setText(bundle.getString("comm.addname")); // NOI18N

        add.setText(bundle.getString("comm.add")); // NOI18N
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        addm.add(add);

        addifmax.setText(bundle.getString("comm.addifmax")); // NOI18N
        addifmax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addifmaxActionPerformed(evt);
            }
        });
        addm.add(addifmax);

        comm.add(addm);

        removem.setText(bundle.getString("comm.removename")); // NOI18N

        removebyid.setText(bundle.getString("comm.removebyid")); // NOI18N
        removebyid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebyidActionPerformed(evt);
            }
        });
        removem.add(removebyid);

        removebytype.setText(bundle.getString("comm.removebytype")); // NOI18N
        removebytype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebytypeActionPerformed(evt);
            }
        });
        removem.add(removebytype);

        comm.add(removem);

        helpc.setText(bundle.getString("comm.helpn")); // NOI18N

        help.setText(bundle.getString("comm.help")); // NOI18N
        help.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpActionPerformed(evt);
            }
        });
        helpc.add(help);

        history.setText(bundle.getString("comm.history")); // NOI18N
        history.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                historyActionPerformed(evt);
            }
        });
        helpc.add(history);

        info.setText(bundle.getString("comm.Info")); // NOI18N
        info.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoActionPerformed(evt);
            }
        });
        helpc.add(info);

        comm.add(helpc);

        otherc.setText(bundle.getString("comm.other")); // NOI18N

        update.setText(bundle.getString("comm.update")); // NOI18N
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        otherc.add(update);

        age.setText(bundle.getString("comm.age")); // NOI18N
        age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ageActionPerformed(evt);
            }
        });
        otherc.add(age);

        comm.add(otherc);

        jMenuBar1.add(comm);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tablepane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 880, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(huinya, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(visual)
                                .addGap(41, 41, 41))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(tablepane, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(huinya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(visual, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tablepane.getAccessibleContext().setAccessibleName(bundle.getString("table")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        AddDragon tmp = new AddDragon(this, true, con, logins);
        tmp.setVisible(true);
    }//GEN-LAST:event_addActionPerformed

    private void addifmaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addifmaxActionPerformed
        AddIfMaxDragon tmp = new AddIfMaxDragon(this, true, con, logins);
        tmp.setVisible(true);
    }//GEN-LAST:event_addifmaxActionPerformed

    private void removebyidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebyidActionPerformed
        RemoveById tmp = new RemoveById(this, true, con, logins);
        tmp.setVisible(true);
        //System.out.println(tmp.isVisible());
    }//GEN-LAST:event_removebyidActionPerformed

    private void helpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpActionPerformed
        try {
            String s = con.send(new MessagePacket("help", logins));
            JOptionPane.showMessageDialog(this, s);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MajorNew.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_helpActionPerformed

    private void historyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_historyActionPerformed
        try {
            String s = con.send(new MessagePacket("history", logins));
            JOptionPane.showMessageDialog(this, s);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MajorNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_historyActionPerformed

    private void infoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoActionPerformed
        try {
            String s = con.send(new MessagePacket("info", logins));
            JOptionPane.showMessageDialog(this, s);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MajorNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_infoActionPerformed

    private void removebytypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebytypeActionPerformed
        RemoveByType tmp = new RemoveByType(this, true, con, logins);
        tmp.setVisible(true);
        //System.out.println(tmp.isVisible());
    }//GEN-LAST:event_removebytypeActionPerformed

    private void ageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ageActionPerformed
        Age tmp = new Age(this, true, con, logins);
        tmp.setVisible(true);
    }//GEN-LAST:event_ageActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        UpdByIdform tmp = new UpdByIdform(this, true, con, logins);
        tmp.setVisible(true);
    }//GEN-LAST:event_updateActionPerformed

    private void visualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_visualActionPerformed
        Visual tmp = new Visual(this, true);


    }//GEN-LAST:event_visualActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.dispose();
        (new ThreadG()).start();
    }//GEN-LAST:event_formWindowClosing

    private void getdata() {
        try {
            this.dragons = con.newsend(new MessagePacket("data", logins)).getDragons();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(MajorNew.class.getName()).log(Level.SEVERE, null, ex);
        }
        String s = huinya.getSelectedItem().toString();
        boolean f = true;
        DragonCharacter kek = null;
        if (s.equals("<none>"))
            f = false;
        else
            kek = DragonCharacter.valueOf(s);
        //System.out.println(this.dragons.size());
        DefaultTableModel tmp = (DefaultTableModel) table.getModel();
        tmp.setRowCount(0);
        for (Dragon lol : dragons) {
            if (!f || kek == lol.getCharacter()) {
                Object[] rowData = {lol.getId(), lol.getName(), lol.getCoordinates().getX(),
                        lol.getCoordinates().getY(), lol.getAge(), lol.isSpeaking(), lol.getType().toString(),
                        lol.getCharacter().toString(),
                        DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT, Locale.getDefault()).format(java.sql.Timestamp.valueOf(lol.getCreationDate())),
                        lol.getLogin()};
                tmp.addRow(rowData);
            }
        }
    }
    // End of variables declaration//GEN-END:variables
}
