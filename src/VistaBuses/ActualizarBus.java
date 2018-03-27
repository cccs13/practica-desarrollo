/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VistaBuses;

import vistas.VentanaPrincipal;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.ConexionDB;


/**
 *
 * @author EstudianteUnivalle
 */
public class ActualizarBus extends javax.swing.JDialog {

    /**
     * Creates new form ActualizarCli
     */
    public ActualizarBus(java.awt.Frame parent, boolean modal) {
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

        CapacidadBus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        botonGuardar = new javax.swing.JButton();
        IDBus = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        PlacaBus = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(400, 430));
        setMinimumSize(new java.awt.Dimension(400, 430));
        getContentPane().setLayout(null);
        getContentPane().add(CapacidadBus);
        CapacidadBus.setBounds(221, 188, 83, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Capacidad");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(119, 193, 91, 24);

        jLabel4.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        jLabel4.setText("ACTUALIZAR BUS ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(81, 21, 271, 33);

        botonGuardar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        botonGuardar.setText("GUARDAR");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(botonGuardar);
        botonGuardar.setBounds(145, 261, 123, 31);
        getContentPane().add(IDBus);
        IDBus.setBounds(221, 102, 83, 30);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("IDBus");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(119, 107, 98, 24);

        PlacaBus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlacaBusActionPerformed(evt);
            }
        });
        getContentPane().add(PlacaBus);
        PlacaBus.setBounds(221, 145, 83, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Placa");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(119, 150, 47, 24);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 340, 80, 30);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Inicio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(120, 340, 90, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/facturacion.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 420, 420);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
 
        if(
            IDBus.getText().equals("")||
            PlacaBus.getText().equals("")||
            CapacidadBus.getText().equals("")
           )
        {
          JOptionPane.showMessageDialog(this,"Llenar los valores a continuación"); 
          
        }else{
        
        ConexionDB conexion = new ConexionDB();
        String id = IDBus.getText();
        String placa = PlacaBus.getText();
        String capacidad = CapacidadBus.getText();

        String sql = "UPDATE Buses SET Placa = '";
        sql +=  placa + "', Capacidad_Pasajeros = '" + capacidad +"'WHERE IdBuses = '" + id + "'";
        conexion.Sentencia(sql);
        setVisible(false);
        JOptionPane.showMessageDialog(this,"Datos Ingresados Exitosamente");
  
        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void PlacaBusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlacaBusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlacaBusActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        new VentanaPrincipalBuses().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.setVisible(false);
        new VentanaPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ActualizarBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ActualizarBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ActualizarBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ActualizarBus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                ActualizarBus dialog = new ActualizarBus(new javax.swing.JFrame(), true);
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
    private javax.swing.JTextField CapacidadBus;
    private javax.swing.JTextField IDBus;
    private javax.swing.JTextField PlacaBus;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
