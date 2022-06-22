/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycmm;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        

    
    
    public static void main(String[] args) {
        // 显示应用 GUI
        CaesarCipher CC = new CaesarCipher();
        Scanner scanner = new Scanner(System.in);
        MultipleTableMima MT = new MultipleTableMima();
        
        try {

            FileOutputStream file = new FileOutputStream("file.txt");

            //创建一个ObjectOutputStream
            ObjectOutputStream output = new ObjectOutputStream(file);
            
            //将对象写入输出流
            
            String secret = JOptionPane.showInputDialog(null,"Tell your secret","IP",JOptionPane.WARNING_MESSAGE);		//输入对话框
            System.out.println(secret);
            output.writeObject(secret);

            //使用ObjectInputStream读取数据
            FileInputStream fileStream = new FileInputStream("file.txt");
            ObjectInputStream objStream = new ObjectInputStream(fileStream);
            
            String text = (String)objStream.readObject();
            System.out.println(text);
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
            output.writeObject(CC.encryption(text, Cc));
            
        }
        if(info.equals("Rail fence cipher")){
        
            int Rf = Integer.parseInt(JOptionPane.showInputDialog(null,"How many letters per group","IP",JOptionPane.WARNING_MESSAGE));		//输入对话框
            System.out.println(info);
            System.out.println(CC.encryptionrf(text, Rf));
            output.writeObject(CC.encryptionrf(text, Rf));
        }
        if(info.equals("Monoalphabetic Cipher")){
        
            String Mc = JOptionPane.showInputDialog(null,"What is the keyword","IP",JOptionPane.WARNING_MESSAGE);		//输入对话框
            System.out.println(info);
            System.out.println(CC.encryptionsi(text, Mc));
            output.writeObject(CC.encryptionsi(text, Mc));
        }
        if(info.equals("Vigenère cipher")){
        
            String Vc = JOptionPane.showInputDialog(null,"What is the keyword","IP",JOptionPane.WARNING_MESSAGE);		//输入对话框
            System.out.println(info);
            System.out.println(MT.encryption(text, Vc));
            output.writeObject(MT.encryption(text, Vc));
        }
            
            output.close();
            objStream.close();
        }

        catch (Exception e) {
            e.getStackTrace();
        }
        
        //String text = (String)objStream.readObject();
        

        
        
        
        


        
    }
}