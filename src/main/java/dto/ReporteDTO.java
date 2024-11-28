/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
/**
 *
 * @author Beto_
 */
public class ReporteDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    private String calle;
    //private ImageIcon imagen;
    private int likes;
    private UsuarioDTO usuario;

    public ReporteDTO() {
    }

    public ReporteDTO(String titulo, String calle, String descripcion) {
        this.titulo = titulo;
        this.calle = calle;
        this.descripcion = descripcion;
    }

    public ReporteDTO(String titulo, String calle, String descripcion, UsuarioDTO usuario) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.calle = calle;
        this.usuario = usuario;
    }

    public ReporteDTO(Long id, String titulo, String calle, String descripcion, LocalDate fecha, int likes, UsuarioDTO usuario) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.calle = calle;
        this.likes = likes;
        this.usuario = usuario;
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

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "ReporteDTO{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha=" + fecha + ", calle=" + calle + ", likes=" + likes + ", usuario=" + usuario + '}';
    }
}
