package at.htlstp.webserver.webserver5ahet_22.service;


import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.Vector;

@Service
public class DataService {
    private String user = "root";
    private String pwd = "pwd";
    private String jdbc = "jdbc:mysql://localhost:23306/letto_htlstp";

    public Vector<Vector<String>> executeQuery(Connection con, String sql) {
        Vector<Vector<String>> ret = new Vector<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData meta = rs.getMetaData();

            // Laden der Spaltennamen
            int cols = meta.getColumnCount();
            Vector<String> line = new Vector<>();
            for (int i = 0; i< cols ; i++) {
                line.add(meta.getColumnName(i));
            }
            ret.add(line);

            while (rs.next()) {

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return ret;
    }

    public Vector<Vector<String>> read(String sql) {

        try {
            Connection con = DriverManager.getConnection(jdbc, user, pwd);
            System.out.println("OK");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
