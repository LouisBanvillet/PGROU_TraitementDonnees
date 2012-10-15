package Frame;

import Main.TraitementControlePresence;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


/**
 *
 * @author Louis, Kevin
 */

public class TraitementControlePresenceFrame extends javax.swing.JFrame {

    /**
     * Initialisation des composants de la fenêtre 
     */
    public TraitementControlePresenceFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        choixAction.addActionListener(new ItemAction());
        creationBouton.addActionListener(new BoutonListener());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titre2 = new javax.swing.JLabel();
        titre1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        textRequest = new javax.swing.JLabel();
        choixAction = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDonnees = new javax.swing.JTable();
        creationBouton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Traitement des données - Contrôle de présence");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(null);
        setPreferredSize(new java.awt.Dimension(500, 400));
        setResizable(false);
        getContentPane().setLayout(new java.awt.FlowLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(500, 80));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 80));

        titre2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titre2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titre2.setText("Contrôle de présence");
        titre2.setMaximumSize(null);
        titre2.setMinimumSize(null);
        titre2.setPreferredSize(new java.awt.Dimension(500, 40));
        jPanel1.add(titre2);

        titre1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        titre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titre1.setText("Traitement des données");
        titre1.setMaximumSize(new java.awt.Dimension(200, 50));
        titre1.setMinimumSize(null);
        titre1.setName(""); // NOI18N
        titre1.setPreferredSize(new java.awt.Dimension(500, 25));
        jPanel1.add(titre1);

        getContentPane().add(jPanel1);

        jPanel2.setMaximumSize(null);
        jPanel2.setMinimumSize(new java.awt.Dimension(500, 90));
        jPanel2.setPreferredSize(new java.awt.Dimension(500, 90));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 10));

        textRequest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textRequest.setText("Quel objet est concerné par votre requête?");
        textRequest.setMaximumSize(null);
        textRequest.setMinimumSize(null);
        textRequest.setPreferredSize(new java.awt.Dimension(500, 30));
        jPanel2.add(textRequest);

        choixAction.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "Un élève", "Une matière", "Un élève dans une matière", "Un professeur" }));
        choixAction.setMaximumSize(null);
        choixAction.setMinimumSize(null);
        choixAction.setPreferredSize(new java.awt.Dimension(200, 20));
        choixAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                choixActionActionPerformed(evt);
            }
        });
        jPanel2.add(choixAction);

        getContentPane().add(jPanel2);

        jPanel3.setMaximumSize(null);
        jPanel3.setMinimumSize(new java.awt.Dimension(500, 170));
        jPanel3.setPreferredSize(new java.awt.Dimension(500, 170));
        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 10));

        jScrollPane1.setMaximumSize(null);
        jScrollPane1.setMinimumSize(null);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 120));

        tableDonnees.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Donnée", "Valeur"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableDonnees.setCellSelectionEnabled(true);
        tableDonnees.setMaximumSize(null);
        tableDonnees.setMinimumSize(null);
        tableDonnees.setPreferredSize(null);
        jScrollPane1.setViewportView(tableDonnees);
        tableDonnees.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableDonnees.getColumnModel().getColumn(0).setResizable(false);
        tableDonnees.getColumnModel().getColumn(1).setResizable(false);

        jPanel3.add(jScrollPane1);

        creationBouton.setText("Créer le fichier .xls");
        jPanel3.add(creationBouton);

        getContentPane().add(jPanel3);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void choixActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_choixActionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_choixActionActionPerformed

    /**
     * Les champs de la JTable sont initialisés selon l'item selectionné de la liste déroulante
     * @param args the command line arguments
     */
    class ItemAction implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String[][] tabValeur = new String[0][0];

            switch (choixAction.getSelectedIndex()) {
                case 1:
                    tabValeur = new String[][]{
                        {"Nom :", null},
                        {"Prénom :", null}
                    };
                    break;
                case 2:
                    tabValeur = new String[][]{
                        {"Nom de la matière :", null}
                    };
                    break;
                case 3:
                    tabValeur = new String[][]{
                        {"Nom :", null},
                        {"Prénom :", null},
                        {"Nom de la matière :", null}
                    };
                    break;
                case 4:
                    tabValeur = new String[][]{
                        {"Nom :", null},
                        {"Prénom :", null}
                    };
                    break;
                default:
                    ;
            }
            modifTable(tabValeur);
        }
    }

    /**
     * 
     * @param tabValeur
     */
    public void modifTable(String[][] tabValeur) {
        tableDonnees.setModel(new javax.swing.table.DefaultTableModel(
                tabValeur,
                new String[]{
                    "Donnée", "Valeur"
                }) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableDonnees.setCellSelectionEnabled(true);
        jScrollPane1.setViewportView(tableDonnees);
        tableDonnees.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tableDonnees.getColumnModel().getColumn(0).setResizable(false);
        tableDonnees.getColumnModel().getColumn(1).setResizable(false);

    }
    
    /**
     * 
     * Récupération des valeurs entrées par l'utilisateur lors de la validation du choix 
     * Elles sont traitées dans TraitementControlePresence.java puis analysées
     * 
     */
    class BoutonListener implements ActionListener {
        //Redéfinition de la méthode actionPerformed()

        public void actionPerformed(ActionEvent arg0) {

            switch (choixAction.getSelectedIndex()) {
                case 1:
                    TraitementControlePresence.creationFormulaireAbsenceEtudiant(
                            ((String) tableDonnees.getValueAt(0, 1)),
                            ((String) tableDonnees.getValueAt(1, 1)));
                    break;
                case 2:
                    TraitementControlePresence.creationFormulaireAbsenceMatiere(
                            ((String) tableDonnees.getValueAt(0, 1)));
                    break;
                case 3:
                    TraitementControlePresence.creationFormulaireAbsenceEtudiantPourUneMatière(
                            ((String) tableDonnees.getValueAt(0, 1)), 
                            ((String) tableDonnees.getValueAt(1, 1)), 
                            ((String) tableDonnees.getValueAt(2, 1)));
                    break;
                /*case 4 : ;
                 break; */
                default:
                    ;
            }

        }
    }

    /**
     * Message d'avertissement si matière/élève non repertorié
     * @param message
     * @param titre
     */
    public static void avertissement(String message, String titre) {

        JOptionPane.showMessageDialog(null, message, titre, JOptionPane.WARNING_MESSAGE);

    }
    
    /**
     * Message d'information lors de la génération du document Excel
     * @param message
     * @param titre
     */
    public static void notification(String message, String titre){
        
        JOptionPane.showMessageDialog(null, message, titre, JOptionPane.INFORMATION_MESSAGE);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox choixAction;
    private javax.swing.JButton creationBouton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableDonnees;
    private javax.swing.JLabel textRequest;
    private javax.swing.JLabel titre1;
    private javax.swing.JLabel titre2;
    // End of variables declaration//GEN-END:variables
}
