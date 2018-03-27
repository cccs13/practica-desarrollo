/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaCargos;

import VistaBuses.*;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;
import modelo.ConexionDB;
import vistas.VentanaPrincipal;


/**
 *
 * @author EstudianteUnivalle
 */
public class ActualizarCargo extends javax.swing.JDialog {

    /**
     * Creates new form ActualizarCli
     */
    public ActualizarCargo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("../img/iconoUnivalle.JPG")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        IDCargo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        NombreCargo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(480, 350));
        setMinimumSize(new java.awt.Dimension(480, 350));
        getContentPane().setLayout(null);

        jLabel4.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        jLabel4.setText("ACTUALIZAR");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(119, 23, 150, 25);

        botonGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonGuardar.setText("GUARDAR");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardar);
        botonGuardar.setBounds(164, 206, 125, 33);
        getContentPane().add(IDCargo);
        IDCargo.setBounds(235, 94, 83, 30);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("IDCARGO");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(119, 99, 98, 24);

        NombreCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreCargoActionPerformed(evt);
            }
        });
        getContentPane().add(NombreCargo);
        NombreCargo.setBounds(233, 137, 83, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("NombreCargo:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(81, 142, 134, 24);

        Volver.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        Volver.setText("Atras");
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });
        getContentPane().add(Volver);
        Volver.setBounds(10, 265, 79, 33);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Inicio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(121, 265, 79, 33);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/emple.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 530, 350);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
    if(
            IDCargo.getText().equals("")||
            NombreCargo.getText().equals("")
            
           )
        {
          JOptionPane.showMessageDialog(this,"Llenar los valores a continuación"); 
          
        }else{
        try{
        ConexionDB conexion = new ConexionDB();
        String id = IDCargo.getText();
        String Cargo = NombreCargo.getText();
        

        String sql = "UPDATE Cargo SET Nombre_Cargo = '";
        sql +=  Cargo +"'WHERE idCargo = '" + id + "'";
        conexion.Sentencia(sql);
        setVisible(true);
        JOptionPane.showMessageDialog(this,"Datos Actualizados Exitosamente");
     } catch(Exception e){
                JOptionPane.showMessageDialog(this,"Llenar los valores a continuación");
                System.out.println(e.getMessage());
              }
    }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void NombreCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreCargoActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed

        this.setVisible(false);
        new VentanaPrincipalCargo().setVisible(true);
    }//GEN-LAST:event_VolverActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        this.setVisible(false);
        new VentanaPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarCargo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ActualizarCargo dialog = new ActualizarCargo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDCargo;
    private javax.swing.JTextField NombreCargo;
    private javax.swing.JButton Volver;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
