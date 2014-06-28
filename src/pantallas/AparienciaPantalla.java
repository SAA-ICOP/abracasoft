/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pantallas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author German
 */
public class AparienciaPantalla {
    
    private String path;
    
    public void cambiarApariencia(String path) {
        
        try{
            JFrame.setDefaultLookAndFeelDecorated(true);
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.setLookAndFeel(path);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
