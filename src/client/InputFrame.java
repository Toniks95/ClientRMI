/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

/**
 *Realizing input operations.
 * @author tomek
 */
public class InputFrame extends javax.swing.JFrame implements ActionListener{

    private int i = 0;
    private int j = 0;
    private Matrix mm;
    /**
     * Creates new form FileFrame
     */
    public InputFrame() {
        initComponents();
        inputMatrixPanel.setVisible(false);
        mm = new Matrix();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        inputElements();
    }
    /**
     * 
     * @return array
     */
    public Matrix getMatrix(){
        return mm;
    }
    
    /**
     * Setting size of input array and realizing function createTable(size).
     * @param s 
     */
    public void setSize(int s){
        
        try{
            mm.setSize(s);
            resultTextField.setText("Rozpoczęto wczytywanie macierzy o rozmiarze"
                +s+" x "+s);
            inputMatrixPanel.setVisible(true);
            //creates new array object with size s
            createArray();
 
        }catch(Exception e1){
            resultTextField.setDisabledTextColor(Color.red);
            resultTextField.setText("Nie udało się rozpocząć wczytywania !");
            inputMatrixPanel.setVisible(false);
        }
    } 
     /**
     * Creates new square matrix.
     * @param size
     */
    private void createArray(){
        mm.setArray(new double [mm.getSize()][mm.getSize()]);
        confirmButton.addActionListener(this);
        System.out.println("Utworzylem macierz: "+mm.getSize()+"x"+mm.getSize());
    }  
    /**
     * Realizing input element operations.
     * @param i
     * @param j
     * @return true if gets element.
     * @return false if can't get element.
     */
    private boolean inputElement(int i, int j){
        try{
            //gets value from inputElementTextField
            mm.setElement(i, j, Double.parseDouble(inputElementTextField.getText()));
            
            dLabel.setText("Podales tab["+i+"]["+j+"] = "
                +mm.getElement(i, j)+". Podaj kolejny... ");
            inputElementTextField.setText("");
            System.out.println("tab["+i+"]["+j+"] = "+mm.getElement(i, j)); 
            return true;
        }
        catch(NumberFormatException nfe){
            resultTextField.setDisabledTextColor(Color.red);
            System.out.println("Nie udalo sie wczytac");
            resultTextField.setText("Wprowadz liczbe !");
            inputElementTextField.setText("");
            return false;
        }
        catch(Exception e){
            resultTextField.setDisabledTextColor(Color.red);
            System.out.println("Inny błąd. Nie udalo sie wczytac");
            e.printStackTrace();
            resultTextField.setText("Wprowadz liczbe !");
            inputElementTextField.setText("");
            return false;
        }
    }
    /**
     * Hides buttons and gives info proves that matrix is already inputted.
     */
    private void fullTable(){
        
        resultTextField.setText("Macierz wczytana.");
        System.out.println("Wczytywanie macierzy zakonczone");
        dLabel.setVisible(false);
        confirmButton.setVisible(false);
        inputElementTextField.setVisible(false); 
    }   
     /**
      * Sets index of array. 
      * Realizing function inputElement(i,j)
      */
    private void inputElements(){
        int r = mm.getSize();
        
        if(i<r){
            if(j<r){
                
                if(inputElement(i,j) == true)
                    j++;
                    
                //read finished
                if(i==r-1 && j==r){
                    fullTable();
                }  
            }
            else if(j==r){
               
                i++;
                j=0;
                
                if(inputElement(i,j) == true){
                    j++;                   
                }
                else{ 
                    i--; 
                    j=r; 
                }
            }
        }
        else{       
            confirmButton.setVisible(false);
            inputElementTextField.setVisible(false);          
        } 
    }
    /**
    * Realizing function inputElements() if ENTER is clicked.
    * @param evt 
    */
    private void inputElement(KeyEvent evt){
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            inputElements();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        resultTextField = new javax.swing.JTextField();
        inputMatrixPanel = new javax.swing.JPanel();
        dLabel = new javax.swing.JLabel();
        inputElementTextField = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        resultTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        resultTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        resultTextField.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(resultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(resultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dLabel.setText("Podaj pierwszy element tab[0][0]");

        inputElementTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                inputElementTextFieldKeyPressed(evt);
            }
        });

        confirmButton.setText("Zatwierdz");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout inputMatrixPanelLayout = new javax.swing.GroupLayout(inputMatrixPanel);
        inputMatrixPanel.setLayout(inputMatrixPanelLayout);
        inputMatrixPanelLayout.setHorizontalGroup(
            inputMatrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputMatrixPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputElementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(confirmButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(dLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );
        inputMatrixPanelLayout.setVerticalGroup(
            inputMatrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputMatrixPanelLayout.createSequentialGroup()
                .addComponent(dLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inputMatrixPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputElementTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        closeButton.setText("OK");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(inputMatrixPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(closeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(inputMatrixPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(closeButton)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputElementTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_inputElementTextFieldKeyPressed
        inputElement(evt);
    }//GEN-LAST:event_inputElementTextFieldKeyPressed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed

    }//GEN-LAST:event_confirmButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(InputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel dLabel;
    private javax.swing.JTextField inputElementTextField;
    private javax.swing.JPanel inputMatrixPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField resultTextField;
    // End of variables declaration//GEN-END:variables
}
