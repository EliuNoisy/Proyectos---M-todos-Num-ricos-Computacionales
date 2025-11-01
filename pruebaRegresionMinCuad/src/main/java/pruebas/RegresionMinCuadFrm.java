
package pruebas;

import implementaciones.RegresionMinCuad;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class RegresionMinCuadFrm extends javax.swing.JFrame {


    public RegresionMinCuadFrm() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPolinomial = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtPuntosPolinomial = new javax.swing.JTextArea();
        btnCalcularPolinomial = new javax.swing.JButton();
        btnLimpiarPolinomial = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPolinomial = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtResultadoPolinomial = new javax.swing.JTextArea();
        btnEjemplo1Pol = new javax.swing.JButton();
        btnEjemplo2Pol = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        panelRLM = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtNumVariables = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtPuntosRLM = new javax.swing.JTextArea();
        btnCalcularRLM = new javax.swing.JButton();
        btnLimpiarRLM = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaRLM = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtResultadoRLM = new javax.swing.JTextArea();
        btnEjemplo3RLM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusable(false);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Grado del polinomio (n):");

        txtGrado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Puntos (x, y):");

        txtPuntosPolinomial.setColumns(20);
        txtPuntosPolinomial.setRows(5);
        jScrollPane1.setViewportView(txtPuntosPolinomial);

        btnCalcularPolinomial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCalcularPolinomial.setText("Calcular Polinomio");
        btnCalcularPolinomial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularPolinomialActionPerformed(evt);
            }
        });

        btnLimpiarPolinomial.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLimpiarPolinomial.setText("Limpiar");
        btnLimpiarPolinomial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarPolinomialActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Resultado:");

        tablaPolinomial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tablaPolinomial);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Tabla de Puntos:");

        txtResultadoPolinomial.setColumns(20);
        txtResultadoPolinomial.setRows(5);
        jScrollPane4.setViewportView(txtResultadoPolinomial);

        btnEjemplo1Pol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEjemplo1Pol.setText("Ejemplo 1: Linea");
        btnEjemplo1Pol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjemplo1PolActionPerformed(evt);
            }
        });

        btnEjemplo2Pol.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEjemplo2Pol.setText("Ejemplo 2: Parabola");
        btnEjemplo2Pol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjemplo2PolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(btnCalcularPolinomial)
                        .addGap(131, 131, 131)
                        .addComponent(btnLimpiarPolinomial, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(jLabel3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnEjemplo1Pol)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEjemplo2Pol)
                                .addGap(75, 75, 75))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel4)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtGrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcularPolinomial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarPolinomial, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEjemplo1Pol)
                    .addComponent(btnEjemplo2Pol))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelPolinomial.addTab("Regresion Polinomial", jPanel1);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Número de variables independientes (n):");

        txtNumVariables.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Puntos (x₁, x₂, ..., xₙ, y):");

        txtPuntosRLM.setColumns(20);
        txtPuntosRLM.setRows(5);
        jScrollPane3.setViewportView(txtPuntosRLM);

        btnCalcularRLM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCalcularRLM.setText("Calcular Función Lineal");
        btnCalcularRLM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalcularRLMActionPerformed(evt);
            }
        });

        btnLimpiarRLM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLimpiarRLM.setText("Limpiar");
        btnLimpiarRLM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarRLMActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Resultado:");

        tablaRLM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaRLM);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Tabla de Puntos:");

        txtResultadoRLM.setColumns(20);
        txtResultadoRLM.setRows(5);
        jScrollPane6.setViewportView(txtResultadoRLM);

        btnEjemplo3RLM.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEjemplo3RLM.setText("Ejemplo 3: Función Lineal 2 Variables");
        btnEjemplo3RLM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjemplo3RLMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelRLMLayout = new javax.swing.GroupLayout(panelRLM);
        panelRLM.setLayout(panelRLMLayout);
        panelRLMLayout.setHorizontalGroup(
            panelRLMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRLMLayout.createSequentialGroup()
                .addGroup(panelRLMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRLMLayout.createSequentialGroup()
                        .addGap(269, 269, 269)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumVariables, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRLMLayout.createSequentialGroup()
                        .addGap(385, 385, 385)
                        .addComponent(jLabel6))
                    .addGroup(panelRLMLayout.createSequentialGroup()
                        .addGap(242, 242, 242)
                        .addComponent(btnCalcularRLM)
                        .addGap(137, 137, 137)
                        .addComponent(btnLimpiarRLM, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelRLMLayout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(jLabel7))
                    .addGroup(panelRLMLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(panelRLMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                            .addComponent(jScrollPane6)))
                    .addGroup(panelRLMLayout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel8)))
                .addContainerGap(122, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRLMLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEjemplo3RLM)
                .addGap(293, 293, 293))
        );
        panelRLMLayout.setVerticalGroup(
            panelRLMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRLMLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelRLMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNumVariables, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelRLMLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCalcularRLM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiarRLM, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEjemplo3RLM)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 6, Short.MAX_VALUE)
                .addComponent(panelRLM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(panelRLM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelPolinomial.addTab("Regresion Lineal Multiple", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPolinomial)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPolinomial)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCalcularPolinomialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularPolinomialActionPerformed
         try {
        // Leer grado
        int grado = Integer.parseInt(txtGrado.getText().trim());
        if (grado < 0) {
            JOptionPane.showMessageDialog(this, "El grado debe ser mayor o igual a 0", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Leer puntos
        String[] lineas = txtPuntosPolinomial.getText().trim().split("\n");
        if (lineas.length < grado + 1) {
            JOptionPane.showMessageDialog(this, 
                "Se necesitan al menos " + (grado + 1) + " puntos para un polinomio de grado " + grado, 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double[][] puntos = new double[lineas.length][2];
        for (int i = 0; i < lineas.length; i++) {
            String[] valores = lineas[i].split(",");
            if (valores.length != 2) {
                JOptionPane.showMessageDialog(this, 
                    "Formato incorrecto en la linea " + (i + 1) + ". Use: x, y", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            puntos[i][0] = Double.parseDouble(valores[0].trim());
            puntos[i][1] = Double.parseDouble(valores[1].trim());
        }
        
        // Actualizar tabla con encabezados
        DefaultTableModel modelo = (DefaultTableModel) tablaPolinomial.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        
        // Agregar columnas con nombres
        modelo.addColumn("x");
        modelo.addColumn("y");
        
        // Agregar datos
        for (double[] punto : puntos) {
            modelo.addRow(new Object[]{
                String.format("%.6f", punto[0]),
                String.format("%.6f", punto[1])
            });
        }
        
        // Calcular regresion
        double[] coeficientes = RegresionMinCuad.regresionPolinomial(puntos, grado);
        
        // Mostrar resultado
        String resultado = RegresionMinCuad.despliegaPolinomio(coeficientes);
        txtResultadoPolinomial.setText(resultado);
        
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Error al leer los datos. Verifique el formato.", 
            "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }//GEN-LAST:event_btnCalcularPolinomialActionPerformed

    private void btnLimpiarPolinomialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarPolinomialActionPerformed
     txtGrado.setText("");
    txtPuntosPolinomial.setText("");
    DefaultTableModel modelo = (DefaultTableModel) tablaPolinomial.getModel();
    modelo.setRowCount(0);
    txtResultadoPolinomial.setText("");

    }//GEN-LAST:event_btnLimpiarPolinomialActionPerformed

    private void btnEjemplo1PolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjemplo1PolActionPerformed
        txtGrado.setText("1");
    txtPuntosPolinomial.setText(
        "1, 9.9\n" +
        "2, 9.0\n" +
        "3, 8.1\n" +
        "4, 7.1\n" +
        "5, 6.2\n" +
        "6, 5.3\n" +
        "7, 4.4\n" +
        "8, 3.6\n" +
        "9, 2.7\n" +
        "10, 1.8\n" +
        "11, 1.0\n" +
        "12, -0.7\n" +
        "13, -1.5\n" +
        "14, -2.3"
    );

    }//GEN-LAST:event_btnEjemplo1PolActionPerformed

    private void btnEjemplo2PolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjemplo2PolActionPerformed
         txtGrado.setText("2");
    txtPuntosPolinomial.setText(
        "0, 1.2\n" +
        "2, 0.6\n" +
        "4, 0.4\n" +
        "6, -0.2\n" +
        "9, 0\n" +
        "11, -0.6\n" +
        "13, -0.4\n" +
        "15, -0.2\n" +
        "17, -0.4\n" +
        "19, 0.2\n" +
        "23, 0.4\n" +
        "25, 1.2"
    );
    }//GEN-LAST:event_btnEjemplo2PolActionPerformed

    private void btnCalcularRLMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalcularRLMActionPerformed

    try {
        // Leer numero de variables
        int numVar = Integer.parseInt(txtNumVariables.getText().trim());
        if (numVar < 1) {
            JOptionPane.showMessageDialog(this, "El número de variables debe ser mayor a 0", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // Leer puntos
        String[] lineas = txtPuntosRLM.getText().trim().split("\n");
        if (lineas.length < numVar + 1) {
            JOptionPane.showMessageDialog(this, 
                "Se necesitan al menos " + (numVar + 1) + " puntos", 
                "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        double[][] puntos = new double[lineas.length][numVar + 1];
        for (int i = 0; i < lineas.length; i++) {
            String[] valores = lineas[i].split(",");
            if (valores.length != numVar + 1) {
                JOptionPane.showMessageDialog(this, 
                    "Formato incorrecto en la línea " + (i + 1) + 
                    ". Use: x₁, x₂, ..., x" + numVar + ", y", 
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            for (int j = 0; j < valores.length; j++) {
                puntos[i][j] = Double.parseDouble(valores[j].trim());
            }
        }
        
        // Actualizar tabla
        DefaultTableModel modelo = (DefaultTableModel) tablaRLM.getModel();
        modelo.setRowCount(0);
        modelo.setColumnCount(0);
        
        // Agregar columnas
        for (int i = 0; i < numVar; i++) {
            modelo.addColumn("x" + (i + 1));
        }
        modelo.addColumn("y");
        
        // Agregar datos
        for (double[] punto : puntos) {
            Object[] fila = new Object[punto.length];
            for (int i = 0; i < punto.length; i++) {
                fila[i] = String.format("%.6f", punto[i]);
            }
            modelo.addRow(fila);
        }
        
        // Calcular regresión
        double[] coeficientes = RegresionMinCuad.regresionLinealMultiple(puntos);
        
        // Mostrar resultado
        String resultado = RegresionMinCuad.despliegaFuncionLineal(coeficientes);
        txtResultadoRLM.setText(resultado);
        
    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Error al leer los datos. Verifique el formato.", 
            "Error", JOptionPane.ERROR_MESSAGE);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), 
            "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnCalcularRLMActionPerformed

    private void btnLimpiarRLMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarRLMActionPerformed
    txtNumVariables.setText("");
    txtPuntosRLM.setText("");
    DefaultTableModel modelo = (DefaultTableModel) tablaRLM.getModel();
    modelo.setRowCount(0);
    modelo.setColumnCount(0);
    txtResultadoRLM.setText("");
    }//GEN-LAST:event_btnLimpiarRLMActionPerformed

    private void btnEjemplo3RLMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjemplo3RLMActionPerformed
         txtNumVariables.setText("2");
    txtPuntosRLM.setText(
        "1, 1, 18\n" +
        "1, 2, 12.8\n" +
        "2, 1, 25.7\n" +
        "2, 2, 20.6\n" +
        "3, 1, 35.0\n" +
        "3, 2, 29.8\n" +
        "4, 1, 45.5\n" +
        "4, 2, 40.3"
    );
    }//GEN-LAST:event_btnEjemplo3RLMActionPerformed

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
            java.util.logging.Logger.getLogger(RegresionMinCuadFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegresionMinCuadFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegresionMinCuadFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegresionMinCuadFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegresionMinCuadFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalcularPolinomial;
    private javax.swing.JButton btnCalcularRLM;
    private javax.swing.JButton btnEjemplo1Pol;
    private javax.swing.JButton btnEjemplo2Pol;
    private javax.swing.JButton btnEjemplo3RLM;
    private javax.swing.JButton btnLimpiarPolinomial;
    private javax.swing.JButton btnLimpiarRLM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane panelPolinomial;
    private javax.swing.JPanel panelRLM;
    private javax.swing.JTable tablaPolinomial;
    private javax.swing.JTable tablaRLM;
    private javax.swing.JTextField txtGrado;
    private javax.swing.JTextField txtNumVariables;
    private javax.swing.JTextArea txtPuntosPolinomial;
    private javax.swing.JTextArea txtPuntosRLM;
    private javax.swing.JTextArea txtResultadoPolinomial;
    private javax.swing.JTextArea txtResultadoRLM;
    // End of variables declaration//GEN-END:variables
}
