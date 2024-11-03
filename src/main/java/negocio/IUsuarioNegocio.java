/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.UsuarioDTO;

/**
 *
 * @author Beto_
 */
public interface IUsuarioNegocio {
    public void validarRegistro(UsuarioDTO usuarioDTO) throws NegocioException;
    
    public void iniciaSesion(UsuarioDTO usuarioDTO) throws NegocioException;
}
