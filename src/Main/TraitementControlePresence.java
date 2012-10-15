/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Frame.TraitementControlePresenceFrame;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

            //lecture d'un fichier texte contenant les identifiants de connexion à la BDD
            InputStream ips = new FileInputStream("MDP_connexionBDD.txt");
            InputStreamReader ipsr = new InputStreamReader(ips);
            BufferedReader br = new BufferedReader(ipsr);
            String url = br.readLine();
            String user = br.readLine();
            String passwd = br.readLine();
            br.close();

            conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connection effective !");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // TODO code application logic here
        TraitementControlePresenceFrame TraitementFrame = new TraitementControlePresenceFrame();
        TraitementFrame.setVisible(true);
    }

    public static void creationFormulaireAbsenceEtudiant(String nomEleve, String prenomEleve) {

        if (existeEleve(nomEleve, prenomEleve)) {


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

                while (res.next()) {
                    contenu += res.getString("cours_designation") + ";" 
                            + Constantes.presence.get(res.getString("presence_status")) + "\n";

                }

                res.close();
                state.close();

                generateCsvFile("csv/FormulaireAbsence" + nomEleve + prenomEleve + ".csv", contenu);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            TraitementControlePresenceFrame.avertissement("Aucun élève répertorié", " Notification élève");
        }

    }

    public static void creationFormulaireAbsenceMatiere(String nomMatiere) {
        String contenu = nomMatiere + "\n";

        if (existeMatiere(nomMatiere)) {

            try {
                Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

                //On crée notre requête
                String query = ("SELECT cours.cours_designation, eleves.eleves_nom, eleves.eleves_prenom, presence.presence_status "
                        + "FROM presence, eleves, cours "
                        + "WHERE presence.eleves_id = eleves.eleves_id AND presence.cours_id = cours.cours_id AND "
                        + "cours.cours_designation = '" + nomMatiere + "';");

                ResultSet res = state.executeQuery(query);

                while (res.next()) {
                    contenu += res.getString("eleves_nom") + ";" + res.getString("eleves_prenom") 
                            + ";" + Constantes.presence.get(res.getString("presence_status")) + "\n";

                }

                res.close();
                state.close();

                generateCsvFile("csv/FormulaireAbsence" + nomMatiere + ".csv", contenu);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            TraitementControlePresenceFrame.avertissement("Aucune matière repertoriée", " Notification matière");

        }
    }

    public static boolean existeMatiere(String nomMatiere) {

        boolean existeMatiere = false;

        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = ("SELECT cours_designation "
                    + "FROM cours "
                    + "WHERE cours_designation = '" + nomMatiere.toUpperCase() + "';");

            ResultSet res = state.executeQuery(query);
            
            while (res.next()) {
                if (res.getString("cours_designation").equals(nomMatiere)) {
                    existeMatiere = true;
                }
            }
            
            res.close();
            state.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existeMatiere;
    }

    public static boolean existeEleve(String nomEleve, String prenomEleve) {

        boolean existeEleve = false;

        try {
            Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

            String query = ("SELECT eleves_nom, eleves_prenom "
                    + "FROM eleves "
                    + "WHERE eleves_nom = '" + nomEleve + "' AND "
                    + "eleves_prenom = '" + prenomEleve + "';");

            ResultSet res = state.executeQuery(query);
            
            while (res.next()) {
                if(res.getString("eleves_nom").equals(nomEleve) && res.getString("eleves_prenom").equals(prenomEleve)){
                    existeEleve = true;
                }                
            }

            res.close();
            state.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return existeEleve;
    }

    private static void generateCsvFile(String sFileName, String contenu) {
        try {
            FileWriter writer = new FileWriter(sFileName);

            writer.append(contenu);

            writer.flush();
            writer.close();
        } catch (NullPointerException e) {
            System.out.println("Erreur : pointeur null");
        } catch (IOException e) {
            System.out.println("Problème d'IO");
            e.printStackTrace();
        }
    }
}
