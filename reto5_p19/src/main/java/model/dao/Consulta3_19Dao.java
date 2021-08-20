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

public class Consulta3_19Dao {
    public ArrayList<Consulta3VO_19> consulta3DAO() throws SQLException {
        ArrayList<Consulta3VO_19> response = new ArrayList<Consulta3VO_19>();
        String consulta = "SELECT p.ID_Proyecto, l.Nombre || ' ' || l.Primer_Apellido as nombreapellido FROM Proyecto p inner join Lider l on p.ID_Lider = l.ID_Lider WHERE Banco_Vinculado ='Bancolombia'";
       
        try(Connection connection = JDBCUtilities.getConnection();
        PreparedStatement statement = connection.prepareStatement(consulta);
        ResultSet rset = statement.executeQuery();){
            
           while (rset.next()) {
               Consulta3VO_19 consulta3_VO = new Consulta3VO_19();
               consulta3_VO.setId(rset.getInt("ID_Proyecto"));
               consulta3_VO.setNombreapellido(rset.getString("nombreapellido"));
               response.add(consulta3_VO);
               
           }
        }

        
        return response;

       
    }  
}
