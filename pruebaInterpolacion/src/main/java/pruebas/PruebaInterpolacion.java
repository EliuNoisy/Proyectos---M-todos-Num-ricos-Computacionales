
package pruebas;

import implementaciones.Interpolacion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PruebaInterpolacion extends javax.swing.JFrame {


    public PruebaInterpolacion() {
        initComponents();
        setLocationRelativeTo(null); 
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        btnCrearTabla = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        scrollTabla = new javax.swing.JScrollPane();
        tblPuntos = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtX = new javax.swing.JTextField();
        btnInterpolacion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        scrollResultados = new javax.swing.JScrollPane();
        txtResultados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Interpolación de Lagrange   ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Configuracion");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Grado del polinomio (n):");

        txtGrado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnCrearTabla.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrearTabla.setText("Crear Tabla");
        btnCrearTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTablaActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLimpiar.setText("Limpiar Tabla");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Puntos de Interpolación (Ingrese n+1 puntos)");

        tblPuntos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "X", "Y"
            }
        ));
        scrollTabla.setViewportView(tblPuntos);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setText("Resultados ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Valor de X a interpolar:");

        txtX.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        btnInterpolacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnInterpolacion.setText("Calcular f(x)");
        btnInterpolacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInterpolacionActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setText("Calcular Interpolación");

        txtResultados.setColumns(20);
        txtResultados.setRows(5);
        scrollResultados.setViewportView(txtResultados);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(202, 202, 202))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnInterpolacion))
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrearTabla)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimpiar))
                    .addComponent(scrollTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addComponent(scrollResultados))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCrearTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInterpolacion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTablaActionPerformed
         try {
        // Obtiene el grado del polinomio del campo de texto
        int n = Integer.parseInt(txtGrado.getText().trim());
        
        // Revisa que el grado sea mayor o igual a 1
        if (n < 1) {
            JOptionPane.showMessageDialog(this, 
                "El grado debe ser mayor o igual a 1", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Borra todos los datos de la tabla anterior
        DefaultTableModel modelo = (DefaultTableModel) tblPuntos.getModel();
        modelo.setRowCount(0);
        
        // Crea n mas 1 filas vacias en la tabla para los puntos
        for (int i = 0; i <= n; i++) {
            modelo.addRow(new Object[]{"0.0", "0.0"});
        }
        
        // Activa el boton de calcular interpolacion
        btnInterpolacion.setEnabled(true);
        
        // Desactiva el campo de grado para que no se pueda cambiar
        txtGrado.setEnabled(false);
        
        // Muestra mensaje de exito e instrucciones en el area de resultados
        txtResultados.setText("✓ Tabla creada exitosamente.\n\n");
        txtResultados.append("Instrucciones:\n");
        txtResultados.append("1. Ingrese " + (n + 1) + " puntos en la tabla\n");
        txtResultados.append("2. Ingrese el valor de X a interpolar\n");
        txtResultados.append("3. Presione 'Calcular f(x)'\n");
        
    } catch (NumberFormatException ex) {
        // Muestra error si no se ingreso un numero valido
        JOptionPane.showMessageDialog(this, 
            "Ingrese un numero entero valido para el grado", 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCrearTablaActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
    // Borra el texto del campo de grado
    txtGrado.setText("");
    txtGrado.setEnabled(true);
    
    // Borra el texto del campo de X
    txtX.setText("");
    
    // Borra todas las filas de la tabla
    DefaultTableModel modelo = (DefaultTableModel) tblPuntos.getModel();
    modelo.setRowCount(0);
    
    // Borra el texto del area de resultados
    txtResultados.setText("");
    
    // Desactiva el boton de calcular interpolacion
    btnInterpolacion.setEnabled(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnInterpolacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInterpolacionActionPerformed
       try {
        // Obtiene el grado del polinomio
        int n = Integer.parseInt(txtGrado.getText().trim());
        
        // Obtiene el valor de X donde vamos a interpolar
        double x = Double.parseDouble(txtX.getText().trim());
        
        // Crea un arreglo para guardar los puntos de la tabla
        double[][] puntos = new double[n + 1][2];
        DefaultTableModel modelo = (DefaultTableModel) tblPuntos.getModel();
        
        // Lee todos los puntos de la tabla y los guarda en el arreglo
        for (int i = 0; i <= n; i++) {
            puntos[i][0] = Double.parseDouble(modelo.getValueAt(i, 0).toString());
            puntos[i][1] = Double.parseDouble(modelo.getValueAt(i, 1).toString());
        }
        
        // Llama al metodo que calcula la interpolacion de Lagrange
        double y = Interpolacion.interpolacionLagrange(puntos, n, x);
        
        // Construye el texto con todos los resultados
        StringBuilder resultado = new StringBuilder();
        resultado.append("═══════════════════════════════════════════════\n");
        resultado.append("       INTERPOLACION DE LAGRANGE\n");
        resultado.append("═══════════════════════════════════════════════\n\n");
        resultado.append("Grado del polinomio: n = ").append(n).append("\n\n");
        resultado.append("Puntos utilizados:\n\n");
        resultado.append(Interpolacion.despliegaPuntos(puntos, n));
        resultado.append("\n");
        resultado.append("Punto interpolado:\n");
        resultado.append("--------------------------------\n");
        resultado.append(String.format("  x = %.6f\n", x));
        resultado.append(String.format("  y = %.6f\n", y));
        resultado.append("--------------------------------\n\n");
        resultado.append(String.format("∴ f(%.6f) = %.6f\n", x, y));
        resultado.append("\n═══════════════════════════════════════════════\n");
        
        // Muestra los resultados en el area de texto
        txtResultados.setText(resultado.toString());
        
    } catch (NumberFormatException ex) {
        // Muestra error si hay numeros invalidos
        JOptionPane.showMessageDialog(this, 
            "Verifique que todos los valores sean numeros validos", 
            "Error en los datos", 
            JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        // Muestra cualquier otro error que ocurra
        JOptionPane.showMessageDialog(this, 
            "Error al calcular: " + ex.getMessage(), 
            "Error", 
            JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnInterpolacionActionPerformed

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
            java.util.logging.Logger.getLogger(PruebaInterpolacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaInterpolacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaInterpolacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaInterpolacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaInterpolacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearTabla;
    private javax.swing.JButton btnInterpolacion;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollResultados;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JTable tblPuntos;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextArea txtResultados;
    private javax.swing.JTextField txtX;
    // End of variables declaration//GEN-END:variables
}
