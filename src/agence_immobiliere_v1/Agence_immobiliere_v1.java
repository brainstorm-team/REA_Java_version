/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agence_immobiliere_v1;

import de.javasoft.plaf.synthetica.SyntheticaBlueLightLookAndFeel;
import gui.Acceuil_client;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author jemacom
 */
public class Agence_immobiliere_v1 {

    /**
     * @param args the command line arguments
     * @throws javax.swing.UnsupportedLookAndFeelException
     */
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        try {
            UIManager.setLookAndFeel(new SyntheticaBlueLightLookAndFeel());
            Acceuil_client acc = new Acceuil_client();
            acc.setVisible(true);
        } catch (ParseException ex) {
            Logger.getLogger(Agence_immobiliere_v1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
