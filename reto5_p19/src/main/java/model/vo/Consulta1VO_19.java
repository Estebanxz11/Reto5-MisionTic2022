package model.vo;

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
