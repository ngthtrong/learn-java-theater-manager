/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ngthtrong.theatermanager.views;

import java.awt.Color;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import ngthtrong.theatermanager.controller.HomePageController;
import ngthtrong.theatermanager.controller.TheaterController;
import ngthtrong.theatermanager.models.Period;
import ngthtrong.theatermanager.models.Theater;

/**
 *
 * @author jhiny
 */
public class TheaterDetailForm extends javax.swing.JFrame {

    /**
     * Creates new form MovieFrom
     */
    private TheaterController theaterController;
    private Theater theaterInfo;

    public TheaterDetailForm() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(1000, 600);
        getContentPane().setBackground(Color.getHSBColor(0.2f, 0.05f, 0.95f));
    }

    public TheaterDetailForm(TheaterController theaterController) {
        this.theaterController = theaterController;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setSize(1000, 600);
        getContentPane().setBackground(Color.getHSBColor(0.2f, 0.05f, 0.95f));
    }

    public void setTheaterController(TheaterController theaterController) {
        this.theaterController = theaterController;
    }

    public TheaterController getTheaterController() {
        return theaterController;
    }

    public void FormLoad() {
        this.setVisible(true);
        setEnable(false);
        btnSaveChange.setEnabled(false);
        btnEdit.setEnabled(true);
        theaterController.setTheaterDetailForm(this);
    }

    public void FormClose() {
        this.setVisible(false);
    }

    public void Cancel() {
        btnEdit.setEnabled(true);
        btnSaveChange.setEnabled(false);
        this.SetDetailTheater(theaterInfo);
        setEnable(false);
    }

    public void setEnable(boolean enable) {
        txtTheaterName.setEnabled(enable);
        if (Using.isSelected())
            NotUsing.setEnabled(false);
        else
            txtCapacity.setEnabled(enable);
    }

    public void SetBtnDeleteEnable(boolean enable) {
        btnDeletePeriod.setEnabled(enable);
    }

    public void SetDetailTheater(Theater theater) {
        theaterInfo = theater;
        txtTheaterID.setText(String.valueOf(theater.getTheater_id()));
        txtTheaterName.setText(theater.getTheater_name());
        txtCapacity.setText(String.valueOf(theater.getTheater_capacity()));
        Using.setSelected(theater.isIsUsing());
        NotUsing.setSelected(!theater.isIsUsing());
        lbOfTables.setText("List period of theater: " + theater.getTheater_name());
    }

    public String getTheaterName() {
        return txtTheaterName.getText();
    }

    public void setPeriodTables(List<Period> periods) {
        if (periods == null) {
            return;
        } else {

            this.SetBtnDeleteEnable(true);
            DefaultTableModel model = (DefaultTableModel) tbPeriods.getModel();
            model.setRowCount(0);
            for (Period period : periods) {
                model.addRow(
                        new Object[] { String.valueOf(period.getPeriod_id()), period.getMovie_name(),
                                period.getTheater_name(),
                                String.valueOf(period.getPeriod_size()),
                                period.getPeriod_time(), period.getPeriod_date() });
            }
            tbPeriods.setModel(model);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnUsing = new javax.swing.ButtonGroup();
        btnTheaterForm = new javax.swing.JButton();
        lbTheaterID = new javax.swing.JLabel();
        txtTheaterID = new javax.swing.JTextField();
        lbMovieID1 = new javax.swing.JLabel();
        txtTheaterName = new javax.swing.JTextField();
        btnEdit = new javax.swing.JButton();
        btnSaveChange = new javax.swing.JButton();
        btnDeletePeriod = new javax.swing.JButton();
        btnAddPeriod = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPeriods = new javax.swing.JTable();
        Using = new javax.swing.JRadioButton();
        NotUsing = new javax.swing.JRadioButton();
        lbUsing = new javax.swing.JLabel();
        btnBack = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lbOfTables = new javax.swing.JLabel();
        lbMovieID2 = new javax.swing.JLabel();
        txtCapacity = new javax.swing.JTextField();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 600));
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        btnTheaterForm.setBackground(new java.awt.Color(204, 0, 0));
        btnTheaterForm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTheaterForm.setForeground(new java.awt.Color(255, 255, 255));
        btnTheaterForm.setText("Theater");
        btnTheaterForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTheaterFormActionPerformed(evt);
            }
        });

        lbTheaterID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbTheaterID.setText("Theater ID:");

        txtTheaterID.setEnabled(false);
        txtTheaterID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTheaterIDKeyTyped(evt);
            }
        });

        lbMovieID1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMovieID1.setText("Name:");

        txtTheaterName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTheaterNameKeyTyped(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(180, 10, 10));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnSaveChange.setBackground(new java.awt.Color(180, 10, 10));
        btnSaveChange.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSaveChange.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveChange.setText("Save change");
        btnSaveChange.setEnabled(false);
        btnSaveChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveChangeActionPerformed(evt);
            }
        });

        btnDeletePeriod.setBackground(new java.awt.Color(180, 10, 10));
        btnDeletePeriod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDeletePeriod.setForeground(new java.awt.Color(255, 255, 255));
        btnDeletePeriod.setText("Delete Period");
        btnDeletePeriod.setEnabled(false);
        btnDeletePeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePeriodActionPerformed(evt);
            }
        });

        btnAddPeriod.setBackground(new java.awt.Color(180, 10, 10));
        btnAddPeriod.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddPeriod.setForeground(new java.awt.Color(255, 255, 255));
        btnAddPeriod.setText("Add Period");
        btnAddPeriod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPeriodActionPerformed(evt);
            }
        });

        tbPeriods.setBackground(new java.awt.Color(255, 225, 225));
        tbPeriods.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbPeriods.setForeground(new java.awt.Color(40, 0, 0));
        tbPeriods.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Period ID", "Movie Name", "Theater", "Booked", "Time", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPeriods.setGridColor(new java.awt.Color(255, 150, 150));
        tbPeriods.setRowHeight(30);
        jScrollPane2.setViewportView(tbPeriods);
        if (tbPeriods.getColumnModel().getColumnCount() > 0) {
            tbPeriods.getColumnModel().getColumn(0).setResizable(false);
            tbPeriods.getColumnModel().getColumn(1).setResizable(false);
            tbPeriods.getColumnModel().getColumn(2).setResizable(false);
            tbPeriods.getColumnModel().getColumn(4).setResizable(false);
        }

        btnUsing.add(Using);
        Using.setText("Yes");
        Using.setEnabled(false);

        btnUsing.add(NotUsing);
        NotUsing.setText("No");
        NotUsing.setEnabled(false);

        lbUsing.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbUsing.setText("Now using");

        btnBack.setBackground(new java.awt.Color(180, 10, 10));
        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnCancel.setBackground(new java.awt.Color(180, 10, 10));
        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lbOfTables.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbOfTables.setText("List period of theater:");

        lbMovieID2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMovieID2.setText("Capacity:");

        txtCapacity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCapacityKeyTyped(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(204, 0, 0));
        btnHome.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnHome.setForeground(new java.awt.Color(255, 255, 255));
        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbTheaterID)
                            .addGap(49, 49, 49)
                            .addComponent(txtTheaterID, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txtTheaterName, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnSaveChange, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                            .addGap(38, 38, 38)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnAddPeriod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeletePeriod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnCancel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbMovieID1)
                                .addComponent(lbMovieID2)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbUsing)
                                    .addGap(85, 85, 85)
                                    .addComponent(Using)
                                    .addGap(18, 18, 18)
                                    .addComponent(NotUsing)))
                            .addGap(10, 10, 10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHome)
                .addGap(36, 36, 36)
                .addComponent(btnTheaterForm)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(320, 320, 320)
                    .addComponent(lbOfTables, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTheaterForm, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lbTheaterID)
                    .addComponent(txtTheaterID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtTheaterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMovieID1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Using)
                    .addComponent(NotUsing)
                    .addComponent(lbUsing))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtCapacity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMovieID2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 197, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeletePeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSaveChange, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAddPeriod, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(lbOfTables, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(549, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTheaterIDKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtTheaterIDKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }// GEN-LAST:event_txtTheaterIDKeyTyped

    private void txtCapacityKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtCapacityKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (txtTheaterName.getText().length() >= 10) {
            evt.consume();
        }

    }// GEN-LAST:event_txtCapacityKeyTyped

    private void btnAddPeriodActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddPeriodActionPerformed
        theaterController.showTheaterAddPeriodForm(Integer.valueOf(txtTheaterID.getText()));

    }// GEN-LAST:event_btnAddPeriodActionPerformed

    private void txtTheaterNameKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_txtTheaterNameKeyTyped
        // TODO add your handling code here:
        if (txtTheaterName.getText().length() >= 80) {
            evt.consume();
        }

    }// GEN-LAST:event_txtTheaterNameKeyTyped

    private void btnTheaterFormActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTheaterFormActionPerformed
        // TODO add your handling code here:
        if (theaterController != null) {
            theaterController.showTheaterForm();
        }

    }// GEN-LAST:event_btnTheaterFormActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHomeActionPerformed
        // TODO add your handling code here:
        HomePageController backHome = new HomePageController();
        backHome.loadHomePage();
        this.dispose();
    }// GEN-LAST:event_btnHomeActionPerformed

    private void btnDeletePeriodActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeletePeriodActionPerformed
        theaterController.showTheaterDeletePeriodForm(Integer.valueOf(txtTheaterID.getText()));

    }// GEN-LAST:event_btnDeletePeriodActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_formKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
    }// GEN-LAST:event_formKeyTyped

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        setEnable(true);
        btnSaveChange.setEnabled(true);
        btnEdit.setEnabled(false);

    }// GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.Cancel();

    }// GEN-LAST:event_btnCancelActionPerformed

    private void btnSaveChangeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSaveChangeActionPerformed
        // TODO add your handling code here:
        if (txtTheaterName.getText().equals("") || txtTheaterID.getText().equals("")
                || txtCapacity.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!");
        } else {
            Theater theater = new Theater();
            theater.setTheater_id(Integer.valueOf(txtTheaterID.getText()));
            theater.setTheater_name(txtTheaterName.getText());
            theater.setTheater_capacity(Integer.valueOf(txtCapacity.getText()));
            theater.setIsUsing(Using.isSelected());
            theaterController.UpdateTheaterDetail(theater);
        }
        this.Cancel();

    }// GEN-LAST:event_btnSaveChangeActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.FormClose();
        theaterController.showTheaterForm();

    }// GEN-LAST:event_btnBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton NotUsing;
    private javax.swing.JRadioButton Using;
    private javax.swing.JButton btnAddPeriod;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDeletePeriod;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSaveChange;
    private javax.swing.JButton btnTheaterForm;
    private javax.swing.ButtonGroup btnUsing;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMovieID1;
    private javax.swing.JLabel lbMovieID2;
    private javax.swing.JLabel lbOfTables;
    private javax.swing.JLabel lbTheaterID;
    private javax.swing.JLabel lbUsing;
    private javax.swing.JTable tbPeriods;
    private javax.swing.JTextField txtCapacity;
    private javax.swing.JTextField txtTheaterID;
    private javax.swing.JTextField txtTheaterName;
    // End of variables declaration//GEN-END:variables
}
