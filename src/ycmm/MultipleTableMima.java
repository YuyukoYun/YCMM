/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ycmm;

/**
 *
 * @author xz744
 */
public class MultipleTableMima {
    /**
     * 加密
     * @param plaintext 明文
     * @param secretKey **
     * @return 密文
     */
    public String encryption(String plaintext,String secretKey){
       String ciphertext = "";
        char[][] chars = new char[2][plaintext.length()];
        for (int i = 0; i <plaintext.length() ; i++) {
            chars[0][i]=plaintext.charAt(i);
            chars[1][i]=secretKey.toUpperCase().charAt(i%(secretKey.length()));
        }
        char[] charArray = plaintext.toCharArray();
        for (int i = 0; i <charArray.length ; i++) {
            int j = charArray[i];
            //ASCII表65A 97a  
                int k = chars[1][i];
                char te = (char) (((j - 97) + (k - 65)) % 26+65);
                ciphertext = ciphertext+te;
        }
        return  ciphertext.toLowerCase();
    }
}