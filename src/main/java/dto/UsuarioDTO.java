/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import java.util.Random;

/**
 *
 * @author Beto_
 */
public class UsuarioDTO {
    private int id;
    private String alias;
    private String contraseña;
    //Atributos de mapeo

    public UsuarioDTO() {
        Random random = new Random();
        this.id = random.nextInt(100);
    }
    
    public UsuarioDTO(String alias, String contraseña) {
        Random random = new Random();
        this.id = random.nextInt(100);
        this.alias = alias;
        this.contraseña = contraseña;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UsuarioDTO{" + "alias=" + alias + ", contrase\u00f1a=" + contraseña + '}';
    }
}
