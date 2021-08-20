package view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


import controller.ControladorRequerimientosReto4;
import model.vo.Consulta1VO_19;
import model.vo.Consulta2VO_19;
import model.vo.Consulta3VO_19;

public class VentanaRequerimientos extends JFrame {

    private JTable tabla;
    private ControladorRequerimientosReto4 controlador;

    public VentanaRequerimientos(){
        controlador = new ControladorRequerimientosReto4();
        initUI();
        setLocationRelativeTo(null);
    }

    public void initUI() {
        setTitle("Interfaz Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,600);

        JTabbedPane tbd = new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        tbd.addTab("Consulta Requerimientos", panel);

        JPanel panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Requerimientos "));

        JButton btnConsulta = new JButton("Consulta Requerimieno 1");
        btnConsulta.addActionListener(e -> cargarTablaConsulta());
        panelEntrada.add(btnConsulta);
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        JButton btnConsulta2 = new JButton("Consulta Requerimieno 2");
        btnConsulta2.addActionListener(e -> cargarTablaConsulta2());
        panelEntrada.add(btnConsulta2);
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        JButton btnConsulta3 = new JButton("Consulta Requerimieno 3");
        btnConsulta3.addActionListener(e -> cargarTablaConsulta3());
        panelEntrada.add(btnConsulta3);
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        JButton btnConsulta4 = new JButton("Limpiar");
        btnConsulta4.addActionListener(e -> cargarTablaConsulta4());
        panelEntrada.add(btnConsulta4);
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        
        //Adicionar table

         tabla = new JTable();
         panel.add(new JScrollPane(tabla), BorderLayout.CENTER);


    }

    private void cargarTablaConsulta4() {
        

            Requerimiento4TableModel tableModel = new Requerimiento4TableModel();
            
            tabla.setModel(tableModel);

            
       
    }

    private void cargarTablaConsulta() {
        try {
           ArrayList<Consulta1VO_19> lista = controlador.consultarConsulta1();

            Requerimiento1TableModel tableModel = new Requerimiento1TableModel();

            tableModel.setData(lista);

            tabla.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    private void cargarTablaConsulta2() {
        try {
           ArrayList<Consulta2VO_19> lista = controlador.consultarConsulta2();

            Requerimiento2TableModel tableModel = new Requerimiento2TableModel();

            tableModel.setData(lista);

            tabla.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    private void cargarTablaConsulta3() {
        try {
           ArrayList<Consulta3VO_19> lista = controlador.consultarConsulta3();

            Requerimiento3TableModel tableModel = new Requerimiento3TableModel();

            tableModel.setData(lista);

            tabla.setModel(tableModel);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private class Requerimiento1TableModel extends AbstractTableModel{
        private ArrayList<Consulta1VO_19> data;

        public void setData(ArrayList<Consulta1VO_19> data){
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {

               switch (column) {
                   case 0:
                        return "ID_Proyecto";
                   
                   case 1:
                        return "Fecha Inicio";
                    case 2:
                        return "Constructora";
                    case 3:
                        return "Serial";
           
               }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            
            return data.size();
        }

        @Override
        public int getColumnCount() {
            
            return 4;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
           Consulta1VO_19 registro = data.get(rowIndex);
           switch (columnIndex) {
               case 0:
                    return registro.getId();
                   
               case 1:
                    return registro.getFecha_inicio();
                case 2:
                    return registro.getConstructora();
                case 3:
                    return registro.getSerial();
           
           }


            return null;
        }

    }
    private class Requerimiento2TableModel extends AbstractTableModel{
        private ArrayList<Consulta2VO_19> data;

        public void setData(ArrayList<Consulta2VO_19> data){
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {

               switch (column) {
                   case 0:
                        return "ID_Proyecto";
                   
                   case 1:
                        return "Area Max";
                    
           
               }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            
            return data.size();
        }

        @Override
        public int getColumnCount() {
            
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
           Consulta2VO_19 registro = data.get(rowIndex);
           switch (columnIndex) {
               case 0:
                    return registro.getId();
                   
               case 1:
                    return registro.getArea_max();
               
           
           }


            return null;
        }

    }
    private class Requerimiento3TableModel extends AbstractTableModel{
        private ArrayList<Consulta3VO_19> data;

        public void setData(ArrayList<Consulta3VO_19> data){
            this.data = data;
        }

        @Override
        public String getColumnName(int column) {

               switch (column) {
                   case 0:
                        return "ID_Proyecto";
                   
                   case 1:
                        return "Nombre Apellido";
                    
           
               }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            
            return data.size();
        }

        @Override
        public int getColumnCount() {
            
            return 2;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
           Consulta3VO_19 registro = data.get(rowIndex);
           switch (columnIndex) {
               case 0:
                    return registro.getId();
                   
               case 1:
                    return registro.getNombreapellido();
               
           
           }


            return null;
        }

    }

    private class Requerimiento4TableModel extends AbstractTableModel{

        @Override
        public int getRowCount() {
            
            return 0;
        }

        @Override
        public int getColumnCount() {
            
            return 0;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            // 
            return null;
        }

    }
   
    
}
