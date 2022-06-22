/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycmm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JOptionPane;
/**
 *
 * @author yuche6130
 */
public class YCMM {

    /**
     * @param args the command line arguments
     */
        

    
    
    public static void main(String[] args) throws Exception {
        // 显示应用 GUI
        CaesarCipher CC = new CaesarCipher();
        MultipleTableMima MT = new MultipleTableMima();

            JOptionPane.showMessageDialog(null, "Write your text in file.txt");
            
            FileInputStream f = new FileInputStream("file.txt");
            int i; 
            String text = "";
            while ((i = f.read()) != -1) {
                text = text + (char) i;
            }
            System.out.println(text);
            text=text.replace(" ","");
            text=text.replaceAll("[\\pP\\p{Punct}]","");
            text=text.toLowerCase();
            System.out.println(text);
            PrintStream ps = new PrintStream(new FileOutputStream("file.txt"));
            System.out.println(CC.encryption(text, 3));
            System.out.println(CC.encryptionrf(text, 3));
            System.out.println(CC.encryptionsi(text, "mylove"));
            System.out.println(MT.encryption(text, "RADIO"));

            
        JOptionPane.showMessageDialog(null, "Be quiet! Don't let anyone see you!");
        
        int userOption =  JOptionPane.showConfirmDialog(null,"Are you sure Big Brother isn't watching you?","warning",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	//确认对话框
        //如果用户选择的是OK
        if (userOption == JOptionPane.OK_OPTION) {

        }else {
        	System.exit(0);
        }
       
        

        String [] options = {"Caesar cipher","Rail fence cipher","Monoalphabetic Cipher","Vigenère cipher"};
        String info =  (String)JOptionPane.showInputDialog(null,"Choose the encryption method you want (even though none of them are secure enough):","warning",JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
        System.out.println(info);
        
        if(info.equals("Caesar cipher")){
        
            int Cc = Integer.parseInt(JOptionPane.showInputDialog(null,"How many Spaces does the alphabet move to the right","IP",JOptionPane.WARNING_MESSAGE));		//输入对话框
            System.out.println(info);
            System.out.println(CC.encryption(text, Cc));
            ps.println(CC.encryption(text, Cc));
            
        }
        if(info.equals("Rail fence cipher")){
        
            int Rf = Integer.parseInt(JOptionPane.showInputDialog(null,"How many letters per group","IP",JOptionPane.WARNING_MESSAGE));		//输入对话框
            System.out.println(info);
            System.out.println(CC.encryptionrf(text, Rf));
            ps.println(CC.encryptionrf(text, Rf));
        }
        if(info.equals("Monoalphabetic Cipher")){
        
            String Mc = JOptionPane.showInputDialog(null,"What is the keyword","IP",JOptionPane.WARNING_MESSAGE);		//输入对话框
            System.out.println(info);
            System.out.println(CC.encryptionsi(text, Mc));
            ps.println(CC.encryptionsi(text, Mc));
        }
        if(info.equals("Vigenère cipher")){
        
            String Vc = JOptionPane.showInputDialog(null,"What is the keyword","IP",JOptionPane.WARNING_MESSAGE);		//输入对话框
            System.out.println(info);
            System.out.println(MT.encryption(text, Vc));
            ps.println(MT.encryption(text, Vc));
        }
            
            ps.close();
            f.close();
        }
 
        
        //String text = (String)objStream.readObject();
        

        
        
        
        


        
    }
//}