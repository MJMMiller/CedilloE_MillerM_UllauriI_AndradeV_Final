/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package est.ups.edu.ec.cedilloe_millerm_final.model;

import java.time.LocalDateTime;

/**
 *
 * @author Mateo
 */
public class Log {

    private int id;
    private String usuario;
    private String fechaHora;
    private String accion;
    private String descripcion;

    public Log(int id, String usuario, String fechaHora, String accion, String descripcion) {
        this.id = id;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.accion = accion;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public String getAccion() {
        return accion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
