/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrador;

import cajeroautomaticodian.Conexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author Dian Veselinov Atanasov
 * @since 10/05/2018
 */
public class Tarjeta extends javax.swing.JFrame {

    /**
     * Creates new form AgendaGrafica
     */
    //VARIABLES GLOBALES o DE CLASE:
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    private boolean datosModificados = false;
    private Admin admin;

    public Tarjeta(Admin admin) {

        initComponents();
        initBaseDatos();
        btnAnadir.setVisible(false);
        btnAnadir.setEnabled(false);
        ventanas();
        this.admin = admin;
        this.setTitle("Tarjetas");
    }

    private void ventanas() {
        this.setSize(807, 450);//tamaño del jFrame
        this.setLocationRelativeTo(null); //jframe al centro

    }

    private void cerrarBD(java.awt.event.WindowEvent evt) {
        try {
            System.out.println("Cerrando la base de datos...");
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblRespuesta = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnDelete = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPrevious = new javax.swing.JButton();
        btnAdd = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        pnlDatos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txfCuenta = new javax.swing.JTextField();
        txfActiva = new javax.swing.JTextField();
        txfID = new javax.swing.JTextField();
        btnAnadir = new javax.swing.JButton();
        fecha = new javax.swing.JLabel();
        txfClave = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblRespuesta.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        lblRespuesta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(lblRespuesta);
        lblRespuesta.setBounds(70, 260, 690, 30);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/delete.png"))); // NOI18N
        btnDelete.setPreferredSize(new java.awt.Dimension(52, 53));
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarEntrada(evt);
            }
        });

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/first.png"))); // NOI18N
        btnFirst.setMaximumSize(new java.awt.Dimension(52, 53));
        btnFirst.setMinimumSize(new java.awt.Dimension(52, 53));
        btnFirst.setPreferredSize(new java.awt.Dimension(52, 53));
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverFirst(evt);
            }
        });

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/last.png"))); // NOI18N
        btnLast.setPreferredSize(new java.awt.Dimension(52, 53));
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverLast(evt);
            }
        });

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/next.png"))); // NOI18N
        btnNext.setPreferredSize(new java.awt.Dimension(52, 53));
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverNext(evt);
            }
        });

        btnPrevious.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/previous.png"))); // NOI18N
        btnPrevious.setPreferredSize(new java.awt.Dimension(52, 53));
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moverPrevious(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/boton0.PNG"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEntrada(evt);
            }
        });

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotonesLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotonesLayout.createSequentialGroup()
                .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNext, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrevious, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlBotonesLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(pnlBotones);
        pnlBotones.setBounds(70, 290, 700, 96);

        jButton1.setBackground(new java.awt.Color(255, 255, 204));
        jButton1.setForeground(new java.awt.Color(102, 102, 255));
        jButton1.setText("VOLVER AL MENU ADMIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 0, 820, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("CUENTA: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ACTIVA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("ID:");

        txfCuenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCuentaActionPerformed(evt);
            }
        });
        txfCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modificarDatos(evt);
            }
        });

        txfActiva.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfActiva.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modificarDatos(evt);
            }
        });

        txfID.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfIDActionPerformed(evt);
            }
        });
        txfID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modificarDatos(evt);
            }
        });

        btnAnadir.setBackground(new java.awt.Color(204, 102, 255));
        btnAnadir.setText("añadir");
        btnAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnadirActionPerformed(evt);
            }
        });

        fecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        fecha.setText("CODIGO PIN:");

        txfClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfClaveActionPerformed(evt);
            }
        });
        txfClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                modificarDatos(evt);
            }
        });

        jLabel5.setText("(Activa 0, desactivada 1)");

        jLabel6.setText("(Debe existir) ");

        jLabel7.setText("(No repetir con otra tarjeta)");

        jLabel8.setText("(4 digitos)");

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(fecha)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel8))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlDatosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txfClave)
                    .addComponent(txfID)
                    .addComponent(txfActiva, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfCuenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAnadir)
                .addGap(35, 35, 35))
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txfActiva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jLabel7))
                    .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fecha)
                    .addComponent(txfClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(btnAnadir)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(pnlDatos);
        pnlDatos.setBounds(70, 40, 710, 220);

        jLabel4.setBackground(new java.awt.Color(0, 255, 255));
        jLabel4.setForeground(new java.awt.Color(102, 204, 255));
        jLabel4.setAutoscrolls(true);
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 820, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void moverNext(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverNext

        try {
            btnAdd.setSelected(false);
            if (datosModificados == true) {
                modifyLineaBD();
                datosModificados = false;
            }
            if (resultado.next()) {
                mostrarDatos();
            } else {
                resultado.previous();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_moverNext

    private void moverPrevious(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverPrevious
        try {
            btnAdd.setSelected(false);
            if (datosModificados == true) {
                modifyLineaBD();
                datosModificados = false;
            }
            if (resultado.previous()) {
                mostrarDatos();
            } else {
                resultado.first();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_moverPrevious

    private void moverFirst(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverFirst
        try {
            btnAdd.setSelected(false);
            if (datosModificados == true) {
                modifyLineaBD();
                datosModificados = false;
            }
            resultado.first();
            mostrarDatos();
        } catch (SQLException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_moverFirst

    private void moverLast(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moverLast
        try {
            btnAdd.setSelected(false);
            if (datosModificados == true) {
                modifyLineaBD();
                datosModificados = false;
            }
            resultado.last();
            mostrarDatos();
        } catch (SQLException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_moverLast

    private void modificarDatos(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_modificarDatos

        if (btnAdd.isSelected() == false) {
            datosModificados = true;
        }

    }//GEN-LAST:event_modificarDatos

    private void borrarEntrada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarEntrada
        int borrar = JOptionPane.showConfirmDialog(this, "¿Desea borrar el contacto " + txfCuenta.getText() + "?", "Borrar contacto", YES_NO_OPTION);
        if (borrar == YES_OPTION) {
            try {
                resultado.deleteRow();
                if (resultado.isBeforeFirst()) {
                    resultado.first();
                }
                mostrarDatos();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_borrarEntrada
    int cAdd = 0;
    private void addEntrada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEntrada
        cAdd++;
        if (btnAdd.isSelected() && cAdd == 1) {//esta pulsado 
            txfCuenta.setText("");
            txfActiva.setText("");
            txfID.setText("");
            txfClave.setText("");
            txfCuenta.requestFocus();
            btnDelete.setEnabled(false);
            btnFirst.setEnabled(false);
            btnNext.setEnabled(false);
            btnPrevious.setEnabled(false);
            btnLast.setEnabled(false);
            btnAnadir.setVisible(true);
            btnAnadir.setEnabled(true);

        } else {//no esta pulsado 
            writeLineaBD();
            cAdd = 0;
            btnDelete.setEnabled(true);
            btnFirst.setEnabled(true);
            btnNext.setEnabled(true);
            btnPrevious.setEnabled(true);
            btnLast.setEnabled(true);
            btnAnadir.setVisible(false);
            btnAnadir.setEnabled(false);
            initBaseDatos();

        }

    }//GEN-LAST:event_addEntrada

    private void btnAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnadirActionPerformed
        writeLineaBD();
        cAdd = 0;
        btnDelete.setEnabled(true);
        btnFirst.setEnabled(true);
        btnNext.setEnabled(true);
        btnPrevious.setEnabled(true);
        btnLast.setEnabled(true);
        btnAnadir.setVisible(false);
        btnAnadir.setEnabled(false);
        initBaseDatos();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAnadirActionPerformed

    private void txfClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfClaveActionPerformed

    private void txfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIDActionPerformed

    private void txfCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCuentaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCuentaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        admin.setVisible(true);
        admin.setAlwaysOnTop(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void writeLineaBD() {
        Connection conexion = Conexion.mySQL("cajero", "root", "");
        if (conexion != null) {
            try { //Añadir filas a la table utilizando el objeto ResultSet 
                resultado.moveToInsertRow();
                int id_cuenta = Integer.parseInt(txfCuenta.getText());
                int activa = Integer.parseInt(txfActiva.getText());
                int id = Integer.parseInt(txfID.getText());
                int clave = Integer.parseInt(txfClave.getText());
                Statement sentenciaMovimiento = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                sentenciaMovimiento.executeUpdate("INSERT INTO tarjeta(id_cuenta, activa, id, clave ) values('" + id_cuenta + "','" + activa + "','" + id + "','" + clave + "')");
                lblRespuesta.setText("Operacion realizada con exito!");
            } catch (SQLException ex) {
                lblRespuesta.setText("Error! Asegurate de introducir bien los datos.");
            }
        }
    }

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
            java.util.logging.Logger.getLogger(Tarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tarjeta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAdd;
    private javax.swing.JButton btnAnadir;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrevious;
    private javax.swing.JLabel fecha;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblRespuesta;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JTextField txfActiva;
    private javax.swing.JTextField txfClave;
    private javax.swing.JTextField txfCuenta;
    private javax.swing.JTextField txfID;
    // End of variables declaration//GEN-END:variables

    private void initBaseDatos() {
        Connection conexion = Conexion.mySQL("cajero", "root", "");
        if (conexion != null) {

            try {
                sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM tarjeta";
                resultado = sentencia.executeQuery(sql);
                resultado.first();
                mostrarDatos();
            } catch (SQLException ex) {
                Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "No está conectado con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

    private void mostrarDatos() throws ParseException {
        try {

            txfCuenta.setText(resultado.getInt("id_cuenta") + "");
            txfActiva.setText(resultado.getInt("activa") + "");
            txfID.setText(resultado.getInt("id") + "");
            txfClave.setText(resultado.getInt("clave") + "");
        } catch (SQLException ex) {
            txfCuenta.setText("Error");
            txfActiva.setText("Error");
            txfID.setText("Error");
            txfClave.setText("Error");
        }

    }

    private void modifyLineaBD() {
        try {
            resultado.updateInt("id_cuenta", Integer.parseInt(txfCuenta.getText()));
            try {
                int activa = Integer.parseInt(txfActiva.getText());
                resultado.updateInt("activa", activa);
                int telMovil = Integer.parseInt((txfClave.getText()));
                resultado.updateRow();
            } catch (NumberFormatException e) {
                lblRespuesta.setText("Error! Asegurate de modificar los campos correctos.");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Tarjeta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
