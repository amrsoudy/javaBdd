/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import java.sql.*;

/**
 *
 * @author team1
 */
public class Aptctr {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection con = null;

        Class.forName("oracle.jdbc.OracleDriver");

        con = DriverManager.getConnection("jdbc:oracle:thin:@144.217.163.57:1521:XE", "team8211", "anypw1");

        System.out.println("connected");

        //les inserts 
        insertOrdonnance(con, 6, "ne pas manger trop saler", "Chirurgie", Date.valueOf("2018-02-12"));
        insertSalle(con, 110, "soldat anonyme");
        insertTypeChirurgie(con, 14, "neurochirurgie", " chirurgie des nerf et cerveau");
        insertSpecialite(con, 1004, "neuro", " maladie des nerfs");
        insertCategories(con, 204, "categorie", "pour maladie");
        insertSpecSalle(con, 11, 102, Date.valueOf("2018-08-07"));
        insertMedicament(con, 5, "advil", 7.99, 200);

        insertDocteur(con, 15, "House", "Robert", 1001, "Laval", "2015 rue delavie ", "Docteur", 110);
        insertDossierPat(con, 710, "Malade", "Grave", "F", "MG1111111", Date.valueOf("1990-02-28"),
                Date.valueOf("2018-05-09"), 15);
        insertConsultation(con, 15, 710, Date.valueOf("2016-03-31"), "Alergie", 5);
        insertChirurgie(con, 105, 10, 104, Date.valueOf("2015-03-29"), 830, 1000);
        insertOrdChir(con, 4, 103, 4000);
        insererOrdonnanceMedicamants(con, 3, 2, 67);

        //les script
        nbChirurgiesParDocteur(con);
        System.out.println("************************");

        afficherNbConsultationParAnne(con);
        System.out.println("************************");

        afficherNbConsulatationParDocteurs(con);
        System.out.println("************************");

        afficherNbMedicamentsParDecteur(con);

        System.out.println("************************");

        afficherNbMedicamentParDocteurParAnne(con);

        con.close();
    }

    private static void nbChirurgiesParDocteur(Connection con) throws SQLException {

        String sql = "select matricule ,count(idchir)\n"
                + "from CHIRURGIE join ORDONNANCECHIRUGIE using(idchir) \n"
                + "join CONSULTATION using (numord)\n"
                + "join docteur on (codedocteur=matricule)\n"
                + "group by matricule";

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            System.out.println("Matricule: " + rs.getInt(1) + " Nombre de chirurgie: " + rs.getInt(2));
        }
        stm.close();
        rs.close();

    }

    private static void afficherNbConsultationParAnne(Connection con) throws SQLException {

        String sql = "select to_char(datec,'yyyy') MoisAnne,count(*)\n"
                + "from consultation\n"
                + "group by to_char(datec,'yyyy')";

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            System.out.println("Anne: " + rs.getInt(1) + " Nombre de cosultation: " + rs.getInt(2));
        }
        stm.close();
        rs.close();

    }

    private static void afficherNbConsulatationParDocteurs(Connection con) throws SQLException {
        String sql = "select d.matricule, d.nomm, d.prenomm, count(c.codedocteur)\n"
                + "from docteur d, consultation c\n"
                + "where d.MATRICULE = c.CODEDOCTEUR\n"
                + "group by d.matricule, d.nomm, d.prenomm";

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            System.out.println("Matricule: " + rs.getInt(1) + " Nom: " + rs.getString(2)
                    + " Prenom: " + rs.getString(3) + " Nombre de consultation: " + rs.getInt(4));
        }
        stm.close();
        rs.close();
    }

    private static void afficherNbMedicamentsParDecteur(Connection con) throws SQLException {
        String sql = "select MATRICULE ,count(idmed) from MEDICAMENT \n"
                + "join ORDONNANCEMEDICAMENTS using (idmed)\n"
                + "join CONSULTATION using (NUMORD)\n"
                + "join docteur on (CODEDOCTEUR=MATRICULE) group by MATRICULE";

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            System.out.println("Matricule:  " + rs.getInt(1) + " Nomber de Medicament : " + rs.getInt(2));
        }
        stm.close();
        rs.close();
    }

    private static void afficherNbMedicamentParDocteurParAnne(Connection con) throws SQLException {
        String sql = "select MATRICULE ,to_char(datec,'yyyy'),count(idmed) from MEDICAMENT \n"
                + "join ORDONNANCEMEDICAMENTS using (idmed)\n"
                + "join CONSULTATION using (NUMORD)\n"
                + "join docteur on (CODEDOCTEUR=MATRICULE) \n"
                + "group by MATRICULE ,to_char(datec,'yyyy')";

        Statement stm = con.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()) {
            System.out.println("Matricule:  " + rs.getInt(1) + " Anne : " + rs.getInt(2) + " Nomber de Matricule : " + rs.getInt(3));
        }
        stm.close();

        rs.close();

    }

    public static int insertOrdonnance(Connection con, int num, String recommandations, String typ, Date datec) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into ordonnance values(?,?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, num);
        stm.setString(2, recommandations);
        stm.setString(3, typ);
        stm.setDate(4, datec);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertSalle(Connection con, int no, String nom) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into salle values(?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, no);
        stm.setString(2, nom);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertTypeChirurgie(Connection con, int no, String nom, String descr) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into TYPECHIRURGIE values(?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, no);
        stm.setString(2, nom);
        stm.setString(3, descr);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertSpecialite(Connection con, int code, String titre, String descr) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into SPECIALITE values(?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, code);
        stm.setString(2, titre);
        stm.setString(3, descr);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertCategories(Connection con, int num, String nom, String descr) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into CATEGORIES values(?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, num);
        stm.setString(2, nom);
        stm.setString(3, descr);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertSpecSalle(Connection con, int idtype, int idsalle, Date datec) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into SPECIALISATIONSALLE values(?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, idtype);
        stm.setInt(2, idsalle);

        stm.setDate(3, datec);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertMedicament(Connection con, int idmed, String nommed, double prix, int idcat) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into MEDICAMENT values(?,?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, idmed);
        stm.setString(2, nommed);
        stm.setDouble(3, prix);
        stm.setInt(4, idcat);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertDocteur(Connection con, int matricule, String nom, String prenom,
            int spec, String ville, String adresse, String niveau, int nbPatient) throws SQLException {

        PreparedStatement stm;
        String sql1 = "insert into Docteur values(?,?,?,?,?,?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, matricule);
        stm.setString(2, nom);
        stm.setString(3, prenom);
        stm.setInt(4, spec);
        stm.setString(5, ville);
        stm.setString(6, adresse);
        stm.setString(7, niveau);
        stm.setInt(8, nbPatient);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertDossierPat(Connection con, int nomDos, String nom, String prenom,
            String genre, String numeroAs, Date dateNais, Date dateC, int matricule) throws SQLException {

        PreparedStatement stm;
        String sql1 = "insert into DOSSIERPATIENT values(?,?,?,?,?,?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, nomDos);
        stm.setString(2, nom);
        stm.setString(3, prenom);
        stm.setString(4, genre);
        stm.setString(5, numeroAs);
        stm.setDate(6, dateNais);
        stm.setDate(7, dateC);
        stm.setInt(8, matricule);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertConsultation(Connection con, int codeDoc, int numDos,
            Date dateC, String diagnos, int numOrd) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into CONSULTATION values(?,?,?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, codeDoc);
        stm.setInt(2, numDos);
        stm.setDate(3, dateC);
        stm.setString(4, diagnos);
        stm.setInt(5, numOrd);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertChirurgie(Connection con, int idChir, int idType,
            int idSalle, Date dateChir, int heureDebut, int heureFin) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into CHIRURGIE values(?,?,?,?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, idChir);
        stm.setInt(2, idType);
        stm.setInt(3, idSalle);
        stm.setDate(4, dateChir);
        stm.setInt(5, heureDebut);
        stm.setInt(6, heureFin);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    public static int insertOrdChir(Connection con, int numOrd, int idChir, int rang) throws SQLException {
        PreparedStatement stm;
        String sql1 = "insert into ORDONNANCECHIRUGIE values(?,?,?)";
        stm = con.prepareStatement(sql1);
        stm.setInt(1, numOrd);
        stm.setInt(2, idChir);
        stm.setInt(3, rang);

        int rs = stm.executeUpdate();

        stm.close();
        return rs;

    }

    private static int insererOrdonnanceMedicamants(Connection con, int numord, int idmed, int nbboites) throws SQLException {
        String sql = "insert into ORDONNANCEMEDICAMENTS values (?, ?, ?)";

        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.setInt(1, numord);
        pstm.setInt(2, idmed);
        pstm.setInt(3, nbboites);

        int rs = pstm.executeUpdate();

        pstm.close();
        return rs;

    }
}
