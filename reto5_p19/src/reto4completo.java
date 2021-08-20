//Librerías
import java.util.ArrayList;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
//Vista
//Clase de la vista y su respectiva implementación


public class VistaRequerimientosReto4 {
    
    public static final ControladorRequerimientosReto4 controlador = new ControladorRequerimientosReto4();


    public static void consulta1(){
        System.out.println("-----Consulta 1-------"); 
        try{

            ArrayList<Consulta1VO_19> requerimiento_1s = controlador.consultarConsulta1();

            //ArrayList<Consulta1VO_19> lista = controlador.realizarConsulta1();
            //ArrayList<Consulta1VO_19> lista = controlador.consultarConsulta1();
            
            //Encabezado del resultado
            System.out.println("id_proyecto, Fecha_Inicio , Constructora , serial");
            
            //Cada VO cargado, mostrarlo en la vista
            for (Consulta1VO_19 consulta1vo_19 : requerimiento_1s) {
                System.out.printf("%d %s %s %s %n" ,consulta1vo_19.getId(), consulta1vo_19.getFecha_inicio(), consulta1vo_19.getConstructora(), consulta1vo_19.getSerial());
                
            }
            
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }

    public static void consulta2(){
        System.out.println("-----Consulta 2-------"); 
        try{

           ArrayList<Consulta2VO_19> requerimiento_2s = controlador.consultarConsulta2();
            //ArrayList<Consulta2VO_19> lista = controlador.realizarConsulta2();
            //ArrayList<Consulta2VO_19> lista = controlador.consultarConsulta2();

            
            //Encabezado del resultado
            System.out.println("id_proyecto, area_max");
            
            //Cada VO cargado, mostrarlo en la vista
            for (Consulta2VO_19 consulta2vo_19 : requerimiento_2s) {
                System.out.printf("%d %d %n" ,consulta2vo_19.getId(), consulta2vo_19.getArea_max());
                
            }
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }


    public static void consulta3(){
        System.out.println("-----Consulta 3-------"); 
        try{

            ArrayList<Consulta3VO_19> requerimiento_3s = controlador.consultarConsulta3();

            //ArrayList<Consulta3VO_19> lista = controlador.realizarConsulta3();
            
            //Encabezado del resultado
            System.out.println("id_proyecto, nombreapellido");
            
            //Cada VO cargado, mostrarlo en la vista
            for (Consulta3VO_19 consulta3vo_19 : requerimiento_3s) {
                System.out.printf("%d %s %n" ,consulta3vo_19.getId(), consulta3vo_19.getNombreapellido());
                
            }
            
            
        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }      
    }
}

//Controlador
//Clase del controlador y su respectiva implementación
//Estructuras de datos (colecciones)


//Modelos (acceso y objetos contenedores)

//Librerías para bases de datos


public class ControladorRequerimientosReto4 {  
    private Consulta1_19Dao consulta1_19Dao; 
    private Consulta2_19Dao consulta2_19Dao; 
    private Consulta3_19Dao consulta3_19Dao; 

    public ControladorRequerimientosReto4(){
        this.consulta1_19Dao = new Consulta1_19Dao();
        this.consulta2_19Dao = new Consulta2_19Dao();
        this.consulta3_19Dao = new Consulta3_19Dao();
    }   
    
    public ArrayList<Consulta1VO_19> consultarConsulta1() throws SQLException{
        return consulta1_19Dao.consulta1DAO();
    }
    public ArrayList<Consulta2VO_19> consultarConsulta2() throws SQLException{
        return consulta2_19Dao.consulta2DAO();
    }
    public ArrayList<Consulta3VO_19> consultarConsulta3() throws SQLException{
        return consulta3_19Dao.consulta3DAO();
    }

    
}

//DAO's
//Clase de los DAOs y su respectiva implementación, son 3 DAOs, uno por cada consulta.

//Estructura de datos


//Librerías para SQL y Base de Datos

//Clase para conexión


//Encapsulamiento de los datos


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

//Estructura de datos


//Librerías para SQL y Base de Datos

//Clase para conexión


//Encapsulamiento de los datos


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


//Estructura de datos

//Librerías para SQL y Base de Datos

//Clase para conexión


//Encapsulamiento de los datos


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

//VO's
//Clase de los VOs y su respectiva implementación, son 3 VOs, uno por cada consulta.

public class Consulta1VO_19 {
    private Integer id_proyecto;
    private String fecha_inicio;
    private String constructora;
    private String serial;

//setters and getters
    public Integer getId() {
        return id_proyecto;
    }
    public void setId(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getFecha_inicio(){
        return fecha_inicio;
    }
    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getConstructora() {
        return constructora;
        
    }
    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getSerial() {
        return serial;
        
    }
    public void setSerial(String serial){
        this.serial = serial;
    }

}

public class Consulta2VO_19 {
    private Integer id_proyecto;
    private Integer area_max;

    //setters and getters
    public Integer getId() {
        return id_proyecto;
    }
    public void setId(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public Integer getArea_max() {
        return area_max;
        
    }
    public void setArea_max(Integer area_max) {
        this.area_max = area_max;
        
    }

    
}
public class Consulta3VO_19 {
    private Integer id_proyecto;
    private String nombreapellido;
    

      //setters and getters
    public Integer getId() {
        return id_proyecto;
    }
    public void setId(Integer id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public String getNombreapellido() {
        return nombreapellido;
    }
    public void setNombreapellido(String nombreapellido) {
        this.nombreapellido = nombreapellido;
    }

    
}
//JDBC utilities
public class JDBCUtilities {
 private static final String UBICACION_BD = "ProyectosConstruccion.db"; 
 public static Connection getConnection() throws SQLException {
 String url = "jdbc:sqlite:" + UBICACION_BD;
 return DriverManager.getConnection(url);
 }
 public static boolean estaVacia(){
 File archivo = new File(JDBCUtilities.UBICACION_BD);
 // //Salida de diagnóstixo
 // System.out.println("UBICACION -> "+ JDBCUtilities.UBICACION_BD);
 // System.out.println("Longitud -> "+ archivo.length());
 return archivo.length() == 0;
 }
}
