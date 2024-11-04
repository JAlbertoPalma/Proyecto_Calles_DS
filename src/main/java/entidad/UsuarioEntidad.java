/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Beto_
 */
@Entity
public class UsuarioEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "alias", nullable = false, length = 50, unique = true)
    private String alias;
    
    @Column(name = "contrasena", nullable = false, length = 50)
    private String contrasena;
    
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<ReporteEntidad> reportes;

    public UsuarioEntidad() {
    }

    public UsuarioEntidad(String alias, String contrasena) {
        this.alias = alias;
        this.contrasena = contrasena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<ReporteEntidad> getReportes() {
        return reportes;
    }

    public void setReportes(List<ReporteEntidad> reportes) {
        this.reportes = reportes;
    }
    
    
}
