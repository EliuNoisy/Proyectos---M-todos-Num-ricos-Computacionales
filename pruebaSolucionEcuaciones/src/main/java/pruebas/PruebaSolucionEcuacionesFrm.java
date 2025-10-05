
package pruebas;

import implementaciones.SolucionEcuaciones;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PruebaSolucionEcuacionesFrm extends javax.swing.JFrame {

    // Variables de instancia
    private JTextField[][] txtMatriz;
    private int tamanioActual = 0;
    private SolucionEcuaciones solucion;

    public PruebaSolucionEcuacionesFrm() {
        initComponents();
        solucion = new SolucionEcuaciones();
        txtResultado.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtResultado.setEditable(false);
    }
    
    /**
     * Crea la matriz de entrada de forma dinamica
     */
    private void crearMatriz() {
        try {
            int n = (Integer) spnTamano.getValue();
            tamanioActual = n;
            
            pnlMatriz.removeAll();
            pnlMatriz.setLayout(new GridLayout(n, n + 2, 5, 5));
            
            txtMatriz = new JTextField[n][n + 1];
            
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    txtMatriz[i][j] = new JTextField("0.0");
                    txtMatriz[i][j].setHorizontalAlignment(JTextField.CENTER);
                    txtMatriz[i][j].setFont(new Font("Monospaced", Font.PLAIN, 14));
                    pnlMatriz.add(txtMatriz[i][j]);
                    
                    if (j == n - 1) {
                        JLabel lblSeparador = new JLabel("|");
                        lblSeparador.setHorizontalAlignment(JLabel.CENTER);
                        lblSeparador.setFont(new Font("Arial", Font.BOLD, 20));
                        pnlMatriz.add(lblSeparador);
                    }
                }
            }
            
            pnlMatriz.revalidate();
            pnlMatriz.repaint();
            
            txtResultado.setText("Matriz de " + n + "x" + n + " creada\nIngrese los coeficientes del sistema\n");
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Error al crear la matriz: " + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Lee los valores de la matriz desde los campos de texto
     */
    private double[][] leerMatriz() {
        int n = tamanioActual;
        double[][] a = new double[n][n + 1];
        
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    String texto = txtMatriz[i][j].getText().trim();
                    a[i][j] = Double.parseDouble(texto);
                }
            }
            return a;
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Error: Ingrese solo valores numericos validos",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /**
     * Resuelve el sistema usando el metodo seleccionado
     */
    private void resolverSistema() {
        if (tamanioActual == 0) {
            JOptionPane.showMessageDialog(this,
                "Primero debe crear la matriz",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        double[][] matrizOriginal = leerMatriz();
        if (matrizOriginal == null) {
            return;
        }
        
        double[][] matriz = solucion.copiarMatriz(matrizOriginal);
        String metodo = (String) cmbMetodo.getSelectedItem();
        
        txtResultado.setText("");
        txtResultado.append("=== SISTEMA DE ECUACIONES ===\n\n");
        txtResultado.append(solucion.despliegaMatrizAmpliada(matrizOriginal));
        
        double[] x;
        
        try {
            if (metodo.equals("Eliminacion de Gauss")) {
                txtResultado.append("\n=== METODO: ELIMINACION DE GAUSS CON PIVOTEO ===\n\n");
                x = solucion.eliminacionGauss(matriz);
                
            } else {
                txtResultado.append("\n=== METODO: GAUSS-JORDAN CON PIVOTEO ===\n\n");
                x = solucion.gaussJordan(matriz);
            }
            
            txtResultado.append("Matriz despues del proceso:\n");
            txtResultado.append(solucion.despliegaMatrizAmpliada(matriz));
            
            txtResultado.append("\n" + solucion.despliegaSolucion(x));
            
            txtResultado.setCaretPosition(0);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error al resolver el sistema:\n" + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Limpia todos los campos de texto
     */
    private void limpiar() {
        if (txtMatriz != null) {
            for (int i = 0; i < tamanioActual; i++) {
                for (int j = 0; j <= tamanioActual; j++) {
                    txtMatriz[i][j].setText("0.0");
                }
            }
        }
        txtResultado.setText("");
    }
    

    

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblMetodo = new javax.swing.JLabel();
        spnTamano = new javax.swing.JSpinner();
        btnCrearMatriz = new javax.swing.JButton();
        pnlMatriz = new javax.swing.JPanel();
        lblTamano1 = new javax.swing.JLabel();
        cmbMetodo = new javax.swing.JComboBox<>();
        btnResolver = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        scrollResultado = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Solucion de Sistemas de Ecuaciones");

        lblMetodo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMetodo.setText("Seleccione el metodo:");

        spnTamano.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        spnTamano.setModel(new javax.swing.SpinnerNumberModel(2, 2, 10, 1));

        btnCrearMatriz.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrearMatriz.setText("Crear Matriz");
        btnCrearMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMatrizActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMatrizLayout = new javax.swing.GroupLayout(pnlMatriz);
        pnlMatriz.setLayout(pnlMatrizLayout);
        pnlMatrizLayout.setHorizontalGroup(
            pnlMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        pnlMatrizLayout.setVerticalGroup(
            pnlMatrizLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );

        lblTamano1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTamano1.setText("Tamaño del sistema (n):");

        cmbMetodo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eliminacion de Gauss", "Gauss-Jordan" }));

        btnResolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnResolver.setText("Resolver Sistema");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        scrollResultado.setViewportView(txtResultado);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(lblTitulo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(lblTamano1)
                        .addGap(18, 18, 18)
                        .addComponent(spnTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(btnCrearMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(pnlMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(261, 261, 261)
                        .addComponent(btnResolver)
                        .addGap(50, 50, 50)
                        .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblMetodo)
                                .addGap(27, 27, 27)
                                .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearMatriz)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTamano1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetodo)
                    .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(scrollResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearMatrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearMatrizActionPerformed
        try {
        // Obtener el tamano del sistema desde el spinner
        int n = (Integer) spnTamano.getValue();
        tamanioActual = n;

        // Limpiar el panel y configurar el layout
        pnlMatriz.removeAll();
        pnlMatriz.setLayout(new GridLayout(n, n + 2, 5, 5));

        // Crear el arreglo de campos de texto
        txtMatriz = new JTextField[n][n + 1];

        // Crear los campos de texto para cada elemento de la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                txtMatriz[i][j] = new JTextField("0.0");
                txtMatriz[i][j].setHorizontalAlignment(JTextField.CENTER);
                txtMatriz[i][j].setFont(new Font("Monospaced", Font.PLAIN, 14));
                pnlMatriz.add(txtMatriz[i][j]);

                // Agregar separador visual antes de la ultima columna
                if (j == n - 1) {
                    JLabel lblSeparador = new JLabel("|");
                    lblSeparador.setHorizontalAlignment(JLabel.CENTER);
                    lblSeparador.setFont(new Font("Arial", Font.BOLD, 20));
                    pnlMatriz.add(lblSeparador);
                }
            }
        }

        // Actualizar la vista del panel
        pnlMatriz.revalidate();
        pnlMatriz.repaint();

        // Mostrar mensaje de confirmacion
        txtResultado.setText("Matriz de " + n + "x" + n + " creada\nIngrese los coeficientes del sistema\n");

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, 
            "Error al crear la matriz: " + ex.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }
                          
    }//GEN-LAST:event_btnCrearMatrizActionPerformed

    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
                // Verificar que la matriz haya sido creada
        if (tamanioActual == 0) {
            JOptionPane.showMessageDialog(this,
                "Primero debe crear la matriz",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Leer los valores de la matriz desde los campos de texto
        int n = tamanioActual;
        double[][] matrizOriginal = new double[n][n + 1];

        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    String texto = txtMatriz[i][j].getText().trim();
                    matrizOriginal[i][j] = Double.parseDouble(texto);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                "Error: Ingrese solo valores numericos validos",
                "Error de formato", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Copiar la matriz para no modificar la original
        double[][] matriz = solucion.copiarMatriz(matrizOriginal);
        String metodo = (String) cmbMetodo.getSelectedItem();

        // Limpiar el area de resultados
        txtResultado.setText("");
        txtResultado.append("=== SISTEMA DE ECUACIONES ===\n\n");
        txtResultado.append(solucion.despliegaMatrizAmpliada(matrizOriginal));

        double[] x;

        try {
            // Aplicar el metodo seleccionado
            if (metodo.equals("Eliminacion de Gauss")) {
                txtResultado.append("\n=== METODO: ELIMINACION DE GAUSS CON PIVOTEO ===\n\n");
                x = solucion.eliminacionGauss(matriz);

            } else {
                txtResultado.append("\n=== METODO: GAUSS-JORDAN CON PIVOTEO ===\n\n");
                x = solucion.gaussJordan(matriz);
            }

            // Mostrar la matriz despues del proceso
            txtResultado.append("Matriz despues del proceso:\n");
            txtResultado.append(solucion.despliegaMatrizAmpliada(matriz));

            // Mostrar la solucion del sistema
            txtResultado.append("\n" + solucion.despliegaSolucion(x));

            // Mover el scroll al inicio
            txtResultado.setCaretPosition(0);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error al resolver el sistema:\n" + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
                        
    }//GEN-LAST:event_btnResolverActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
         if (txtMatriz != null) {
        for (int i = 0; i < tamanioActual; i++) {
            for (int j = 0; j <= tamanioActual; j++) {
                txtMatriz[i][j].setText("0.0");
            }
        }
    }
    txtResultado.setText("");

    }//GEN-LAST:event_btnLimpiarActionPerformed

  
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
            java.util.logging.Logger.getLogger(PruebaSolucionEcuacionesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaSolucionEcuacionesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaSolucionEcuacionesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaSolucionEcuacionesFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaSolucionEcuacionesFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMatriz;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JComboBox<String> cmbMetodo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblMetodo;
    private javax.swing.JLabel lblTamano1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlMatriz;
    private javax.swing.JScrollPane scrollResultado;
    private javax.swing.JSpinner spnTamano;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
