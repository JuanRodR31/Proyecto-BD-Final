/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import modelo.AdministradorDAO;

/**
 *
 * @author estudiante
 */
public class PantallaAdministrador extends javax.swing.JFrame {

    /**
     * Creates new form PantallaAdministrador
     */
    public PantallaAdministrador() {
        initComponents();
        llenarComboBoxPaises();
        llenarComboBoxEmpresasDiscograficas();
        llenarComboBoxIdiomas();
        llenarComboBoxGeneros();
        
    }
    public void cerrarSesion (){
        PantallaLogin pantallaLogin = new PantallaLogin();
        pantallaLogin.setVisible(true);
        dispose();
    }
    public final void llenarComboBoxPaises(){
        AdministradorDAO admin = new AdministradorDAO();
        admin.rellenarPaises(comboBoxPais);
    }
    public final void llenarComboBoxEmpresasDiscograficas (){
         AdministradorDAO admin = new AdministradorDAO();
         admin.rellenarEmpresasDiscograficas(comboBoxEmpresaDiscografica);
    }
    public final void llenarComboBoxIdiomas (){
        AdministradorDAO admin = new AdministradorDAO();
        admin.rellenarIdiomas(comboBoxIdiomaTituloCancion);
    }
    public final void llenarComboBoxGeneros(){
         AdministradorDAO admin = new AdministradorDAO();
         admin.rellenarGeneros(comboBoxGeneroCancion);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        AlbumOEP = new javax.swing.ButtonGroup();
        LabelAgregarAlbumOEp = new javax.swing.JLabel();
        textFieldTituloAlbum = new javax.swing.JTextField();
        botonAgregarAlbum = new javax.swing.JButton();
        LabelAgregarArtista = new javax.swing.JLabel();
        labelTituloAlbum = new javax.swing.JLabel();
        textFieldFechaLanzamiento = new javax.swing.JTextField();
        labelFechaLanzamiento = new javax.swing.JLabel();
        textFieldNombreArtista = new javax.swing.JTextField();
        labelNombreArtista = new javax.swing.JLabel();
        textFieldNombreArtistico = new javax.swing.JTextField();
        labelNombreArtistico = new javax.swing.JLabel();
        labelPais = new javax.swing.JLabel();
        buttonAgregarArtista = new javax.swing.JButton();
        comboBoxPais = new javax.swing.JComboBox<>();
        labelAlbumOEp = new javax.swing.JLabel();
        rbuttonAlbum = new javax.swing.JRadioButton();
        rbuttonEP = new javax.swing.JRadioButton();
        LabelAgregarCancionAAlbum = new javax.swing.JLabel();
        textFieldDuracionCancion = new javax.swing.JTextField();
        labelDuracionCancion = new javax.swing.JLabel();
        labelGeneroCancion = new javax.swing.JLabel();
        labelInterpretePrincipal = new javax.swing.JLabel();
        comboBoxGeneroCancion = new javax.swing.JComboBox<>();
        comboBoxInterpretePrincipal = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        comboBoxCancion = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        comboBoxArtistaSecundario = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        labelIdiomaTitulo = new javax.swing.JLabel();
        comboBoxIdiomaTituloCancion = new javax.swing.JComboBox<>();
        lableTituloCancion = new javax.swing.JLabel();
        textFieldTituloCancion = new javax.swing.JTextField();
        comboBoxAlbumCancion = new javax.swing.JComboBox<>();
        labelAlbumxCancion = new javax.swing.JLabel();
        buttonCerrarSesion = new javax.swing.JButton();
        comboBoxEmpresaDiscografica = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LabelAgregarAlbumOEp.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        LabelAgregarAlbumOEp.setText("Agregar Album o EP");

        textFieldTituloAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTituloAlbumActionPerformed(evt);
            }
        });

        botonAgregarAlbum.setText("Agregar Album");
        botonAgregarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAgregarAlbumActionPerformed(evt);
            }
        });

        LabelAgregarArtista.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        LabelAgregarArtista.setText("Agregar Artista");

        labelTituloAlbum.setText("Titulo");

        textFieldFechaLanzamiento.setText("dd-mm-yyyy");
        textFieldFechaLanzamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldFechaLanzamientoActionPerformed(evt);
            }
        });

        labelFechaLanzamiento.setText("Fecha Lanzamiento");

        textFieldNombreArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreArtistaActionPerformed(evt);
            }
        });

        labelNombreArtista.setText("Nombre");

        textFieldNombreArtistico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldNombreArtisticoActionPerformed(evt);
            }
        });

        labelNombreArtistico.setText("NombreArtistico");

        labelPais.setText("Pais");

        buttonAgregarArtista.setText("Agregar Artista");
        buttonAgregarArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAgregarArtistaActionPerformed(evt);
            }
        });

        comboBoxPais.setToolTipText("");

        labelAlbumOEp.setText("Album o ep");

        AlbumOEP.add(rbuttonAlbum);
        rbuttonAlbum.setText("Album");
        rbuttonAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbuttonAlbumActionPerformed(evt);
            }
        });

        AlbumOEP.add(rbuttonEP);
        rbuttonEP.setText("EP");

        LabelAgregarCancionAAlbum.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        LabelAgregarCancionAAlbum.setText("Agregar Cancion A Album");

        textFieldDuracionCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldDuracionCancionActionPerformed(evt);
            }
        });

        labelDuracionCancion.setText("Druracion");

        labelGeneroCancion.setText("Genero");

        labelInterpretePrincipal.setText("Interprete Principal");

        comboBoxInterpretePrincipal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton3.setText("Agregar Cancion");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel10.setText("Agregar artistas secundarios a cancion");

        comboBoxCancion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxCancion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxCancionActionPerformed(evt);
            }
        });

        jLabel14.setText("Cancion");

        jLabel15.setText("Artista");

        comboBoxArtistaSecundario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton4.setText("Agregar Artista");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        labelIdiomaTitulo.setText("IdiomaTitulo");

        lableTituloCancion.setText("titulo");

        comboBoxAlbumCancion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        labelAlbumxCancion.setText("Album");

        buttonCerrarSesion.setText("Cerrar sesion");
        buttonCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(buttonAgregarArtista)
                        .addGap(113, 113, 113)
                        .addComponent(comboBoxEmpresaDiscografica, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(LabelAgregarArtista)
                                    .addComponent(textFieldNombreArtista)
                                    .addComponent(labelNombreArtistico)
                                    .addComponent(textFieldNombreArtistico, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE)
                                    .addComponent(labelNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelPais)
                                    .addComponent(comboBoxPais, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelAgregarAlbumOEp)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rbuttonAlbum)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbuttonEP))
                                    .addComponent(labelAlbumOEp)
                                    .addComponent(textFieldTituloAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelTituloAlbum)
                                    .addComponent(labelFechaLanzamiento)
                                    .addComponent(textFieldFechaLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboBoxArtistaSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel15)
                                            .addComponent(comboBoxCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14))
                                        .addGap(91, 91, 91))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton4)
                                        .addGap(174, 174, 174))
                                    .addComponent(botonAgregarAlbum))
                                .addGap(71, 71, 71)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelAgregarCancionAAlbum)
                            .addComponent(labelIdiomaTitulo)
                            .addComponent(comboBoxIdiomaTituloCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labelInterpretePrincipal)
                                        .addComponent(labelDuracionCancion)
                                        .addComponent(labelGeneroCancion)
                                        .addComponent(comboBoxInterpretePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFieldTituloCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(textFieldDuracionCancion, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboBoxGeneroCancion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(lableTituloCancion)))
                                    .addComponent(labelAlbumxCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboBoxAlbumCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jButton3)
                                    .addGap(75, 75, 75))))
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(buttonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(LabelAgregarArtista)
                        .addComponent(LabelAgregarAlbumOEp))
                    .addComponent(buttonCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelAlbumOEp))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textFieldNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rbuttonAlbum)
                                    .addComponent(rbuttonEP))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNombreArtistico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldNombreArtistico, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPais)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxPais, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonAgregarArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboBoxEmpresaDiscografica)
                                        .addGap(18, 18, 18)
                                        .addComponent(botonAgregarAlbum)
                                        .addGap(44, 44, 44))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTituloAlbum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldTituloAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelFechaLanzamiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textFieldFechaLanzamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(140, 140, 140)))
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxArtistaSecundario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(31, 31, 31))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LabelAgregarCancionAAlbum)
                        .addGap(18, 18, 18)
                        .addComponent(labelIdiomaTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxIdiomaTituloCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lableTituloCancion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldTituloCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(labelDuracionCancion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldDuracionCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelGeneroCancion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxGeneroCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelInterpretePrincipal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxInterpretePrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelAlbumxCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxAlbumCancion, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addGap(81, 81, 81))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAgregarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAgregarAlbumActionPerformed
        AdministradorDAO admin = new AdministradorDAO();
        String titulo = textFieldTituloAlbum.getText();
        String fecha = textFieldFechaLanzamiento.getText();
        java.util.Date utilFecha = null;

        try {
            utilFecha = new SimpleDateFormat("dd-MM-yyyy").parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }

        java.sql.Date sqlFecha = null;
        if (utilFecha != null) {
            sqlFecha = new java.sql.Date(utilFecha.getTime());
        }

        String albumOEP = rbuttonAlbum.isSelected() ? "album" : "ep";

        admin.agregarAlbumOEp(1, titulo, sqlFecha, 1, albumOEP);
    }//GEN-LAST:event_botonAgregarAlbumActionPerformed

    private void textFieldTituloAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTituloAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTituloAlbumActionPerformed

    private void textFieldFechaLanzamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldFechaLanzamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldFechaLanzamientoActionPerformed

    private void textFieldNombreArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreArtistaActionPerformed

    private void textFieldNombreArtisticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldNombreArtisticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldNombreArtisticoActionPerformed

    private void buttonAgregarArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAgregarArtistaActionPerformed
        
    }//GEN-LAST:event_buttonAgregarArtistaActionPerformed

    private void rbuttonAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbuttonAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbuttonAlbumActionPerformed

    private void textFieldDuracionCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldDuracionCancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldDuracionCancionActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void buttonCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCerrarSesionActionPerformed
        cerrarSesion();
    }//GEN-LAST:event_buttonCerrarSesionActionPerformed

    private void comboBoxCancionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxCancionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxCancionActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup AlbumOEP;
    private javax.swing.JLabel LabelAgregarAlbumOEp;
    private javax.swing.JLabel LabelAgregarArtista;
    private javax.swing.JLabel LabelAgregarCancionAAlbum;
    private javax.swing.JButton botonAgregarAlbum;
    private javax.swing.JButton buttonAgregarArtista;
    private javax.swing.JButton buttonCerrarSesion;
    private javax.swing.JComboBox<String> comboBoxAlbumCancion;
    private javax.swing.JComboBox<String> comboBoxArtistaSecundario;
    private javax.swing.JComboBox<String> comboBoxCancion;
    private javax.swing.JComboBox<String> comboBoxEmpresaDiscografica;
    private javax.swing.JComboBox<String> comboBoxGeneroCancion;
    private javax.swing.JComboBox<String> comboBoxIdiomaTituloCancion;
    private javax.swing.JComboBox<String> comboBoxInterpretePrincipal;
    private javax.swing.JComboBox<String> comboBoxPais;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel labelAlbumOEp;
    private javax.swing.JLabel labelAlbumxCancion;
    private javax.swing.JLabel labelDuracionCancion;
    private javax.swing.JLabel labelFechaLanzamiento;
    private javax.swing.JLabel labelGeneroCancion;
    private javax.swing.JLabel labelIdiomaTitulo;
    private javax.swing.JLabel labelInterpretePrincipal;
    private javax.swing.JLabel labelNombreArtista;
    private javax.swing.JLabel labelNombreArtistico;
    private javax.swing.JLabel labelPais;
    private javax.swing.JLabel labelTituloAlbum;
    private javax.swing.JLabel lableTituloCancion;
    private javax.swing.JRadioButton rbuttonAlbum;
    private javax.swing.JRadioButton rbuttonEP;
    private javax.swing.JTextField textFieldDuracionCancion;
    private javax.swing.JTextField textFieldFechaLanzamiento;
    private javax.swing.JTextField textFieldNombreArtista;
    private javax.swing.JTextField textFieldNombreArtistico;
    private javax.swing.JTextField textFieldTituloAlbum;
    private javax.swing.JTextField textFieldTituloCancion;
    // End of variables declaration//GEN-END:variables
}
