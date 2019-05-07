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
import java.awt.Color;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bboyd
 */
public class Movimientos extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Movimientos(PanelUsuario panelUsuario) {
        initComponents();

        ventanas();
        this.panelUsuario = panelUsuario;
        tabla.setVisible(false);
        tabla.setEnabled(false);
        this.setTitle("Movimientos");
    }

    public void vereMovimientos() {
        tabla.setVisible(true);
    }

    //* iniciar ventanas y botones 
    private void ventanas() {
        this.setSize(807, 740);//tamaño del jFrame
        this.setLocationRelativeTo(null); //jframe al centro
        lblTarjetaInsertada.setVisible(false); //este label se muestra cuando insertamos la tarjeta

    }
    //este metodo crea un frame con las opciones de validar la tarjeta del usuario

    //metodo para el boton con la tarjeta
    //Iniciar la base
    private void mostrarMovimientos(int opcion) {

        if (conexion != null) {
            try {
                sentencia = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                String sql = "SELECT * FROM movimientos where id_cuenta='" + panelUsuario.principal.cuentaValida + "'";
                resultado = sentencia.executeQuery(sql);

                modelo = (DefaultTableModel) this.tabla.getModel();
                while (resultado.next()) {
                    Date fecha = resultado.getDate("fecha");
                    int saldo = resultado.getInt("saldo");
                    int diferencia = resultado.getInt("diferencia");
                    int positivo_negativo = resultado.getInt("positivo_negativo");
                    switch (opcion) {
                        case 1:
                            if (positivo_negativo == 1) {
                                Object[] nuevaFila = {fecha, diferencia, saldo};
                                modelo.addRow(nuevaFila);
                            } else {
                                Object[] nuevaFila = {fecha, "-" + diferencia, saldo};
                                modelo.addRow(nuevaFila);
                            }
                            break;
                        case 2:
                            if (positivo_negativo == 1) {
                                Object[] nuevaFila = {fecha, diferencia, saldo};
                                modelo.addRow(nuevaFila);
                            }
                            break;
                        case 3:
                            if (positivo_negativo == 0) {
                                Object[] nuevaFila = {fecha, "-" + diferencia, saldo};
                                modelo.addRow(nuevaFila);
                            }
                            break;
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(Movimientos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "No está conectado con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

    public void limpiarTabla() {
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
    }

    //* Cerrando base de datos
    private void cerrarBD(java.awt.event.WindowEvent evt) {
        try {
            System.out.println("Cerrando la base de datos...");
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Movimientos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void OcultarFiltros() {
        lblRetiros.setVisible(false);
        lblTodos.setVisible(false);
        lblIngresos.setVisible(false);
        lblFondo.setVisible(false);
        tabla.setVisible(true);
        btnTodos.setEnabled(false);
        btnIngresos.setEnabled(false);
        btnRetiros.setEnabled(false);
    }

    private void verFiltros() {
        lblRetiros.setVisible(true);
        lblTodos.setVisible(true);
        lblIngresos.setVisible(true);
        lblFondo.setVisible(true);
        tabla.setVisible(false);
        btnTodos.setEnabled(true);
        btnIngresos.setEnabled(true);
        btnRetiros.setEnabled(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblConsultas = new javax.swing.JLabel();
        lblRetiros = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();
        lblIngresos = new javax.swing.JLabel();
        lblTodos = new javax.swing.JLabel();
        lblAtras = new javax.swing.JLabel();
        lblFondo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        lblFondo1 = new javax.swing.JLabel();
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
        btnIngresos = new javax.swing.JButton();
        btnRetiros = new javax.swing.JButton();
        btnTodos = new javax.swing.JButton();
        btnFiltros = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        lblFondoPng = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        lblConsultas.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        lblConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblConsultas.setText("MOVIMIENTOS");
        getContentPane().add(lblConsultas);
        lblConsultas.setBounds(110, 60, 280, 40);

        lblRetiros.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblRetiros.setForeground(new java.awt.Color(255, 51, 0));
        lblRetiros.setText("<----  RETIROS");
        getContentPane().add(lblRetiros);
        lblRetiros.setBounds(100, 220, 190, 30);

        lblFiltro.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblFiltro.setForeground(new java.awt.Color(255, 255, 255));
        lblFiltro.setText("FILTRO---->");
        getContentPane().add(lblFiltro);
        lblFiltro.setBounds(320, 270, 120, 30);

        lblIngresos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblIngresos.setForeground(new java.awt.Color(51, 255, 0));
        lblIngresos.setText("<----  INGRESOS");
        getContentPane().add(lblIngresos);
        lblIngresos.setBounds(100, 160, 190, 30);

        lblTodos.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblTodos.setForeground(new java.awt.Color(255, 255, 0));
        lblTodos.setText("<----  TODOS");
        getContentPane().add(lblTodos);
        lblTodos.setBounds(100, 110, 190, 30);

        lblAtras.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblAtras.setForeground(new java.awt.Color(255, 255, 255));
        lblAtras.setText("<----  ATRAS");
        getContentPane().add(lblAtras);
        lblAtras.setBounds(100, 270, 190, 30);

        lblFondo.setBackground(new java.awt.Color(0, 102, 102));
        lblFondo.setOpaque(true);
        getContentPane().add(lblFondo);
        lblFondo.setBounds(90, 60, 350, 290);

        tabla.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.MatteBorder(null), new javax.swing.border.MatteBorder(null)));
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Fecha", "Cantidad", "Saldo"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 100, 330, 170);

        lblFondo1.setBackground(new java.awt.Color(255, 255, 255));
        lblFondo1.setOpaque(true);
        getContentPane().add(lblFondo1);
        lblFondo1.setBounds(90, 60, 350, 290);

        pnlBotones.setBackground(new java.awt.Color(0, 102, 0));
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

        btnIngresos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresosActionPerformed(evt);
            }
        });
        getContentPane().add(btnIngresos);
        btnIngresos.setBounds(40, 160, 50, 40);

        btnRetiros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRetiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirosActionPerformed(evt);
            }
        });
        getContentPane().add(btnRetiros);
        btnRetiros.setBounds(40, 210, 50, 40);

        btnTodos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });
        getContentPane().add(btnTodos);
        btnTodos.setBounds(40, 110, 50, 40);

        btnFiltros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrosActionPerformed(evt);
            }
        });
        getContentPane().add(btnFiltros);
        btnFiltros.setBounds(440, 260, 50, 40);

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
        goPanelUsuario();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrosActionPerformed
        try {
            limpiarTabla();
            verFiltros();
            lblFondo1.setBackground(Color.yellow);
            lblAtras.setForeground(Color.white);
            lblFiltro.setForeground(Color.white);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnFiltrosActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed

        OcultarFiltros();
        mostrarMovimientos(1);
        lblFondo1.setBackground(Color.yellow);
        lblAtras.setForeground(Color.cyan);
        lblFiltro.setForeground(Color.cyan);
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresosActionPerformed
        OcultarFiltros();
        mostrarMovimientos(2);
        lblFondo1.setBackground(Color.green);
    }//GEN-LAST:event_btnIngresosActionPerformed

    private void btnRetirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirosActionPerformed
        OcultarFiltros();
        mostrarMovimientos(3);
        lblFondo1.setBackground(Color.red);
        lblAtras.setForeground(Color.black);
        lblFiltro.setForeground(Color.black);
    }//GEN-LAST:event_btnRetirosActionPerformed

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
            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Movimientos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnFiltros;
    private javax.swing.JButton btnIngresos;
    private javax.swing.JButton btnRetiros;
    private javax.swing.JButton btnTodos;
    private javax.swing.JButton fasdf;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAtras;
    private javax.swing.JLabel lblConsultas;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFondo1;
    private javax.swing.JLabel lblFondoPng;
    private javax.swing.JLabel lblIngresos;
    private javax.swing.JLabel lblRetiros;
    private javax.swing.JLabel lblTarjetaInsertada;
    private javax.swing.JLabel lblTodos;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
 //VARIABLES GLOBALES o DE CLASE:
    public int saldo = 0;

    private DefaultTableModel modelo;
    private int filas = 0;
    private Connection conexion = Conexion.mySQL("cajero", "root", "");
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
