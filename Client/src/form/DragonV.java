/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import classes.Coordinates;
import classes.Dragon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author adgjw
 */
public class DragonV extends javax.swing.JPanel implements ActionListener {

    /**
     * Creates new form NewJPanel1
     */

    private final HashMap<String, Color> col = new HashMap<>();
    private final Image dr = (new javax.swing.ImageIcon(getClass().getResource("/form/icons/icons8_year_of_dragon_40px.png"))).getImage();
    private final MajorNew parent;
    private final int x = 5, y = 5;
    private List<Dragon> curr;

    public DragonV(MajorNew t) {
        initComponents();
        parent = t;
        curr = parent.dragons;
        setPreferredSize(new java.awt.Dimension(880, 495));
        Timer tt = new Timer(1, this);
        tt.start();
    }

    public static void tint(BufferedImage img, Color newc) {

        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {

                Color color = new Color(img.getRGB(x, y));
                if (!color.equals(new Color(0, 0, 0))) {
                    color = newc;
                    img.setRGB(x, y, color.getRGB());
                }
            }
        }
    }

    public static BufferedImage toBufferedImage(Image img) {
        if (img instanceof BufferedImage) {
            return (BufferedImage) img;
        }

        // Create a buffered image with transparency
        BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

        // Draw the image on to the buffered image
        Graphics2D bGr = bimage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();

        // Return the buffered image
        return bimage;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(880, 495));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 488, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 314, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        for (Dragon tmp : curr) {
            int x = (int) tmp.getCoordinates().getX();
            int y = (int) tmp.getCoordinates().getY();
            //System.out.println(evt.getXOnScreen() + " " + evt.getX());
            if (evt.getX() - x <= 40 && evt.getX() - x >= 0 && evt.getY() - y <= 40 && evt.getY() - y >= 0) {
                java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local"); // NOI18N
                String ans = bundle.getObject("title.id") + ": " + tmp.getId() + "\n" +
                        bundle.getObject("title.name") + ": " + tmp.getName() + "\n" +
                        bundle.getObject("title.x") + ": " + tmp.getCoordinates().getX() + "\n" +
                        bundle.getObject("title.y") + ": " + tmp.getCoordinates().getY() + "\n" +
                        bundle.getObject("title.age") + ": " + tmp.getAge() + "\n" +
                        bundle.getObject("title.speak") + ": " + tmp.isSpeaking() + "\n" +
                        bundle.getObject("title.type") + ": " + tmp.getType() + "\n" +
                        bundle.getObject("title.character") + ": " + tmp.getCharacter() + "\n" +
                        bundle.getObject("title.login") + ": " + tmp.getLogin() + "\n";
                JOptionPane.showMessageDialog(parent, ans);
            }
        }
    }//GEN-LAST:event_formMouseClicked

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        Image icon = (new javax.swing.ImageIcon(getClass().getResource("/form/icons/map.png"))).getImage();
        g2D.drawImage(icon, 0, 0, null);
        Image icon2 = dr;
        //g2D.drawImage(icon2, 20, 20, null);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("form/local"); // NOI18N
        List<Dragon> dragons = Collections.synchronizedList(new LinkedList<>());
        for (Dragon tmp : parent.dragons) {
            Dragon res = null;
            for (Dragon cc : curr) {
                if (cc.getId() == tmp.getId()) {
                    res = cc;
                    break;
                }
            }
            BufferedImage lol = toBufferedImage(icon2);
            Color keks = tmp.getCol();
            tint(lol, keks);
            if (res == null) {
                g2D.drawImage(lol, (int) tmp.getCoordinates().getX(), (int) tmp.getCoordinates().getY(), null);
            } else {
                int dx = (int) (tmp.getCoordinates().getX() - res.getCoordinates().getX());
                int dy = (int) (tmp.getCoordinates().getY() - res.getCoordinates().getY());
                if (Math.abs(dx) < 10) {
                    dx = (int) tmp.getCoordinates().getX();
                } else {
                    dx = (int) (res.getCoordinates().getX() + x * Math.signum(dx));
                }
                if (Math.abs(dy) < 10) {
                    dy = (int) tmp.getCoordinates().getY();
                } else {
                    dy = (int) (res.getCoordinates().getY() + y * Math.signum(dy));
                }
                tmp.setCoordinates(new Coordinates(dx, dy));
                g2D.drawImage(lol, (int) tmp.getCoordinates().getX(), (int) tmp.getCoordinates().getY(), null);
            }
            dragons.add(tmp);
        }
        curr = dragons;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(e.getActionCommand());
        repaint();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
