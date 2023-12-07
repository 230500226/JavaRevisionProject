/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Apps;

import javax.swing.JButton;
import java.time.LocalDate;
import java.awt.Color;

/**
 *
 * @author sniffel
 * 
 */
public class JavaCalendar extends javax.swing.JFrame {
        // Month will be changed by the user to select the calendar configuration for that month
        int month = 1; // Changed to current month later 
        // numDays variable will hold the number of days in the selected month
        int numDays = 0;
        // Array of month names for lblMonth
String[] monthNames = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    /**
     * Creates new form JavaCalendar
     */
    public JavaCalendar() {
        initComponents();
        // Get the current month
        int currentMonth = LocalDate.now().getMonthValue();
        month = currentMonth; // Change the month varible to current month so that the buttons idex to the correct previous and next months 
        // Call updateDays with the current month
        updateDays(currentMonth);
                // Update lblMonth text to the corresponding month name
        lblMonth.setText(monthNames[currentMonth - 1]); 
        
    }

    public void updateDays(int month){
        // Get the current date
        LocalDate currentDate = LocalDate.now();
        // Remove all existing buttons from the JPanel 
        Jpnl.removeAll();
        Jpnl.revalidate();
        Jpnl.repaint(); 
        
        // Check if the month is February
        if (month == 2) {
            // Set number of days to 28, assuming it's not a leap year
            numDays = 28; 
        } 
        // Check if the month is April, June, September or November
        else if (month == 4 || month == 6 || month == 9 || month == 11) {
            // Set number of days to 30 for these months
            numDays = 30;
        } 
        else {
            // For all other months, set number of days to 31
            numDays = 31;
        }
        
        // Loop through all the days in the selected month
        for (int i = 1; i <= numDays; i++) {
            // Create a new JButton for each day and add it to the JPanel
            JButton button = new JButton(String.valueOf(i));
            
            // If the current day and month match the button's day and selected month, set the button text color to red
            if (currentDate.getDayOfMonth() == i && currentDate.getMonthValue() == month) {
                button.setForeground(Color.RED);
            }
            Jpnl.add(button);
            Jpnl.revalidate();
            Jpnl.repaint();
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

                jInternalFrame1 = new javax.swing.JInternalFrame();
                Jpnl = new javax.swing.JPanel();
                lblMonth = new javax.swing.JLabel();
                btnNext = new javax.swing.JButton();
                btnBack = new javax.swing.JButton();

                jInternalFrame1.setVisible(true);

                javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
                jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
                jInternalFrame1Layout.setHorizontalGroup(
                        jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                );
                jInternalFrame1Layout.setVerticalGroup(
                        jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
                );

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

                Jpnl.setLayout(new java.awt.GridLayout(7, 7));

                lblMonth.setFont(new java.awt.Font("Liberation Sans", 0, 36)); // NOI18N
                lblMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

                btnNext.setText(">");
                btnNext.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnNextActionPerformed(evt);
                        }
                });

                btnBack.setText("<");
                btnBack.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBackActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 58, Short.MAX_VALUE)
                                                .addComponent(btnBack)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnNext)
                                                .addGap(0, 58, Short.MAX_VALUE))
                                        .addComponent(Jpnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnBack)
                                        .addComponent(btnNext))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                                .addComponent(Jpnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // Increase the month by 1, but stop at 12
        if (month < 12) {
            month++;
        }
        // Call updateDays method with the new month value
        updateDays(month); 
        // Update lblMonth text to the corresponding month name
        lblMonth.setText(monthNames[month - 1]); 
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // Decrease the month by 1, but stop at 1
        if (month > 1) {
            month--;
        }
        // Call updateDays method with the new month value
        updateDays(month); 
        // Update lblMonth text to the corresponding month name
        lblMonth.setText(monthNames[month - 1]);
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(JavaCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaCalendar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaCalendar().setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JPanel Jpnl;
        private javax.swing.JButton btnBack;
        private javax.swing.JButton btnNext;
        private javax.swing.JInternalFrame jInternalFrame1;
        private javax.swing.JLabel lblMonth;
        // End of variables declaration//GEN-END:variables
}