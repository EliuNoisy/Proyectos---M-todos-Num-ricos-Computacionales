
package pruebas;

import implementaciones.SolucionEcuaciones;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class PruebaSolucionEcuacionesFrmVersion2_1 extends javax.swing.JFrame {

    // Variables de instancia
    private JTextField[][] txtMatriz;
    private int tamanioActual = 0;
    private SolucionEcuaciones solucion;

    public PruebaSolucionEcuacionesFrmVersion2_1() {
        initComponents();
        setLocationRelativeTo(null);
        solucion = new SolucionEcuaciones();

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
    
     private void invertirMatriz() {
        int n = tamanioActual;
        double[][] matrizOriginal = new double[n][n];
        
        try {
            // Leer solo la matriz cuadrada (sin la columna aumentada)
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
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
        
        txtResultado.setText("");
        txtResultado.append("=== INVERSION DE MATRIZ ===\n\n");
        txtResultado.append("Matriz Original:\n");
        txtResultado.append(solucion.despliegaMatriz(matrizOriginal));
        
        try {
            txtResultado.append("\n=== METODO: GAUSS-JORDAN CON PIVOTEO ===\n\n");
            
            double[][] inversa = solucion.invierte(matrizOriginal);
            
            txtResultado.append("Matriz Inversa:\n");
            txtResultado.append(solucion.despliegaMatriz(inversa));
            
            // Verificacion: A * A^-1 debe dar la matriz identidad
            txtResultado.append("\nVerificacion (A * A^-1 = I):\n");
            double[][] verificacion = multiplicarMatrices(matrizOriginal, inversa);
            txtResultado.append(solucion.despliegaMatriz(verificacion));
            
            txtResultado.setCaretPosition(0);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error al invertir la matriz:\n" + ex.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Multiplica dos matrices cuadradas (para verificacion)
     */
    private double[][] multiplicarMatrices(double[][] a, double[][] b) {
        int n = a.length;
        double[][] resultado = new double[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                resultado[i][j] = 0.0;
                for (int k = 0; k < n; k++) {
                    resultado[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        
        return resultado;
    }
    

    

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        btnCrearMatriz = new javax.swing.JButton();
        spnTamano = new javax.swing.JSpinner();
        lblTamano1 = new javax.swing.JLabel();
        pnlMatriz = new javax.swing.JPanel();
        lblMetodo = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        cmbMetodo = new javax.swing.JComboBox<>();
        btnResolver = new javax.swing.JButton();
        scrollResultado = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTitulo.setText("Solucion de Sistemas de Ecuaciones");

        btnCrearMatriz.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrearMatriz.setText("Crear Matriz");
        btnCrearMatriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearMatrizActionPerformed(evt);
            }
        });

        spnTamano.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        spnTamano.setModel(new javax.swing.SpinnerNumberModel(2, 2, 25, 1));

        lblTamano1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTamano1.setText("Tamaño del sistema (n):");

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

        lblMetodo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMetodo.setText("Seleccione el metodo:");

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        cmbMetodo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Eliminacion de Gauss", "Gauss-Jordan", "Inversion de Matriz" }));

        btnResolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnResolver.setText("Resolver Sistema");
        btnResolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResolverActionPerformed(evt);
            }
        });

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        scrollResultado.setViewportView(txtResultado);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(lblTitulo))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblTamano1)
                                .addGap(18, 18, 18)
                                .addComponent(spnTamano, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(btnCrearMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(pnlMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(320, 320, 320)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblMetodo)
                                .addGap(27, 27, 27)
                                .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnResolver)
                                .addGap(50, 50, 50)
                                .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(185, 185, 185)
                        .addComponent(scrollResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCrearMatriz)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(spnTamano, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTamano1)))
                .addGap(18, 18, 18)
                .addComponent(pnlMatriz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetodo)
                    .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnResolver, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addComponent(scrollResultado, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
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

    private void btnResolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResolverActionPerformed
        // Verificar que la matriz haya sido creada
        // Verificar que la matriz haya sido creada
        if (tamanioActual == 0) {
            JOptionPane.showMessageDialog(this,
                "Primero debe crear la matriz",
                "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String metodo = (String) cmbMetodo.getSelectedItem();

        // Si se seleccionó "Inversion de Matriz"
        if (metodo.equals("Inversion de Matriz")) {
            invertirMatriz();
            return;
        }

        // Para los otros métodos (Gauss y Gauss-Jordan)
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

        double[][] matriz = solucion.copiarMatriz(matrizOriginal);

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

    }//GEN-LAST:event_btnResolverActionPerformed

  
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
            java.util.logging.Logger.getLogger(PruebaSolucionEcuacionesFrmVersion2_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PruebaSolucionEcuacionesFrmVersion2_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PruebaSolucionEcuacionesFrmVersion2_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PruebaSolucionEcuacionesFrmVersion2_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PruebaSolucionEcuacionesFrmVersion2_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearMatriz;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnResolver;
    private javax.swing.JComboBox<String> cmbMetodo;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMetodo;
    private javax.swing.JLabel lblTamano1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlMatriz;
    private javax.swing.JScrollPane scrollResultado;
    private javax.swing.JSpinner spnTamano;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
