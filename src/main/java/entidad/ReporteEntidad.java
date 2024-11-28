/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidad;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Beto_
 */
@Entity
public class ReporteEntidad implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "titulo", nullable = false, length = 50)
    private String titulo;
    
    @Column(name = "descripcion", nullable = false, length = 600)
    private String descripcion;
    
    @Column(name = "likes", nullable = false)
    private int likes;
    
    @Column(name = "fecha", columnDefinition = "DATE")
    private LocalDate fecha;
    
    @Column(name = "calle", nullable = false, length = 80)
    private String calle;
    
    //private ImageIcon imagen;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntidad usuario;

    public ReporteEntidad() {
        this.fecha = LocalDate.now();
        this.likes = 0;
    }

    public ReporteEntidad(String titulo, String calle, String descripcion, UsuarioEntidad usuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.fecha = LocalDate.now();
        this.calle = calle;
        this.likes = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public UsuarioEntidad getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntidad usuario) {
        this.usuario = usuario;
    }
}
