package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConexionDB {

    private String nombreDB = "proyectoDB";
    private String userDB = "postgres";
    private String claveDB = "1234";
    private int puerto = 5432;
    private String host = "localhost";
    private Connection con;

    public ConexionDB() {

        String url = "jdbc:postgresql://" + host + ":" + puerto + "/" + nombreDB;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, userDB, claveDB);
        } catch (Exception e) {
            System.out.println(" Error en la conexion" + e.getMessage());
            e.printStackTrace();
        }

    }

    public ArrayList<String[]> consulta(String sql) {
        PreparedStatement pst;
        ArrayList<String[]> tabla = new ArrayList<String[]>();
        //String resultado = "";
        //resultado += "Consulta : "+sql+"\n";
        try {
            //int registros = 0;
            pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData rsm = rs.getMetaData();
            /* for(int i= 1; i<=rsm.getColumnCount(); i++){
                resultado += ""+rsm.getColumnName(i)+ "|";
            }*/
            //resultado += "\n";
            while (rs.next()) {
                String[] fila = new String[rsm.getColumnCount()];
                for (int i = 1; i <= rsm.getColumnCount(); i++) {
                    fila[i - 1] = rs.getString(i);
                }
                tabla.add(fila);
                //resultado += "\n";
                //registros++;
                //System.out.println("");
            }
            //resultado += "\n Cantidad De Registros :"+ registros;
            //resultado += "-------------------------\n";
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tabla;
    }

    public void Sentencia(String sql) {
        PreparedStatement pst;
        System.out.println("Sentencia : " + sql + "\n");
        try {
            pst = con.prepareStatement(sql); //Preparo la sentencia sql a ejecutar
            int registros = pst.executeUpdate(); //Obtengo datos de consulta - Cuento los regs
            System.out.println("\nCantidad de registros afectados : " + registros);
            System.out.println("------------------------------------------------- \n");
            pst.close(); //Libero datos del PreparedStatement, tambien se libera ResultSet
        } catch (SQLException e) {
            e.printStackTrace(); // Capturo la excepcion en caso de error
        }

    }

}
