/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.UsuarioDTO;
import javax.persistence.EntityManager;

/**
 *
 * @author Beto_
 */
public class FachadaUsuario implements IFachadaUsuario{
    IUsuarioNegocio usuarioNegocio;

    public FachadaUsuario(EntityManager entityManager) {
        usuarioNegocio = new UsuarioNegocio(entityManager);
    }

    @Override
    public void validarRegistro(UsuarioDTO usuarioDTO) throws NegocioException {
        usuarioNegocio.validarRegistro(usuarioDTO);
    }

    @Override
    public void iniciaSesion(UsuarioDTO usuarioDTO) throws NegocioException {
        usuarioNegocio.iniciaSesion(usuarioDTO);
    }

    @Override
    public UsuarioDTO obtenerUsuarioSesion(String alias) throws NegocioException {
        return usuarioNegocio.obtenerUsuarioSesion(alias);
    }
}
