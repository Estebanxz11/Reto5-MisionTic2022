package model.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.*;

public class Consulta1_19Dao {
    public ArrayList<Consulta1VO_19> consulta1DAO() throws SQLException {

        ArrayList<Consulta1VO_19> response = new ArrayList<>();
        String consulta = "SELECT ID_Proyecto, Fecha_Inicio , Constructora, Serial FROM Proyecto WHERE ID_Proyecto < 15";
       
        try(Connection conn = JDBCUtilities.getConnection();
        PreparedStatement statement = conn.prepareStatement(consulta);
        ResultSet rset = statement.executeQuery();){
            
           while (rset.next()) {
               Consulta1VO_19 consulta1_VO = new Consulta1VO_19();
               consulta1_VO.setId(rset.getInt("ID_Proyecto"));
               consulta1_VO.setFecha_inicio(rset.getString("Fecha_Inicio"));
               consulta1_VO.setConstructora(rset.getString("Constructora"));
               consulta1_VO.setSerial(rset.getString("Serial"));

               response.add(consulta1_VO);

           }
        }
        return response;

        
    }  
}
