/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

/**
 *
 * @author ferreira
 */
public class Calc extends javax.swing.JFrame {

    /**
     * Creates new form Calc
     */
    public Calc() {
        initComponents();
    }
    
    private int n1, n2;
    private String op;
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt = new javax.swing.JTextField();
        bt1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        btAd = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        btIgual = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        txt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(txt);
        txt.setBounds(10, 11, 283, 55);

        bt1.setText("1");
        bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(bt1);
        bt1.setBounds(54, 79, 39, 50);

        jButton2.setText("2");
        getContentPane().add(jButton2);
        jButton2.setBounds(99, 79, 39, 50);

        jButton3.setText("3");
        getContentPane().add(jButton3);
        jButton3.setBounds(144, 79, 39, 50);

        jButton4.setText("4");
        getContentPane().add(jButton4);
        jButton4.setBounds(54, 135, 39, 58);

        jButton5.setText("5");
        getContentPane().add(jButton5);
        jButton5.setBounds(99, 135, 39, 58);

        jButton6.setText("6");
        getContentPane().add(jButton6);
        jButton6.setBounds(150, 140, 39, 58);

        jButton7.setText("7");
        getContentPane().add(jButton7);
        jButton7.setBounds(54, 199, 39, 50);

        jButton8.setText("8");
        getContentPane().add(jButton8);
        jButton8.setBounds(99, 199, 39, 50);

        jButton9.setText("9");
        getContentPane().add(jButton9);
        jButton9.setBounds(150, 200, 39, 50);

        jButton10.setText("0");
        getContentPane().add(jButton10);
        jButton10.setBounds(54, 262, 84, 41);

        btAd.setText("+");
        btAd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdActionPerformed(evt);
            }
        });
        getContentPane().add(btAd);
        btAd.setBounds(200, 80, 41, 50);

        jButton12.setText("-");
        getContentPane().add(jButton12);
        jButton12.setBounds(200, 140, 41, 50);

        jButton13.setText("*");
        getContentPane().add(jButton13);
        jButton13.setBounds(200, 200, 41, 50);

        jButton14.setText("/");
        getContentPane().add(jButton14);
        jButton14.setBounds(200, 260, 37, 41);

        btIgual.setText("=");
        btIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIgualActionPerformed(evt);
            }
        });
        getContentPane().add(btIgual);
        btIgual.setBounds(148, 262, 40, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt1ActionPerformed
        // TODO add your handling code here:
        
        txt.setText( txt.getText() + bt1.getText());
    }//GEN-LAST:event_bt1ActionPerformed

    private void btAdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdActionPerformed
        // TODO add your handling code here:
        
        if (txt.getText().length()==0){
            txt.setText("0");
        }
        
        n1 = Integer.valueOf(txt.getText());
        op = btAd.getText();
        
        txt.setText( txt.getText() + btAd.getText());
        
    }//GEN-LAST:event_btAdActionPerformed

    private void btIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIgualActionPerformed
        // TODO add your handling code here:
        String painel = txt.getText(); // 111+11
        String num2 = painel.substring(painel.indexOf(op)+1);
        n2 = Integer.valueOf(num2);
        
        
        
        if (op.equals("+")){
            txt.setText(String.valueOf(n1+n2));
        } else if (op.equals("-")){
            txt.setText(String.valueOf(n1-n2));
        }
        
        
    }//GEN-LAST:event_btIgualActionPerformed

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
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt1;
    private javax.swing.JButton btAd;
    private javax.swing.JButton btIgual;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JTextField txt;
    // End of variables declaration//GEN-END:variables
}
