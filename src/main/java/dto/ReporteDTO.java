/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.time.LocalDate;
import java.util.Random;
/**
 *
 * @author Beto_
 */
public class ReporteDTO {
    private int id;
    private String titulo;
    private String descripcion;
    private LocalDate fecha;
    //private ImageIcon imagen;
    private int likes; //mapeo bd
    private String calle; //mapeo bd

    public ReporteDTO() {
        Random random = new Random();
        this.id = random.nextInt(100);
        this.fecha = LocalDate.now();
    }

    public ReporteDTO(String titulo, String calle, String descripcion) {
        Random random = new Random();
        this.id = random.nextInt(100);
        this.titulo = titulo;
        this.calle = calle;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "ReporteDTO{" + "id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", descripcion=" + fecha + ", likes=" + likes + ", calle=" + calle + '}';
    }
}
