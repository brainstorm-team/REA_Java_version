/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import DAO.classes.FavorisDAO;
import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jemacom
 */
public class Acceuil_client extends javax.swing.JFrame {

     private JPopupMenu popup;
    /**
     * Creates new form Acceuil
     */
    public Acceuil_client() {
        initComponents();
        this.setLocationRelativeTo(null);
        acceuil.setIcon(createIcon("/images/home.gif"));
        popup = new JPopupMenu();
       
        JMenuItem FavorisItem =  new JMenuItem("Ajouter aux favoris");
        popup.add(FavorisItem);
        table_offres.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e){
                JTable table =(JTable) e.getSource();
                Point p = e.getPoint();
                int row = table.rowAtPoint(p);
                
                
                System.out.println(row);
                if (e.getButton() ==  MouseEvent.BUTTON3){
                    popup.show(table , e.getX() , e.getY());
                }
            }
            
        });
        FavorisItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               int row =table_offres.getSelectedRow(); 
               System.out.println("my id "+table_offres.getModel().getValueAt(table_offres.getSelectedRow(), 10));
                FavorisDAO.getInstance().insertFavoris((int)table_offres.getModel().getValueAt(table_offres.getSelectedRow(), 10));
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        bt_mon_compte = new javax.swing.JButton();
        bt_recherche = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_offres = new javax.swing.JTable();
        acceuil = new javax.swing.JLabel();
        bt_mes_favoris = new javax.swing.JButton();
        bt_a_propos = new javax.swing.JButton();
        bt_mes_offres = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bt_refrech = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bt_mon_compte.setText("Mon compte");
        bt_mon_compte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mon_compteActionPerformed(evt);
            }
        });
        getContentPane().add(bt_mon_compte, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 53, -1, -1));

        bt_recherche.setText("Recherche Avancee");
        bt_recherche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_rechercheActionPerformed(evt);
            }
        });
        getContentPane().add(bt_recherche, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 180, -1, -1));

        table_offres.setModel(new ListOffreValide());
        table_offres.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_offresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_offres);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 53, 481, 321));

        acceuil.setText("Acceuil :");
        getContentPane().add(acceuil, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 16, 77, 25));

        bt_mes_favoris.setText("Mes favoris");
        bt_mes_favoris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mes_favorisActionPerformed(evt);
            }
        });
        getContentPane().add(bt_mes_favoris, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 93, -1, -1));

        bt_a_propos.setText("A propos");
        bt_a_propos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_a_proposActionPerformed(evt);
            }
        });
        getContentPane().add(bt_a_propos, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 221, -1, -1));

        bt_mes_offres.setText("Mes offres");
        bt_mes_offres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_mes_offresActionPerformed(evt);
            }
        });
        getContentPane().add(bt_mes_offres, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 133, -1, -1));

        jLabel1.setText("Liste des offres disponibles :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(188, 18, -1, -1));

        bt_refrech.setText("Refrech");
        bt_refrech.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_refrechActionPerformed(evt);
            }
        });
        getContentPane().add(bt_refrech, new org.netbeans.lib.awtextra.AbsoluteConstraints(574, 12, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_mon_compteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mon_compteActionPerformed
        CompteClient cc = new CompteClient();
        cc.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_mon_compteActionPerformed

    private ImageIcon createIcon(String path){
        URL url = getClass().getResource(path);
        if (url == null){
            System.err.println("Unable de load the image !"+path);
            return null;
        }
        
        ImageIcon icon = new ImageIcon(url);
        return icon;
        
    }
    private void bt_rechercheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_rechercheActionPerformed
        RechercheAvancee ra = new RechercheAvancee();
        ra.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_rechercheActionPerformed

    private void bt_a_proposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_a_proposActionPerformed
        Apropos ap = new Apropos();
        ap.setVisible(true);
        
    }//GEN-LAST:event_bt_a_proposActionPerformed

    private void bt_mes_favorisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mes_favorisActionPerformed
        ClientMesFavoris cmf = new ClientMesFavoris();
        cmf.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_mes_favorisActionPerformed

    private void bt_refrechActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_refrechActionPerformed
        table_offres = new javax.swing.JTable();

        table_offres.setModel(new ListOffreValide());

        jScrollPane1.setViewportView(table_offres);
    }//GEN-LAST:event_bt_refrechActionPerformed

    private void bt_mes_offresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_mes_offresActionPerformed
        ClientMesOffres mo = new ClientMesOffres();
        mo.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bt_mes_offresActionPerformed

    private void table_offresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_offresMouseClicked
        
    }//GEN-LAST:event_table_offresMouseClicked
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Acceuil_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Acceuil_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Acceuil_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Acceuil_client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try{
                    UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
                    
                    new Acceuil_client().setVisible(true);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Acceuil_client.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ParseException ex) {
                    Logger.getLogger(Acceuil_client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel acceuil;
    private javax.swing.JButton bt_a_propos;
    private javax.swing.JButton bt_mes_favoris;
    private javax.swing.JButton bt_mes_offres;
    private javax.swing.JButton bt_mon_compte;
    private javax.swing.JButton bt_recherche;
    private javax.swing.JButton bt_refrech;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_offres;
    // End of variables declaration//GEN-END:variables

}
