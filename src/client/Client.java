package client;

import rmi.DetRMI;
import java.awt.Color;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    private GUI gui;
    private DetRMI stub;
    /**
     * 
     * @param g 
     */
    public Client(GUI g) {
        gui = g;
    }
    /**
     * Getting stub.
     * @return stub
     */
    public DetRMI getStub() {
        return stub;
    }
    /**
     * Method is realizing connection to server.
     * 
     */
    public void connectServer() {
        try {
            Registry reg = LocateRegistry.getRegistry();
            DetRMI stub = (DetRMI) reg.lookup("DetRMI");
            this.stub = stub;
            //gui.loadSizeButton.setEnabled(true);
            gui.getResultText().setDisabledTextColor(Color.black);
            gui.getResultText().setText("Połączono z serwerem.");
            gui.tryAgainButton.setVisible(false);
            gui.inputHereButton.setEnabled(true);
            gui.inputFromFileButton.setEnabled(true);
        } catch(Exception e) {
            gui.getResultText().setDisabledTextColor(Color.red);
            gui.getResultText().setText("Brak połączenia z serwerem.");
            gui.tryAgainButton.setVisible(true);
            gui.inputHereButton.setEnabled(false);
            gui.inputFromFileButton.setEnabled(false);
            
        }
    }
    
}
