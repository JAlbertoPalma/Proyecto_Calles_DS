/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.UsuarioDTO;

/**
 *
 * @author Beto_
 */
public class UsuarioNegocio implements IUsuarioNegocio{

    @Override
    public void validarRegistro(UsuarioDTO usuarioDTO) throws NegocioException {
        //try{
        // Validar campos obligatorios
        if (usuarioDTO.getAlias() == null || usuarioDTO.getAlias().isEmpty()) {
            throw new NegocioException("El Alias es obligatorio.");
        }
        if (usuarioDTO.getContraseña() == null || usuarioDTO.getContraseña().isEmpty()) {
            throw new NegocioException("La contraseña es obligatoria.");
        }
        
        // Validación de contraseña (mínimo 8 caracteres, al menos una letra y un número)
        String contrasena = usuarioDTO.getContraseña();
        if (contrasena.length() < 8 || !contrasena.matches(".*[a-zA-Z].*") || !contrasena.matches(".*\\d.*")) {
            throw new NegocioException("La contraseña debe tener al menos 8 caracteres, incluyendo letras y números.");
        }
        //Llamada a metodo UsuarioDAO para crear
        //catch(PersistenciaException pe){
        //    logger
        //}
    }

    @Override
    public void iniciaSesion(UsuarioDTO usuarioDTO) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
