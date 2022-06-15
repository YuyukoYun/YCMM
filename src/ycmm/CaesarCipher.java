/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ycmm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author yuche6130
 */
public class CaesarCipher {

    
    String base = "abcdefghijklmnopqrstuvwxyz0123456789";
    
    List<String> orange = Arrays.asList(base);
    List<String> Caesar = Arrays.asList(base);
    
    
    public List<String> test () {
    return orange;
    }
    
    
    public int test_C(int x) {
        
        for (int time = x; time == 0; time --) {
            Caesar.add(0,Caesar.get(Caesar.size()));
            Caesar.remove(0);
        }
        return Caesar.size();
    }
    
}
