/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pantallas;

import gestores.GestorCliente;
import gestores.GestorPago;
import gestores.GestorVenta;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.Integer.parseInt;
import static java.lang.String.valueOf;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author German
 */
public class MenuGestionCliente extends javax.swing.JFrame {
    

    /**
     * Creates new form GestinonCliente
     */
    public MenuGestionCliente() {
        initComponents();
        buscarMientrasEscribe();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BclienteAgregar = new javax.swing.JButton();
        BclienteEditar = new javax.swing.JButton();
        BclienteBorrar = new javax.swing.JButton();
        TFbusquedaCliente = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tCuentaCorriente = new javax.swing.JTable();
        saldoCliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestion de clientes");
        setMinimumSize(new java.awt.Dimension(713, 510));

        BclienteAgregar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BclienteAgregar.setText("+");
        BclienteAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BclienteAgregarActionPerformed(evt);
            }
        });

        BclienteEditar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BclienteEditar.setText("/");

        BclienteBorrar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        BclienteBorrar.setText("-");
        BclienteBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BclienteBorrarActionPerformed(evt);
            }
        });

        TFbusquedaCliente.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        TFbusquedaCliente.setForeground(new java.awt.Color(204, 204, 204));
        TFbusquedaCliente.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                TFbusquedaClienteCaretUpdate(evt);
            }
        });
        TFbusquedaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TFbusquedaClienteMouseClicked(evt);
            }
        });
        TFbusquedaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFbusquedaClienteActionPerformed(evt);
            }
        });
        TFbusquedaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TFbusquedaClienteKeyTyped(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton4.setText("Búsqueda");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dirección", "Email", "CP", "Telefono", "DNI", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(5);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(6);
        }

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setText("?");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Ayuda");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        tCuentaCorriente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Venta", "Pago", "Fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tCuentaCorriente);

        saldoCliente.setFont(new java.awt.Font("Times", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BclienteAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BclienteEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BclienteBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TFbusquedaCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(saldoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 872, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFbusquedaCliente, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(saldoCliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BclienteAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BclienteEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BclienteBorrar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TFbusquedaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TFbusquedaClienteMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TFbusquedaClienteMouseClicked

    private void TFbusquedaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFbusquedaClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFbusquedaClienteActionPerformed

    private void BclienteAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BclienteAgregarActionPerformed
        // TODO add your handling code here:
        new AltaCliente().setVisible(true);
    }//GEN-LAST:event_BclienteAgregarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TFbusquedaClienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFbusquedaClienteKeyTyped
        /*Abria que probar con carácteres especiales que no falle*/
    }//GEN-LAST:event_TFbusquedaClienteKeyTyped

    private void TFbusquedaClienteCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_TFbusquedaClienteCaretUpdate
        borrarRenglones(1);
        buscarMientrasEscribe();
    }//GEN-LAST:event_TFbusquedaClienteCaretUpdate

    private void BclienteBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BclienteBorrarActionPerformed
        eliminarCliente();
    }//GEN-LAST:event_BclienteBorrarActionPerformed

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        clienteVentaPago();
        saldoCliente();
    }//GEN-LAST:event_jTable1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        clienteVentaPago();
        saldoCliente();
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(MenuGestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuGestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuGestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuGestionCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGestionCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BclienteAgregar;
    private javax.swing.JButton BclienteBorrar;
    private javax.swing.JButton BclienteEditar;
    private javax.swing.JTextField TFbusquedaCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel saldoCliente;
    private javax.swing.JTable tCuentaCorriente;
    // End of variables declaration//GEN-END:variables
    private String paraBuscar="";
            
            

    private void buscarMientrasEscribe() {
        paraBuscar = TFbusquedaCliente.getText();
        DefaultTableModel tabla = (DefaultTableModel) jTable1.getModel();
        if (GestorCliente.ConsultaPorDescripcion(paraBuscar).size() != 0) {
            for (int i = 0; i < GestorCliente.ConsultaPorDescripcion(paraBuscar).size(); i++) {
                Object[] fila = {GestorCliente.ConsultaPorDescripcion(paraBuscar).get(i).getIdCliente(),
                    GestorCliente.ConsultaPorDescripcion(paraBuscar).get(i).getNombreCliente(),
                    GestorCliente.ConsultaPorDescripcion(paraBuscar).get(i).getDireccionCliente(),
                    GestorCliente.ConsultaPorDescripcion(paraBuscar).get(i).getMailCliente(),
                    GestorCliente.ConsultaPorDescripcion(paraBuscar).get(i).getCodigoPostalCliente(),
                    GestorCliente.ConsultaPorDescripcion(paraBuscar).get(i).getTelefonoCliente(),
                    GestorCliente.ConsultaPorDescripcion(paraBuscar).get(i).getDniCuilCuit(),
                    GestorCliente.ConsultaPorDescripcion(paraBuscar).get(i).getEsatdo(),
                };
                tabla.addRow(fila);
            }
        }
    }
    
    private void borrarRenglones(int jpanel){
        int a;
        DefaultTableModel tabla;
        if (jpanel == 1){
            tabla = (DefaultTableModel) jTable1.getModel();
            a = jTable1.getRowCount() - 1;
        }else{
            tabla = (DefaultTableModel) tCuentaCorriente.getModel();
            a = tCuentaCorriente.getRowCount() - 1;
        }
        for (int i = a; i >= 0; i--) {
            tabla.removeRow(i); //se van borrando para que solo muestre el producto que se buscó
        }
    }

    private void eliminarCliente() {
        if(jTable1.getSelectedRows().length > 0 ) {
            int valorCelda = 0;
            try{
                valorCelda = parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
            }catch (NumberFormatException e){
                System.out.println("no se pudo determinar el ID del cliente");
            }
            if(valorCelda != 0){
                DefaultTableModel tcliente = (DefaultTableModel) jTable1.getModel();
                int confirmado = JOptionPane.showConfirmDialog(BclienteBorrar, 
                    "¿Confirma que desea borrar el cliente: " + 
                    jTable1.getValueAt(jTable1.getSelectedRow(),1).toString() + " ?");

                if (JOptionPane.OK_OPTION == confirmado){
                    if (GestorCliente.eliminarCliente(valorCelda)==true){
                        JOptionPane.showMessageDialog(null, "El cliente fue eliminado");
                        borrarRenglones(1);
                        buscarMientrasEscribe();
                    }else{
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar el cliente");
                    }
                }else{
                   System.out.println("no se elimino nada");
                }
            }
         }
    }
    
    private void clienteVentaPago() {
        if(jTable1.getSelectedRows().length > 0 ) {
            int valorCelda = 0;
            try{
                valorCelda = parseInt(jTable1.getValueAt(jTable1.getSelectedRow(),0).toString());
            }catch (NumberFormatException e){ 
            }
            borrarRenglones(2);
            if(valorCelda != 0){
                DefaultTableModel cliVenPag = (DefaultTableModel) tCuentaCorriente.getModel();
                for (int i = 0; i < GestorVenta.cuentaVentaCliente(valorCelda).size(); i++) {
                    Object [] fila = {
                        GestorVenta.cuentaVentaCliente(valorCelda).get(i).getMontoPagoVenta(),
                        "",
                        GestorVenta.cuentaVentaCliente(valorCelda).get(i).getFechaDeVenta()
                    };
                    cliVenPag.addRow(fila);
                }
                for (int i = 0; i < GestorPago.cuentaPagoCliente(valorCelda).size(); i++)  {
                    Object [] fila2 = {
                        "",
                        GestorPago.cuentaPagoCliente(valorCelda).get(i).getPagoCliente(),
                        GestorPago.cuentaPagoCliente(valorCelda).get(i).getFechaPagoCliente()
                    };
                    cliVenPag.addRow(fila2);
                    TableRowSorter<TableModel> ordenar = new TableRowSorter<TableModel>(cliVenPag);
                    ordenar.toggleSortOrder(2);
                    ordenar.toggleSortOrder(2); // esto tiene que estar dos veces para que lo ordene de mayor a menor
                    tCuentaCorriente.setRowSorter(ordenar);
                }
            }
        }
    }
    
    private void saldoCliente(){
        float ventas = 0;
        float pagos = 0;
        
        DefaultTableModel cliVenPag = (DefaultTableModel) tCuentaCorriente.getModel();
        
        if (cliVenPag.getRowCount()!=0){
            for (int i = 0; i< cliVenPag.getRowCount(); i++){
                try {
                    ventas += parseFloat(cliVenPag.getValueAt(i, 0).toString());
                }catch (NumberFormatException e){
                }
                try {
                    pagos += parseFloat(cliVenPag.getValueAt(i, 1).toString());
                }catch (NumberFormatException e){
                }
            }
        }
        saldoCliente.setText("SALDO: "+valueOf(ventas-pagos));
    }
}
