/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Beto_
 */
public class UsuarioDTO {
    private Long id;
    private String alias;
    private String contrasena;
    private List<ReporteDTO> reportes;

    public UsuarioDTO() {
    }
    
    public UsuarioDTO(String alias, String contrasena) {
        this.alias = alias;
        this.contrasena = contrasena;
    }

    public UsuarioDTO(Long id, String alias, String contrasena, List<ReporteDTO> reportes) {
        this.id = id;
        this.alias = alias;
        this.contrasena = contrasena;
        this.reportes = reportes;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ReporteDTO> getReportes() {
        return reportes;
    }

    public void setReportes(List<ReporteDTO> reportes) {
        this.reportes = reportes;
    }
}
