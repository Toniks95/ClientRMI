package client;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.util.InputMismatchException;
import org.apache.commons.io.FilenameUtils;
/**
 * 
 * @author tomek
 */
public class GUI extends javax.swing.JFrame {

    private Client client;
    Matrix m;
    private double[][] array;
    private int size;
        
    /**
    * Constructor.
    * Creates new connection.
    */
    public GUI() {
        initComponents();
        hideButtons();
        client = new Client(this);
        client.connectServer();
    }
    /**
     * Hiding determinantButton, tryAgainButton, inputSizePanel, newButton.
     */
    private void hideButtons(){
        determinantButton.setVisible(false);
        tryAgainButton.setVisible(false);
        inputSizePanel.setVisible(false);
        newButton.setVisible(false);
    }
    /**
     * Evaluates function determinant at array arr.
     * @param arr 
     */
    private void evaluate() {
        try {
            //calls function determinant from server file
            m.setResult(client.getStub().determinant(m.getArray()));
            resultTextField.setDisabledTextColor(Color.black);
            resultTextField.setText("Wyznacznik macierzy "+(Integer.toString(m.getSize()))
            +" x "+(Integer.toString(m.getSize()))+" = "+(Double.toString(m.getResult())));
        } catch (RemoteException ex) {
            resultTextField.setDisabledTextColor(Color.red);
            resultTextField.setText("Błąd połączenia.");
            ex.printStackTrace();
        }
    }
    /**
     * Creates new instance of object InputFrame and realizing functions
     * setSize(),getArray() at this instance.
     * @param size 
     */
    private void getArray(int size) {

        try {
            //creates new window and sets visible true
            InputFrame f = new InputFrame();
            f.setVisible(true);
            resultTextField.setText("Macierz została wczytana");
            determinantButton.setVisible(true);
            // sets array size
            f.setSize(size);
            // gets written array
            m = f.getMatrix();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            resultTextField.setText("Nie udało sie wczytać macierzy");
        }
        
    }
    /**
    * Getting matrix from chosen file 
    * @throws Exception FileNotFound and ArrayIndexOutOfException
    */
    
    /**
     * Getting size form sizeTextLabel. 
     * Realizing function getArray with this size.
     */
    private void readSize() {
        try {
            int size = Integer.parseInt(sizeTextField.getText());
            loadSizeButton.setVisible(false);
            sizeTextField.setVisible(false);
            resultTextField.setText("Rozmiar macierzy wczytany");
            inputSizePanel.setVisible(false);
            //calls function getArray to create matrix
            getArray(size);
            
        } catch (NumberFormatException e) {
            sizeTextField.setText("");
            resultTextField.setText("Nieprawidłowy rozmiar");
            System.out.println(e);
        }
    }
    /**
     * Realizing function inputMatrix().
     */
    private void inputFromFile(){
        try {
            m = new Matrix();
            m.inputMatrixFromFile();
            resultTextField.setText("Macierz o rozmiarze " + m.getSize() + " x "
                    + m.getSize() + " wczytana z pliku");
            determinantButton.setVisible(true);
            decisionPanel.setVisible(false);
         
          } catch (ArrayIndexOutOfBoundsException arrayError) {
            System.out.println(arrayError.getMessage());
            resultTextField.setText("Sprawdź dane w macierzy !");
            decisionPanel.setVisible(true);
            
        } catch (FileNotFoundException ioError) {
            System.out.println(ioError);
            resultTextField.setText("Nie odnaleziono pliku !");
            decisionPanel.setVisible(true);
        
        } catch (WrongExtension we){
            System.out.println(we);
            resultTextField.setText(we.getMessage());
            decisionPanel.setVisible(true);
        
        } catch(InputMismatchException ime){
            System.out.println(ime);
            resultTextField.setText("Błąd danch w macierzy");
            decisionPanel.setVisible(true);
        
        } catch (Exception e){
            resultTextField.setText("Inny błąd !");
            System.out.println("Inny blad podczas wczytywania macierzy");
            e.printStackTrace();
        }
        
    }
    /**
     * Realizing function evaluate() with parameter array.
     */
    private void determinant(){
        evaluate();
        inputFromFileButton.setVisible(false);
        newButton.setVisible(true);
        determinantButton.setVisible(false);
    }
    /**
     * Realizing new connection to serwer.
     */
    private void tryAgain(){
        client = new Client(this);
        client.connectServer();
    }
    /**
     * Hiding decisionPanel, showing inputSizePanel.
     */
    private void inputHere(){
        decisionPanel.setVisible(false);
        inputSizePanel.setVisible(true);
    }
    /**
     * Realizing function readSize() if ENTER is clicked.
     * @param evt 
     */
    private void sizeField(KeyEvent evt){
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            readSize();
        }
    }
    /**
     * Refreshing GUI.
     */
    private void newMatrix(){
        hideButtons();
        decisionPanel.setVisible(false);
        client = new Client(this);
        client.connectServer();
        initComponents();
        hideButtons();
        resultTextField.setText("Wczytaj nową macierz");
    }
   /**
    * 
    * @return resultTextField 
    */
    public JTextField getResultText() {
        return resultTextField;
    }
    /**
     * Opens file chooser and returns chosen file url.
     * @return url
     * @throws WrongExtension 
     */
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        resultTextField = new javax.swing.JTextField();
        inputSizePanel = new javax.swing.JPanel();
        sizeTextField = new javax.swing.JTextField();
        loadSizeButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        newButton = new javax.swing.JButton();
        decisionPanel = new javax.swing.JPanel();
        inputHereButton = new javax.swing.JButton();
        inputFromFileButton = new javax.swing.JButton();
        determinantButton = new javax.swing.JButton();
        tryAgainButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Wyznacznik");
        setResizable(false);

        resultTextField.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        resultTextField.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(resultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(resultTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        sizeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeTextFieldActionPerformed(evt);
            }
        });
        sizeTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sizeTextFieldKeyPressed(evt);
            }
        });

        loadSizeButton.setText("Wczytaj");
        loadSizeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadSizeButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Podaj rozmiar macierzy:");

        javax.swing.GroupLayout inputSizePanelLayout = new javax.swing.GroupLayout(inputSizePanel);
        inputSizePanel.setLayout(inputSizePanelLayout);
        inputSizePanelLayout.setHorizontalGroup(
            inputSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inputSizePanelLayout.createSequentialGroup()
                .addGroup(inputSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inputSizePanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(sizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadSizeButton))
                    .addGroup(inputSizePanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        inputSizePanelLayout.setVerticalGroup(
            inputSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, inputSizePanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(inputSizePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loadSizeButton)
                    .addComponent(sizeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        newButton.setText("Nowa macierz");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });

        inputHereButton.setText("Wczytaj tutaj");
        inputHereButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputHereButtonActionPerformed(evt);
            }
        });

        inputFromFileButton.setText("Wczytaj z pliku");
        inputFromFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputFromFileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout decisionPanelLayout = new javax.swing.GroupLayout(decisionPanel);
        decisionPanel.setLayout(decisionPanelLayout);
        decisionPanelLayout.setHorizontalGroup(
            decisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decisionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inputHereButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(inputFromFileButton)
                .addContainerGap())
        );
        decisionPanelLayout.setVerticalGroup(
            decisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(decisionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(inputHereButton)
                .addComponent(inputFromFileButton))
        );

        determinantButton.setText("Oblicz wyznacznik");
        determinantButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                determinantButtonMouseClicked(evt);
            }
        });
        determinantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                determinantButtonActionPerformed(evt);
            }
        });

        tryAgainButton.setText("Sprobuj ponownie");
        tryAgainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tryAgainButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(determinantButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tryAgainButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(decisionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(newButton)
                .addGap(91, 91, 91))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(inputSizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tryAgainButton)
                    .addComponent(determinantButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decisionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(inputSizePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void determinantButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_determinantButtonMouseClicked
        determinant();
    }//GEN-LAST:event_determinantButtonMouseClicked

    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        newMatrix();
    }//GEN-LAST:event_newButtonActionPerformed

    private void tryAgainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tryAgainButtonActionPerformed
        tryAgain();
    }//GEN-LAST:event_tryAgainButtonActionPerformed

    private void inputFromFileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputFromFileButtonActionPerformed
        inputFromFile();
    }//GEN-LAST:event_inputFromFileButtonActionPerformed

    private void inputHereButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputHereButtonActionPerformed
        inputHere();
    }//GEN-LAST:event_inputHereButtonActionPerformed

    private void sizeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeTextFieldActionPerformed

    private void sizeTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sizeTextFieldKeyPressed
        sizeField(evt);
    }//GEN-LAST:event_sizeTextFieldKeyPressed

    private void loadSizeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadSizeButtonActionPerformed
        readSize();
    }//GEN-LAST:event_loadSizeButtonActionPerformed

    private void determinantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_determinantButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_determinantButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel decisionPanel;
    private javax.swing.JButton determinantButton;
    public javax.swing.JButton inputFromFileButton;
    public javax.swing.JButton inputHereButton;
    private javax.swing.JPanel inputSizePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JButton loadSizeButton;
    private javax.swing.JButton newButton;
    private javax.swing.JTextField resultTextField;
    private javax.swing.JTextField sizeTextField;
    public javax.swing.JButton tryAgainButton;
    // End of variables declaration//GEN-END:variables

}
