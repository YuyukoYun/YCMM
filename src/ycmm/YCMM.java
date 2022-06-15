/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycmm;

import javax.swing.*;

/**
 *
 * @author yuche6130
 */
public class YCMM {

    /**
     * @param args the command line arguments
     */
    

    
    
    public static void main(String[] args) {
        // 显示应用 GUI
        RandomChoose RC = new RandomChoose();
        CaesarCipher CC = new CaesarCipher();
        
        //String x = JOptionPane.showInputDialog("PlZINPUT");
        //JOptionPane.showMessageDialog(null, x, RC.getSaltString(5), JOptionPane.PLAIN_MESSAGE);
        System.out.println(CC.test());
        System.out.println(CC.test_C(4));
        
    }
}