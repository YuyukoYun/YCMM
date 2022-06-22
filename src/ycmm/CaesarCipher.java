/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycmm;


import java.lang.Math;

/**
 *
 * @author yuche6130
 */
public class CaesarCipher {

    String base = "abcdefghijklmnopqrstuvwxyz";

    /**
     * 加密
     * @param text 明文
     * @param Key **
     * @return 密文
     */
    public String encryption(String text, int number) {

        String ciphertext = "";
        char[][] key = new char[2][base.length()];
        char[][] testext = new char[2][text.length()];
        for (int i = 0; i <base.length() ; i++) {
            key[0][i]=base.toLowerCase().charAt(i);
        }
        for (int i = 0; i <base.length() ; i++) {
            int x = i + number;
            if (x >= 26) 
            {
            x = x - 26;
            key[1][i]=key[0][x];
            }
            else
            {
            key[1][i]=key[0][x];
            }
        }
        for (int i = 0; i <text.length() ; i++) {
            //int x = 0;
            testext[0][i]=text.toLowerCase().charAt(i);
            for (int x = 0; x <base.length() ; x++) {
                    if(Character.compare(testext[0][i],key[0][x]) == 0) {
                        ciphertext = ciphertext + key[1][x];
                    }
                }
        }
        return ciphertext;
    }
    
    public String encryptionrf(String text, int length) {

        String ciphertext = "";
        int ror = (int)Math.ceil(text.length()/length);
        char[][] textrf = new char[ror + ][length];

        for (int i = 0; i < text.length() ; i++) {
            //int x = 0;
            textrf[(int)Math.floor(i/length)][i%length]=text.toLowerCase().charAt(i);
        }
        
        for (int c = 0; c < textrf[0].length; c++){
        
            for (int r = 0; r < textrf.length; r++){
            
                ciphertext = ciphertext + textrf[r][c];
            
            }
            
            
        }
        
        
        
        return ciphertext;
    }
    
    public String encryptionsi(String text, String keyword) {
        
        int miss = 0;
        String ciphertext = "";
        //key0是原本 key1是密码本
        char[][] key = new char[2][base.length()];
        //tt0是原文
        char[] testext = new char[text.length()];
        //让key0变成原本
        for (int i = 0; i <base.length() ; i++) {
            key[0][i]=base.toLowerCase().charAt(i);
        }
       
        //key1加上密码
        for (int i = 0; i <keyword.length() ; i++) {
            key[1][i]=keyword.toLowerCase().charAt(i);
        }
        //key1加上剩下的
            for(int c = 0; c < base.length(); c++){
                for(int e = 0; e <keyword.length() ; e++){
                    if(Character.compare(key[0][c],keyword.toLowerCase().charAt(e)) != 0){
                        key[1][c + keyword.length() - miss] = key[0][c];
                    }else{
                        miss ++;
                    }
                }
            }
        
        
        for (int i = 0; i <text.length() ; i++) {
            //int x = 0;
            testext[i]=text.toLowerCase().charAt(i);
            for (int x = 0; x <base.length() ; x++) {
                    if(Character.compare(testext[i],key[0][x]) == 0) {
                        ciphertext = ciphertext + key[1][x];
                    }
                }
        }
        return ciphertext;
    }
    
    
    
}
