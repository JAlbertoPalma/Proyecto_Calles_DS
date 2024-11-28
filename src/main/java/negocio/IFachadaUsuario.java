/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.UsuarioDTO;
import entidad.UsuarioEntidad;
import java.util.List;

/**
 *
 * @author Beto_
 */
public interface IFachadaUsuario {
    public void guardar(UsuarioDTO usuarioDTO) throws NegocioException;
    
    public void actualizar(Long id, UsuarioDTO usuarioDTO) throws NegocioException;
    
    public void actualizarEntidad(UsuarioEntidad usuarioEntidad) throws NegocioException;
    
    public void eliminar(Long id) throws NegocioException;
    
    public UsuarioEntidad obtenerPorId(Long id) throws NegocioException;
    
    public UsuarioEntidad obtenerPorAlias(String alias) throws NegocioException;
    
    public List<UsuarioEntidad> obtenerUsuarios() throws NegocioException;
}
