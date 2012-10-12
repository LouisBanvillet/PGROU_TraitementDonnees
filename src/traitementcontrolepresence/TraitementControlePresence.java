/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traitementcontrolepresence;

import Frame.TraitementControlePresenceFrame;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Louis
 */
public class TraitementControlePresence {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
                Class.forName("org.postgresql.Driver");
                System.out.println("DRIVER OK ! ");

                String url = "jdbc:postgresql://localhost:5432/AGAP_PGROU";
                String user = "postgres";
                String passwd = "sagara";

                Connection conn = DriverManager.getConnection(url, user, passwd);
                System.out.println("Connection effective !");			

        } catch (Exception e) {
                e.printStackTrace();
        }
        
        // TODO code application logic here
        TraitementControlePresenceFrame TraitementFrame = new TraitementControlePresenceFrame();
        TraitementFrame.setVisible(true);
    }
   
}
