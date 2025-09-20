
package pruebas;

import javax.swing.JOptionPane;


public class FrmPruebaRaicesFunciones extends javax.swing.JFrame {


    public FrmPruebaRaicesFunciones() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblMetodo = new javax.swing.JLabel();
        cmbMetodo = new javax.swing.JComboBox<>();
        btnCalcular = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaIteraciones = new javax.swing.JTable();
        lblFuncion = new javax.swing.JLabel();
        cmbFuncion = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Metodos Numericos - Raices de Funciones");

        lblMetodo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMetodo.setText("Metodo");

        cmbMetodo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biseccion", "Regla Falsa" }));
        cmbMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMetodoActionPerformed(evt);
            }
        });

        btnCalcular.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCalcular.setText("Calcular");
        btnCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularActionPerformed(evt);
            }
        });

        tablaIteraciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Iteracion", "xi", "xf", "xr ", "f(xi)", "f(xf)", "f(xr)", "Error Aproximado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaIteraciones);

        lblFuncion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFuncion.setText("Funcion");

        cmbFuncion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cmbFuncion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "f(x) = 4x³ - 6x² + 7x - 2.3", "g(x) = x²√|cos(x)| - 5" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(360, 360, 360)
                        .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMetodo)
                    .addComponent(lblFuncion))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(218, 218, 218))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetodo)
                    .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFuncion)
                    .addComponent(cmbFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(btnCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
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

    private void cmbMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMetodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMetodoActionPerformed

    private void btnCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularActionPerformed
     try {
    // se crea una instancia de la clase con los metodos numericos
    implementaciones.RaicesFunciones rf = new implementaciones.RaicesFunciones();

    // se definen las dos funciones de la tarea
    java.util.function.DoubleUnaryOperator f = (x) -> 4*Math.pow(x,3) - 6*Math.pow(x,2) + 7*x - 2.3;
    java.util.function.DoubleUnaryOperator g = (x) -> Math.pow(x,2) * Math.sqrt(Math.abs(Math.cos(x))) - 5;

    // se obtiene lo que el usuario selecciono en los combos
    String funcion = (String)cmbFuncion.getSelectedItem();
    String metodo = (String)cmbMetodo.getSelectedItem();

    // se inicializan valores por defecto para los intervalos y el error
    double xi = 0, xf = 0, eamax = 0.0001;  
    java.util.List<Object[]> resultados = null;

    // se define el modelo de la tabla con los nombres de columnas
    javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
        new Object[]{"Iteracion", "Xi", "Xf", "Xr", "f(Xi)", "f(Xf)", "f(Xr)", "Error"}, 0);

    // Metodo biseccion
    if (metodo.equals("Biseccion") && funcion.startsWith("f(x)")) {
        // para la funcion f(x) se usa el intervalo [0,1]
        xi = 0.0; 
        xf = 1.0;
        resultados = rf.biseccionTabla(f, xi, xf, eamax);
    }
    else if (metodo.equals("Biseccion") && funcion.startsWith("g(x)")) {
        // para la funcion g(x) se usa el intervalo [-3,-2]
        xi = -3.0; 
        xf = -2.0;
        resultados = rf.biseccionTabla(g, xi, xf, eamax);
    }

    // Metodo regla falsa
    else if (metodo.equals("Regla Falsa") && funcion.startsWith("f(x)")) {
        // para la funcion f(x) se usa el intervalo [0,1]
        xi = 0.0; 
        xf = 1.0;
        resultados = rf.reglaFalsaTabla(f, xi, xf, eamax);
    }
    else if (metodo.equals("Regla Falsa") && funcion.startsWith("g(x)")) {
        // para la funcion g(x) se usa el intervalo [2,3]
        xi = 2.0; 
        xf = 3.0;
        resultados = rf.reglaFalsaTabla(g, xi, xf, eamax);
    }

    // se llena la tabla con los datos obtenidos en la lista de resultados
    if (resultados != null) {
        for (Object[] fila : resultados) {
            model.addRow(fila);
        }
        tablaIteraciones.setModel(model);
    } else {
        // si no hay resultados se muestra un mensaje
        JOptionPane.showMessageDialog(this, "No se pudieron calcular las iteraciones.");
    }

} catch (Exception ex) {
    // si ocurre algun error durante el calculo se avisa al usuario
    JOptionPane.showMessageDialog(this, 
        "Error en el calculo: " + ex.getMessage());
}



    }//GEN-LAST:event_btnCalcularActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFunciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPruebaRaicesFunciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcular;
    private javax.swing.JComboBox<String> cmbFuncion;
    private javax.swing.JComboBox<String> cmbMetodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFuncion;
    private javax.swing.JLabel lblMetodo;
    private javax.swing.JTable tablaIteraciones;
    // End of variables declaration//GEN-END:variables
}
