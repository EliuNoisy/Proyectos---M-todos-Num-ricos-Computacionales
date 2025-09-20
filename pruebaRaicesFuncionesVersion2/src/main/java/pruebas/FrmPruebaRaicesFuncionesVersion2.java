
package pruebas;

import javax.swing.JOptionPane;


public class FrmPruebaRaicesFuncionesVersion2 extends javax.swing.JFrame {


    public FrmPruebaRaicesFuncionesVersion2() {
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
        cmbMetodo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Biseccion", "Regla Falsa", "Newton-Raphson", "Secante" }));
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
        cmbFuncion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "f(x) = 4x³ - 6x² + 7x - 2.3", "g(x) = x²√|cos(x)| - 5", "h(x) = x³ - 9x + 3", "k(x) = e⁻ˣ - x", "m(x) = sin(x) - 0.5" }));

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
                    .addComponent(cmbFuncion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        // se crea la instancia de la clase que contiene los metodos numericos
        implementaciones.RaicesFunciones rf = new implementaciones.RaicesFunciones();

        // se definen las funciones y sus derivadas segun sea necesario
        java.util.function.DoubleUnaryOperator f = (x) -> 4*Math.pow(x,3) - 6*Math.pow(x,2) + 7*x - 2.3;
        java.util.function.DoubleUnaryOperator df = (x) -> 12*Math.pow(x,2) - 12*x + 7;

        java.util.function.DoubleUnaryOperator g = (x) -> Math.pow(x,2) * Math.sqrt(Math.abs(Math.cos(x))) - 5;
        java.util.function.DoubleUnaryOperator h = (x) -> Math.pow(x,3) - 9*x + 3;
        java.util.function.DoubleUnaryOperator dh = (x) -> 3*Math.pow(x,2) - 9;

        java.util.function.DoubleUnaryOperator k = (x) -> Math.exp(-x) - x;
        java.util.function.DoubleUnaryOperator dk = (x) -> -Math.exp(-x) - 1;

        java.util.function.DoubleUnaryOperator m = (x) -> Math.sin(x) - 0.5;
        java.util.function.DoubleUnaryOperator dm = (x) -> Math.cos(x);

        // se obtiene lo que el usuario selecciono en los combos
        String funcion = (String)cmbFuncion.getSelectedItem();
        String metodo = (String)cmbMetodo.getSelectedItem();

        // se inicializan valores por defecto para los calculos
        double xi = 0, xf = 0, eamax = 0.0001;
        java.util.List<Object[]> resultados = null;

        // se define el modelo de la tabla donde se mostraran las iteraciones
        javax.swing.table.DefaultTableModel model = new javax.swing.table.DefaultTableModel(
            new Object[]{"Iteracion", "Xi", "Xf", "Xr", "f(Xi)", "f(Xf)", "f(Xr)", "Error"}, 0);


        // si el metodo elegido es biseccion
        if (metodo.equals("Biseccion")) {
            if (funcion.startsWith("f(x)")) {
                xi = 0.0; xf = 1.0;
                resultados = rf.biseccionTabla(f, xi, xf, eamax);
            } else if (funcion.startsWith("g(x)")) {
                xi = -3.0; xf = -2.0;
                resultados = rf.biseccionTabla(g, xi, xf, eamax);
            } else if (funcion.startsWith("h(x)")) {
                xi = 0.0; xf = 1.0;
                resultados = rf.biseccionTabla(h, xi, xf, eamax);
            } else if (funcion.startsWith("k(x)")) {
                xi = 0.0; xf = 1.0;
                resultados = rf.biseccionTabla(k, xi, xf, eamax);
            } else if (funcion.startsWith("m(x)")) {
                xi = 0.0; xf = 2.0;
                resultados = rf.biseccionTabla(m, xi, xf, eamax);
            }
        }

        // si el metodo elegido es regla falsa
        else if (metodo.equals("Regla Falsa")) {
            if (funcion.startsWith("f(x)")) {
                xi = 0.0; xf = 1.0;
                resultados = rf.reglaFalsaTabla(f, xi, xf, eamax);
            } else if (funcion.startsWith("g(x)")) {
                xi = 2.0; xf = 3.0;
                resultados = rf.reglaFalsaTabla(g, xi, xf, eamax);
            } else if (funcion.startsWith("h(x)")) {
                xi = 0.0; xf = 1.0;
                resultados = rf.reglaFalsaTabla(h, xi, xf, eamax);
            } else if (funcion.startsWith("k(x)")) {
                xi = 0.0; xf = 1.0;
                resultados = rf.reglaFalsaTabla(k, xi, xf, eamax);
            } else if (funcion.startsWith("m(x)")) {
                xi = 0.0; xf = 2.0;
                resultados = rf.reglaFalsaTabla(m, xi, xf, eamax);
            }
        }

        // si el metodo elegido es newton raphson
        else if (metodo.equals("Newton-Raphson")) {
            if (funcion.startsWith("f(x)")) {
                resultados = rf.newtonRaphsonTabla(f, df, 0.0, eamax);
            } else if (funcion.startsWith("h(x)")) {
                resultados = rf.newtonRaphsonTabla(h, dh, 1.0, eamax);
            } else if (funcion.startsWith("k(x)")) {
                resultados = rf.newtonRaphsonTabla(k, dk, 0.5, eamax);
            } else if (funcion.startsWith("m(x)")) {
                resultados = rf.newtonRaphsonTabla(m, dm, 1.0, eamax);
            }
        }

        // si el metodo elegido es secante
        else if (metodo.equals("Secante")) {
            if (funcion.startsWith("g(x)")) {
                resultados = rf.secanteTabla(g, 2.0, 3.0, eamax);
            } else if (funcion.startsWith("h(x)")) {
                resultados = rf.secanteTabla(h, 0.0, 1.0, eamax);
            } else if (funcion.startsWith("k(x)")) {
                resultados = rf.secanteTabla(k, 0.0, 1.0, eamax);
            } else if (funcion.startsWith("m(x)")) {
                resultados = rf.secanteTabla(m, 0.0, 2.0, eamax);
            }
        }

        // mostrar los resultados en la tabla si se logro calcular
        if (resultados != null) {
            for (Object[] fila : resultados) {
                model.addRow(fila);
            }
            tablaIteraciones.setModel(model);
        } else {
            JOptionPane.showMessageDialog(this, "No se pudieron calcular las iteraciones");
        }

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error en el calculo: " + ex.getMessage());
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
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFuncionesVersion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFuncionesVersion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFuncionesVersion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPruebaRaicesFuncionesVersion2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPruebaRaicesFuncionesVersion2().setVisible(true);
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
