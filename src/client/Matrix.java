/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JFileChooser;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author tomek
 */
public class Matrix {
    
    private int size;
    private double [][] array;
    private double result;

    /**
     * @param size
     * @param array
     */
    public Matrix(int size, double [][] array){
        this.size = size;
        this.array = array;
    }
    
    public Matrix(){}
    
    
    public String fileUrl() throws WrongExtension{
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String url = f.getAbsolutePath();
        System.out.println("url Pliku: "+ url);
        
        if(!(FilenameUtils.getExtension(url).equals("txt"))){
            throw new WrongExtension("Niewłaściwy typ pliku !"); 
        }

        return url;

    }
    public void inputMatrixFromFile() throws Exception {
        
        ArrayList<Double> numbers = new ArrayList<>();
        double[][] arr;
        String url;
     
            //opens file chooser and gets file url
            url = fileUrl();
            //sets scanner to choosen file
            Scanner s = new Scanner(new File(url));
            // copies all values to array list numbers
            while (s.hasNext()) {
                numbers.add(s.nextDouble());
            }
            
            setSize((int) Math.sqrt(numbers.size()));
            arr = new double[getSize()][getSize()];
            int i = 0;
            int j = 0;
            //creates ready matrix. Coping values from numbers to arr.
            for (Double number : numbers) {
                arr[i][j] = number;
                j++;
                if (j == size) {
                    i++;
                    j = 0;
                }
            }           
            setArray(arr);
    }
    
    /**
     * @param size the size to set
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    public void setEl(int i, int j, double element){
        this.array[i][j] = new Double(element);
    }
    //Integer num;
    //num = new Integer(10);
    
    public int getSize() {
        return size;
    }
    
    public double getEl(int i, int j){
        return array[i][j];
    }

    /**
     * @return the array
     */
    public double[][] getArray() {
        return array;
    }

    /**
     * @param array the array to set
     */
    public void setArray(double[][] array) {
        this.array = array;
    }

    /**
     * @return the result
     */
    public double getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(double result) {
        this.result = result;
    }
    
}
