package at.htlstp.webserver.webserver5ahet_22.service;

import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Vector;

@Service
public class DatabaseService {
    /** @return Prüft ob die Tabellen einer Datenbank gelesen werden können */
    public boolean checkDatabaseAccess(String url, String user, String password){
        try {
            Connection con = DriverManager.getConnection(url, user, password);
            con.close();
            return true;
        } catch (SQLException throwables) {

        }
        return false;
    }

    public Vector<Vector<String>> executeQuery(Connection con, String sqlStatement) {
        Vector<Vector<String>> ret = new Vector<Vector<String>>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery( sqlStatement );
            ResultSetMetaData metaData = rs.getMetaData();
            int rows = metaData.getColumnCount();
            // Spaltennamen ermitteln
            Vector<String> row = new Vector<String>();
            for (int c=1; c<=rows; c++)
                row.add(metaData.getColumnName(c));
            ret.add(row);
            while (rs.next()) {
                row = new Vector<String>();
                for (int c=1; c<=rows; c++)
                    row.add(rs.getString(c));
                ret.add(row);
            }
            return ret;
        } catch (SQLException throwables) {
            String msg = throwables.getMessage()+"! ";
        }
        return null;
    }

    public Vector<Vector<String>> read(String sql) {
        String msg="";
        String databaseUrl = "jdbc:mysql://localhost:13306/letto_htlstp";
        String databaseUser = "root";
        String databasePassword = "verdi32";
        Connection con=null;


        try {
            con = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword);
            // Restkey suchen
            Vector<Vector<String>> data = executeQuery(con, sql);
            con.close();
            return data;
        } catch (Exception ex) { if (con!=null) try { con.close(); } catch (SQLException ex1) {} }
        return new Vector<>();
    }
}
