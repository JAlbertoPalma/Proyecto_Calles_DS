/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import dto.UsuarioDTO;
import entidad.UsuarioEntidad;
import java.util.List;

/**
 *
 * @author Beto_
 */
public interface IUsuarioDAO {
    public void guardar(UsuarioDTO usuarioDTO) throws PersistenciaException;
    
    public void actualizar(Long id, UsuarioDTO usuarioDTO) throws PersistenciaException;
    
    public void actualizarEntidad(UsuarioEntidad usuarioEntidad) throws PersistenciaException;
    
    public void eliminar(Long id) throws PersistenciaException;
    
    public UsuarioEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public UsuarioEntidad obtenerPorAlias(String alias) throws PersistenciaException;
    
    public List<UsuarioEntidad> obtenerUsuarios() throws PersistenciaException;
}
