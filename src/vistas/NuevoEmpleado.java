/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import modelo.ConexionDB;

/**
 *
 * @author EstudianteUnivalle
 */
public class NuevoEmpleado extends javax.swing.JDialog {

    /**
     * Creates new form NuevoCliente
     */
    public NuevoEmpleado(java.awt.Frame parent, boolean modal) {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        BotonGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        InID = new javax.swing.JTextField();
        InNombreEmp = new javax.swing.JTextField();
        InApellidoEmp = new javax.swing.JTextField();
        InCargoEmp = new javax.swing.JTextField();
        InSalarioEmp = new javax.swing.JTextField();
        InTelefonoEmp = new javax.swing.JTextField();
        InNominaEmp = new javax.swing.JTextField();
        InBusesEmp = new javax.swing.JTextField();
        InDireccionEmp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(420, 630));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("ID :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(87, 90, 30, 24);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nombre :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(87, 133, 82, 24);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Direccion :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(87, 430, 95, 24);

        jLabel4.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        jLabel4.setText("INGRESAR DATOS DEL EMPLEADO");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 30, 379, 25);

        BotonGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BotonGuardar.setText("Guardar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(BotonGuardar);
        BotonGuardar.setBounds(152, 491, 103, 33);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("TELEFONO");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(87, 305, 98, 16);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("APELLIDO");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(87, 176, 91, 24);

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("SALARIO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(87, 262, 81, 24);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Cargo");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(87, 219, 52, 24);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Nomina");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(87, 344, 67, 24);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Buses");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(87, 387, 55, 24);
        getContentPane().add(InID);
        InID.setBounds(227, 95, 91, 30);
        getContentPane().add(InNombreEmp);
        InNombreEmp.setBounds(227, 138, 91, 30);
        getContentPane().add(InApellidoEmp);
        InApellidoEmp.setBounds(227, 181, 91, 30);
        getContentPane().add(InCargoEmp);
        InCargoEmp.setBounds(227, 224, 91, 30);
        getContentPane().add(InSalarioEmp);
        InSalarioEmp.setBounds(227, 267, 91, 30);
        getContentPane().add(InTelefonoEmp);
        InTelefonoEmp.setBounds(227, 306, 91, 30);
        getContentPane().add(InNominaEmp);
        InNominaEmp.setBounds(227, 349, 91, 30);
        getContentPane().add(InBusesEmp);
        InBusesEmp.setBounds(227, 392, 91, 30);
        getContentPane().add(InDireccionEmp);
        InDireccionEmp.setBounds(227, 435, 91, 30);

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(10, 537, 79, 33);

        jButton2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton2.setText("Inicio");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(121, 537, 79, 33);

        jLabel11.setBackground(new java.awt.Color(255, 51, 0));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/emple.jpg"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(0, 0, 410, 580);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
     if(
            InID.getText().equals("")||
            InNominaEmp.getText().equals("")||
          InBusesEmp.getText().equals("")||
          InApellidoEmp.getText().equals("")||
          InCargoEmp.getText().equals("")||
          InSalarioEmp.getText().equals("")||
          InTelefonoEmp.getText().equals("")||
          InDireccionEmp.getText().equals("")
           )
        {
          JOptionPane.showMessageDialog(this,"Llenar los valores a continuación"); 
          
        }else{
        try{
        ConexionDB conexion = new ConexionDB();
        String id = InID.getText();
        String Nomina = InNominaEmp.getText();
        String Buses = InBusesEmp.getText();
        String nombre = InNombreEmp.getText();
        String Apellido = InApellidoEmp.getText();
        String Cargo = InCargoEmp.getText();
        String Salario = InSalarioEmp.getText();
        String Telefono = InTelefonoEmp.getText();
        String direccion = InDireccionEmp.getText();
        
        String sql = "INSERT INTO Empleados (idEmpleados,idNomina,Buses_idBuses,Nombre,Apellido,idCargo,Salario,Telefono,Direccion)";
        sql += "VALUES ( '"+ id +"','"+ Nomina +"','"+ Buses +"', '"+ nombre +"','"+ Apellido +"','"+Cargo+"','"+Salario+"','"+Telefono+"', '"+direccion+"')";
        conexion.Sentencia(sql);
        setVisible(false);
        JOptionPane.showMessageDialog(this,"Datos Ingresados Exitosamente");
      
     } 
        catch(Exception e){
                JOptionPane.showMessageDialog(this,"Llenar los valores a continuación");
                System.out.println(e.getMessage());
              }
     }
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new VentanaPrincipalEmpleados().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(NuevoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NuevoEmpleado dialog = new NuevoEmpleado(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JTextField InApellidoEmp;
    private javax.swing.JTextField InBusesEmp;
    private javax.swing.JTextField InCargoEmp;
    private javax.swing.JTextField InDireccionEmp;
    private javax.swing.JTextField InID;
    private javax.swing.JTextField InNombreEmp;
    private javax.swing.JTextField InNominaEmp;
    private javax.swing.JTextField InSalarioEmp;
    private javax.swing.JTextField InTelefonoEmp;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
