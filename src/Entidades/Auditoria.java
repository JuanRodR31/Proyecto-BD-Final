package Entidades;

import java.sql.Timestamp;

public class Auditoria {
    private int idItemModificado;
    private String tabla;
    private String tipoModificacion;
    private Timestamp fechaHora;

    public Auditoria() {
    }

    public Auditoria(int idItemModificado, String tabla, String tipoModificacion, Timestamp fechaHora) {
        this.idItemModificado = idItemModificado;
        this.tabla = tabla;
        this.tipoModificacion = tipoModificacion;
        this.fechaHora = fechaHora;
    }

    public int getIdItemModificado() {
        return idItemModificado;
    }

    public void setIdItemModificado(int idItemModificado) {
        this.idItemModificado = idItemModificado;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getTipoModificacion() {
        return tipoModificacion;
    }

    public void setTipoModificacion(String tipoModificacion) {
        this.tipoModificacion = tipoModificacion;
    }

    public Timestamp getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Timestamp fechaHora) {
        this.fechaHora = fechaHora;
    }
}
