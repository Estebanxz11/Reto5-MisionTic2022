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

public class Consulta2_19Dao {
    public ArrayList<Consulta2VO_19> consulta2DAO() throws SQLException {
        ArrayList<Consulta2VO_19> response = new ArrayList<Consulta2VO_19>();
        String consulta = "SELECT p.ID_Proyecto, t.Area_Max FROM Proyecto p inner join Tipo t on p.ID_Tipo = t.ID_Tipo WHERE p.Numero_Habitaciones = 2";
       
        try(Connection connection = JDBCUtilities.getConnection();
        PreparedStatement statement = connection.prepareStatement(consulta);
        ResultSet rset = statement.executeQuery();){
            
           while (rset.next()) {
               Consulta2VO_19 consulta2_VO = new Consulta2VO_19();
               consulta2_VO.setId(rset.getInt("ID_Proyecto"));
               consulta2_VO.setArea_max(rset.getInt("Area_max"));
               response.add(consulta2_VO);
           }
        }

        
        return response;

       
        
    }  
}
