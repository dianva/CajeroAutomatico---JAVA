/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cajeroautomaticodian;

import administrador.Admin;
import tarjeta.Tarjeta;
import usuario.PanelUsuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author bboyd
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        initBaseDatos();
        ventanas();
        this.setTitle("Principal");

    }

    public int dineroEnCajero() {

        try {

            ResultSet rs = null;

            Statement sentencia = conexion.createStatement();

            String sql = "SELECT * FROM cajero";
            rs = sentencia.executeQuery(sql);
            rs.first();
            dineroEnCajero = rs.getInt("dinero");

            System.out.println(dineroEnCajero);
        } catch (SQLException ex) {
            System.out.println("Error");
        }

        return dineroEnCajero;
    }

    public void IngresarDineroEnCajero(int ingreso, int dineroEnCajero) {
        int total = ingreso + dineroEnCajero;

        if (conexion != null) {
            try {
                ResultSet rs = null;
                Statement sentencia = conexion.createStatement();
                String sql = "UPDATE `cajero` SET `dinero`='" + total + "'";
                PreparedStatement pst = conexion.prepareStatement(sql);
                int retorno = pst.executeUpdate();
                JOptionPane.showMessageDialog(null, +ingreso + ".00€ ingresados en el cajero.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR" + e);
            }
        }
    }

    public void RetirarDineroDelCajero(int retiro, int dineroEnCajero) {
        if (retiro > dineroEnCajero) {
            JOptionPane.showMessageDialog(null, "El cajero no dispone con tanto dinero.");
        } else {
            int total = dineroEnCajero - retiro;

            if (conexion != null) {
                try {
                    ResultSet rs = null;
                    Statement sentencia = conexion.createStatement();
                    String sql = "UPDATE `cajero` SET `dinero`='" + total + "'";
                    PreparedStatement pst = conexion.prepareStatement(sql);
                    int retorno = pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, retiro + ".00 € retirados del cajero");
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ERROR" + e);
                }
            }
        }
    }

    //* iniciar ventanas y botones 
    private void ventanas() {
        this.setSize(807, 740);//tamaño del jFrame
        this.setLocationRelativeTo(null); //jframe al centro
        lblTarjetaInsertada.setVisible(false); //este label se muestra cuando insertamos la tarjeta
        txfText.setEnabled(false);
    }

    //este metodo crea un frame con las opciones de validar la tarjeta del usuario
    public void abrirVentanaTarjeta() {
        // abre el frame que esta en el package de usuario (antes importado)
        abrirPanelTarjeta.setVisible(true);

    }

    public void abrirPanelUsuario() {

        abrirPanelUsuario.setVisible(true);
        this.setVisible(false);
    }

    public void quitarEnable() {
        this.setEnabled(false);
    }

    /*public static void quitarDisable(){
    Principal.setEnabled(true);
    }*/
    //metodo para el boton con la tarjeta
    public void insertarTarjeta() {

        tarjeta++;
        if (tarjeta == 1) {
            btnTarjeta.setIcon(null);
            lblInsertCard.setText("INTRODUCE EL CODIGO");
            lblTarjetaInsertada.setVisible(true);
            abrirVentanaTarjeta();
            this.setEnabled(false);

        } else {
            lblTarjetaInsertada.setVisible(false);
            lblInsertCard.setText("INSERTE SU TARJETA");
            btnTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/tarjeta_1.png")));
            lblBienvenidoGift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/bienvenido_2.gif")));
            tarjeta = 0;
        }
    }

    //El metodo me permite agregar nuevos movimientos a la hora de transferir, sacar o meter dinero
    public void insertarMovimiento(int diferencia, int positivo_negativo, int id_cuenta, int saldoActual) {
        Connection conexion = Conexion.mySQL("cajero", "root", "");
        if (conexion != null) {

            try {
                Statement sentenciaMovimiento = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
                /*String sql = "SELECT * FROM movimientos";
                ResultSet resultadoMovimiento = sentenciaMovimiento.executeQuery(sql);
                resultadoMovimiento.first();*/
                sentenciaMovimiento.executeUpdate("INSERT INTO movimientos(diferencia, positivo_negativo,id_cuenta,saldo) values('" + diferencia + "','" + positivo_negativo + "','" + id_cuenta + "','" + saldoActual + "')");
                System.out.println("Nuevo movimiento en la tabla movimientos.");
            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {

            System.exit(0);
        }

    }

    //Iniciar la base
    private void initBaseDatos() {
        Connection conexion = Conexion.mySQL("cajero", "root", "");
        if (conexion != null) {
        } else {
            JOptionPane.showMessageDialog(this, "No está conectado con la base de datos", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }

    }

    //* Cerrando base de datos
    public void cerrarBD(java.awt.event.WindowEvent evt) {
        try {
            System.out.println("Cerrando la base de datos...");
            conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void boton(java.awt.event.ActionEvent evt) {
        if (lblTarjetaInsertada.isVisible()) { //si la tarjeta esta insertada
            JButton boton = (JButton) evt.getSource();
            txfText.setText(txfText.getText() + boton.getText());
        }
    }

    private void botonAceptar() {
        int validarClave = Integer.parseInt(txfText.getText());
        conexion = Conexion.mySQL("cajero", "root", "");
        if (conexion != null) {
            System.out.println("Conexion realizada con éxito");

            try {
                ResultSet rs = null;
                int clave = 0;
                int cuentaActiva = 0;
                Statement sentencia = conexion.createStatement();
                String sql = "SELECT * FROM tarjeta where id_cuenta='" + cuentaValida + "' and clave='" + validarClave + "'";
                rs = sentencia.executeQuery(sql);
                rs.first();
                clave = rs.getInt("clave");
                cuentaActiva = rs.getInt("activa");
                System.out.println(clave);
                System.out.println(cuentaActiva);

                if (cuentaActiva == 1) {
                    estaActiva = false;
                } else {
                    estaActiva = true;
                }
                if (estaActiva == false) {
                    lblBienvenidoGift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/errorzaurio.gif")));
                    JOptionPane.showMessageDialog(txfText, "LA TARJETA ESTA BLOQUEADA");
                } else if (validarClave == clave) {
                    abrirPanelUsuario();
                }
            } catch (SQLException ex) {
                lblBienvenidoGift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/errorzaurio.gif")));
                JOptionPane.showMessageDialog(txfText, "PIN INCORRECTO");
                txfText.setText("");
            } catch (NumberFormatException ex) {
                lblBienvenidoGift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/errorzaurio.gif")));
                JOptionPane.showMessageDialog(txfText, "PIN INCORRECTO");
            }
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

        pnlBienvenido = new javax.swing.JPanel();
        txfText = new javax.swing.JTextField();
        lblBienvenidoGift = new javax.swing.JLabel();
        lblInsertCard = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
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
        btnTarjeta = new javax.swing.JButton();
        lblTarjetaInsertada = new javax.swing.JLabel();
        lblFondoPng = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        pnlBienvenido.setOpaque(false);
        pnlBienvenido.setLayout(null);

        txfText.setBackground(new java.awt.Color(255, 255, 204));
        txfText.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txfText.setForeground(new java.awt.Color(51, 51, 51));
        txfText.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        pnlBienvenido.add(txfText);
        txfText.setBounds(100, 260, 260, 30);

        lblBienvenidoGift.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/bienvenido_2.gif"))); // NOI18N
        pnlBienvenido.add(lblBienvenidoGift);
        lblBienvenidoGift.setBounds(70, 20, 330, 210);

        lblInsertCard.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lblInsertCard.setForeground(new java.awt.Color(255, 255, 255));
        lblInsertCard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInsertCard.setText("INSERTE SU TARJETA");
        pnlBienvenido.add(lblInsertCard);
        lblInsertCard.setBounds(100, 230, 260, 30);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlBienvenido.add(jButton1);
        jButton1.setBounds(410, 70, 50, 40);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setOpaque(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlBienvenido.add(jButton2);
        jButton2.setBounds(10, 70, 50, 40);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlBienvenido.add(jButton3);
        jButton3.setBounds(10, 120, 50, 40);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnlBienvenido.add(jButton4);
        jButton4.setBounds(10, 170, 50, 40);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        pnlBienvenido.add(jButton5);
        jButton5.setBounds(410, 120, 50, 40);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        pnlBienvenido.add(jButton6);
        jButton6.setBounds(410, 170, 50, 40);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setOpaque(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        pnlBienvenido.add(jButton7);
        jButton7.setBounds(410, 220, 50, 40);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setOpaque(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        pnlBienvenido.add(jButton8);
        jButton8.setBounds(10, 220, 50, 40);

        getContentPane().add(pnlBienvenido);
        pnlBienvenido.setBounds(30, 40, 470, 340);

        pnlBotones.setBackground(new java.awt.Color(255, 255, 204));
        pnlBotones.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 204), 3, true));
        pnlBotones.setForeground(new java.awt.Color(255, 255, 204));
        pnlBotones.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
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
        fasdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fasdfActionPerformed(evt);
            }
        });
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
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        pnlBotones.add(jButton17);
        jButton17.setBounds(240, 105, 100, 40);

        getContentPane().add(pnlBotones);
        pnlBotones.setBounds(80, 380, 370, 210);

        btnTarjeta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/tarjeta_1.png"))); // NOI18N
        btnTarjeta.setBorderPainted(false);
        btnTarjeta.setContentAreaFilled(false);
        btnTarjeta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTarjetaActionPerformed(evt);
            }
        });
        getContentPane().add(btnTarjeta);
        btnTarjeta.setBounds(540, 320, 200, 310);

        lblTarjetaInsertada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/tarjetaInsertada.png"))); // NOI18N
        lblTarjetaInsertada.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        getContentPane().add(lblTarjetaInsertada);
        lblTarjetaInsertada.setBounds(540, 320, 190, 30);

        lblFondoPng.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgPrincipal/principal.jpg"))); // NOI18N
        getContentPane().add(lblFondoPng);
        lblFondoPng.setBounds(0, 0, 790, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        boton(evt);
        /* if (lblTarjetaInsertada.isVisible()) { //si la tarjeta esta insertada
        boton(evt);
//txfText.setText(txfText.getText() + 1);
        }*/
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        boton(evt);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        boton(evt);
    }//GEN-LAST:event_btn3ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        boton(evt);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        boton(evt);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        boton(evt);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        boton(evt);
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        boton(evt);
    }//GEN-LAST:event_btn8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        boton(evt);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void btn0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn0ActionPerformed
        boton(evt);
    }//GEN-LAST:event_btn0ActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (lblTarjetaInsertada.isVisible()) { //si la tarjeta esta insertada
            txfText.setText("");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        if (lblTarjetaInsertada.isVisible()) { //si la tarjeta esta insertada
            botonAceptar();
            // abrirPanelUsuario();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTarjetaActionPerformed
        if (lblTarjetaInsertada.isVisible()) {
            System.exit(0);
        } else {
            insertarTarjeta();
        }
    }//GEN-LAST:event_btnTarjetaActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        goAdmin();
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        admin = admin + "A";
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        admin = admin + "D";
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        admin = admin + "M";
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        admin = admin + "I";
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        admin = admin + "N";
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        admin = "";        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        admin = "";     // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        admin = "";        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void fasdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fasdfActionPerformed
        admin = "";
    }//GEN-LAST:event_fasdfActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
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
    private javax.swing.JButton btnTarjeta;
    private javax.swing.JButton fasdf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel lblBienvenidoGift;
    private javax.swing.JLabel lblFondoPng;
    private javax.swing.JLabel lblInsertCard;
    private javax.swing.JLabel lblTarjetaInsertada;
    private javax.swing.JPanel pnlBienvenido;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JTextField txfText;
    // End of variables declaration//GEN-END:variables
 //VARIABLES GLOBALES o DE CLASE:
    public Statement sentenciaCajero;
    public static ResultSet resultadoCajero;
    public Statement sentenciaMovimiento;
    public static ResultSet resultadoMovimiento;
    public Connection conexion;
    private Statement sentencia;
    public final int POSITIVO = 1;
    public final int NEGATIVO = 0;
    private static ResultSet resultado;
    private boolean datosModificados = false;
    private Admin administrador = new Admin(this);
    private int tarjeta = 0; //variable que uso para el boton con la imagen de la tarjeta
    private Tarjeta abrirPanelTarjeta = new Tarjeta(this); //jframe tarjeta
    private PanelUsuario abrirPanelUsuario = new PanelUsuario(this); //jframe panelUsuario
    public int cuentaValida;
    private boolean estaActiva = true;
    public String admin = "";
    public int dineroEnCajero;

    private void goAdmin() {
        if (admin.equals("ADMIN")) {
            administrador.setVisible(true);
            this.setVisible(false);
        }
    }

}
