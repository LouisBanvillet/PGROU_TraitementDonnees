/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package traitementcontrolepresence;

import Frame.TraitementControlePresenceFrame;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Louis
 */
public class TraitementControlePresence {
    
    protected static Connection conn;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
                org.postgresql.Driver driver = new org.postgresql.Driver(); 
                System.out.println("DRIVER OK ! ");

                String url = "jdbc:postgresql://localhost:5432/pgrou";
                String user = "kevin";
                String passwd = "&&EÉÉI&'";

                conn = DriverManager.getConnection(url, user, passwd);
                System.out.println("Connection effective !");			

        } catch (Exception e) {
                e.printStackTrace();
        }
        
        // TODO code application logic here
        TraitementControlePresenceFrame TraitementFrame = new TraitementControlePresenceFrame();
        TraitementFrame.setVisible(true);
    }
   
    
    public static void creationFormulaireAbsenceEtudiant(String nomEleve, String prenomEleve){
        String contenu = nomEleve + " " + prenomEleve + "\n";
                
        try {
                Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                //On crée notre requête
                String query = ("SELECT presence.presence_status, cours.cours_designation "
                  + "FROM presence, eleves, cours "
                  + "WHERE presence.eleves_id = eleves.eleves_id AND presence.cours_id = cours.cours_id AND "
                  + "eleves.eleves_nom = '" + nomEleve + "' AND "
                  + "eleves.eleves_prenom = '" + prenomEleve + "';");
                			
		ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                        contenu += res.getString("presence_status") + ";" + res.getString("cours_designation") + "\n";
                         
                }
               
                res.close();
                state.close();                        

                generateCsvFile("csv/FormulaireAbsence" + nomEleve + prenomEleve + ".csv", contenu); 

        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    
    public static void creationFormulaireAbsenceMatiere(String nomMatiere){
        String contenu = nomMatiere + "\n";
                
        try {
                Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                //On crée notre requête
                String query = ("SELECT cours.cours_designation,eleves.eleves_nom,eleves.eleves_prenom,presence.presence_status "
                  + "FROM presence, eleves, cours "
                  + "WHERE presence.eleves_id = eleves.eleves_id AND presence.cours_id = cours.cours_id AND "
                  + "cours.cours_designation = '" + nomMatiere  +"';");
                			
		ResultSet res = state.executeQuery(query);
                
                while(res.next()){
                        contenu += res.getString("presence_status") + ";" + res.getString("eleves_nom") + ";" + res.getString("eleves_prenom")+"\n";
                         
                }
               System.out.println(contenu);
                res.close();
                state.close();                        

                generateCsvFile("csv/FormulaireAbsence" + nomMatiere + ".csv", contenu); 

        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    
    private static void generateCsvFile(String sFileName, String contenu)
   {
	try
	{
	    FileWriter writer = new FileWriter(sFileName);
 
	    writer.append(contenu);
 
	    writer.flush();
	    writer.close();
	}
	catch(NullPointerException e)
	{
	     System.out.println("Erreur : pointeur null");
	} 
        catch(IOException e)
	{
	     System.out.println("Problème d'IO");
             e.printStackTrace();
	} 
    }
    
}
