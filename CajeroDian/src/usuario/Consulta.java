/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package usuario;

import cajeroautomaticodian.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import cajeroautomaticodian.Principal;

/**
 *
 * @author bboyd
 */
public class Consulta extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Consulta(PanelUsuario panelUsuario) {
        initComponents();
        initBaseDatos();
        ventanas();
        this.setTitle("Consultar saldo");
        this.panelUsuario = panelUsuario;
    }

    public void verSaldo() {
        Connection conexion = null;
        conexion = Conexion.mySQL("cajero", "root", "");
        if (conexion != null) {
           
//Paso 2: Ejecutar una consulta
            try {
                ResultSet rs = null;
                Statement sentencia = conexion.createStatement();
                String sql = "SELECT saldo FROM cuenta where num_cuenta='" + panelUsuario.principal.cuentaValida + "'"; //hacer un select pasando por las variables publicas que tengo en las frame previas
                rs = sentencia.executeQuery(sql);
//Paso 3: Extrayendo los datos del resultset
                while (rs.next()) {
                    //Recuperar datos por el nombre de la columna
                    saldo = rs.getInt("saldo");

//Ver valores
                    lblMostrar.setText("Saldo actual: " + saldo + "€");
                }
            } catch (SQLException ex) {
                System.out.println("Error");
            }
        }
    }

    //* iniciar ventanas y botones 
    private void ventanas() {
        this.setSize(807, 740);//tamaño del jFrame
        this.setLocationRelativeTo(null); //jframe al centro

    }
    //este metodo crea un frame con las opciones de validar la tarjeta del usuario

    //metodo para el boton con la tarjeta
    //Iniciar la base
    private void initBaseDatos() {
        Connection conexion = Conexion.mySQL("cajero", "root", "");

    }

    //* Cerrando base de datos
    private void cerrarBD(java.awt.event.WindowEvent evt) {
        try {
            System.out.println("Cerrando la base de datos...");
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Consulta.class.getName()).log(Level.SEVERE, null, ex);
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

        lblVerSaldo = new javax.swing.JLabel();
        lblVerSaldo1 = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        fasdf = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        btn0 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        lblTarjetaInsertada = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnVerSaldo = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        lblMostrar = new javax.swing.JLabel();
        lblConsultas = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblFondoPng = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblVerSaldo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblVerSaldo.setForeground(new java.awt.Color(255, 255, 0));
        lblVerSaldo.setText("<----  ATRAS");
        getContentPane().add(lblVerSaldo);
        lblVerSaldo.setBounds(100, 260, 190, 30);

        lblVerSaldo1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblVerSaldo1.setForeground(new java.awt.Color(255, 255, 0));
        lblVerSaldo1.setText("SALDO---->");
        getContentPane().add(lblVerSaldo1);
        lblVerSaldo1.setBounds(290, 260, 150, 30);

        pnlBotones.setBackground(new java.awt.Color(153, 153, 255));
        pnlBotones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 3, true));
        pnlBotones.setForeground(new java.awt.Color(255, 255, 204));
        pnlBotones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlBotones.setLayout(null);

        btn1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btn1.setText("1");
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        pnlBotones.add(btn1);
        btn1.setBounds(40, 15, 52, 40);

        btn2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btn2.setText("2");
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        pnlBotones.add(btn2);
        btn2.setBounds(100, 15, 52, 40);

        btn3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btn3.setText("3");
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        pnlBotones.add(btn3);
        btn3.setBounds(160, 15, 52, 40);

        btn4.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btn4.setText("4");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        pnlBotones.add(btn4);
        btn4.setBounds(40, 60, 52, 40);

        fasdf.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        pnlBotones.add(fasdf);
        fasdf.setBounds(240, 150, 100, 40);

        btn5.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btn5.setText("5");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        pnlBotones.add(btn5);
        btn5.setBounds(100, 60, 52, 40);

        btn6.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btn6.setText("6");
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        pnlBotones.add(btn6);
        btn6.setBounds(160, 60, 52, 40);

        btn7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btn7.setText("7");
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });
        pnlBotones.add(btn7);
        btn7.setBounds(40, 105, 52, 40);

        btn8.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btn8.setText("8");
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });
        pnlBotones.add(btn8);
        btn8.setBounds(100, 105, 52, 40);

        jButton9.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jButton9.setText("9");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        pnlBotones.add(jButton9);
        jButton9.setBounds(160, 105, 52, 40);

        jButton11.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        pnlBotones.add(jButton11);
        jButton11.setBounds(40, 150, 52, 40);

        btn0.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        btn0.setText("0");
        btn0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });
        pnlBotones.add(btn0);
        btn0.setBounds(100, 150, 52, 40);

        jButton13.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        pnlBotones.add(jButton13);
        jButton13.setBounds(160, 150, 52, 40);

        btnAceptar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnAceptar.setText("ACEPTAR");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnAceptar);
        btnAceptar.setBounds(240, 15, 100, 40);

        btnBorrar.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnBorrar.setText("BORRAR");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });
        pnlBotones.add(btnBorrar);
        btnBorrar.setBounds(240, 60, 100, 40);

        jButton17.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        pnlBotones.add(jButton17);
        jButton17.setBounds(240, 105, 100, 40);

        getContentPane().add(pnlBotones);
        pnlBotones.setBounds(80, 380, 370, 210);

        lblTarjetaInsertada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/tarjetaInsertada.png"))); // NOI18N
        lblTarjetaInsertada.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(lblTarjetaInsertada);
        lblTarjetaInsertada.setBounds(540, 320, 190, 30);
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 160, 50, 40);
        getContentPane().add(jButton2);
        jButton2.setBounds(40, 210, 50, 40);
        getContentPane().add(jButton3);
        jButton3.setBounds(40, 110, 50, 40);

        btnVerSaldo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerSaldoActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerSaldo);
        btnVerSaldo.setBounds(440, 260, 50, 40);

        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(40, 260, 50, 40);
        getContentPane().add(jButton6);
        jButton6.setBounds(440, 110, 50, 40);
        getContentPane().add(jButton7);
        jButton7.setBounds(440, 160, 50, 40);
        getContentPane().add(jButton8);
        jButton8.setBounds(440, 210, 50, 40);

        lblMostrar.setBackground(new java.awt.Color(255, 255, 255));
        lblMostrar.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblMostrar.setForeground(new java.awt.Color(255, 255, 0));
        getContentPane().add(lblMostrar);
        lblMostrar.setBounds(100, 310, 330, 50);

        lblConsultas.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblConsultas.setForeground(new java.awt.Color(255, 255, 0));
        lblConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConsultas.setText("CONSULTAR SALDO");
        getContentPane().add(lblConsultas);
        lblConsultas.setBounds(120, 70, 280, 30);

        jLabel1.setBackground(new java.awt.Color(255, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgDinero/manocontando.gif"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, 60, 340, 290);

        jLabel2.setBackground(new java.awt.Color(153, 153, 255));
        jLabel2.setForeground(new java.awt.Color(204, 204, 255));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 60, 350, 300);

        lblFondoPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/principal.jpg"))); // NOI18N
        getContentPane().add(lblFondoPng);
        lblFondoPng.setBounds(0, 0, 790, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed

    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed

    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed

    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed

    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed

    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed

    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed

    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed

    }//GEN-LAST:event_btn8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

    }//GEN-LAST:event_jButton9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed

    }//GEN-LAST:event_btn0ActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed

    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed

    }//GEN-LAST:event_btnAceptarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        lblMostrar.setText("");
        goPanelUsuario();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnVerSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerSaldoActionPerformed
        verSaldo();
    }//GEN-LAST:event_btnVerSaldoActionPerformed

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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn0;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnVerSaldo;
    private javax.swing.JButton fasdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblConsultas;
    private javax.swing.JLabel lblFondoPng;
    private javax.swing.JLabel lblMostrar;
    private javax.swing.JLabel lblTarjetaInsertada;
    private javax.swing.JLabel lblVerSaldo;
    private javax.swing.JLabel lblVerSaldo1;
    private javax.swing.JPanel pnlBotones;
    // End of variables declaration//GEN-END:variables
 //VARIABLES GLOBALES o DE CLASE:
    public int saldo = 0;
    private Connection conexion;
    private Statement sentencia;
    private ResultSet resultado;
    private boolean datosModificados = false;
    private int tarjeta = 0;
    private PanelUsuario panelUsuario;

    private void goPanelUsuario() {
        panelUsuario.setVisible(true);
        this.setVisible(false);
    }
}
