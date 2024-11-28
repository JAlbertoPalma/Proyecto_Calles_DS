/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package subsistemaUsuario;

import dto.UsuarioDTO;
import entidad.UsuarioEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import subsistemaReporte.PersistenciaException;

/**
 *
 * @author Beto_
 */
public class UsuarioDAO implements IUsuarioDAO{
    private EntityManager entityManager;
    
    /**
     * Construye un usuarioDAO con un entityManager
     * inicializando los DAO de sus atributos con este mismo
     * @param entityManager el entityManager
     */
    public UsuarioDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void guardar(UsuarioDTO usuarioDTO) throws PersistenciaException {
        try{
            entityManager.getTransaction().begin();

            UsuarioEntidad usuario = new UsuarioEntidad(
                    usuarioDTO.getAlias(),
                    usuarioDTO.getContrasena());
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException(e.getMessage());
        }
    }

    @Override
    public void actualizar(Long id, UsuarioDTO usuarioDTO) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el estudiante a actualizar
            UsuarioEntidad usuarioBuscado = obtenerPorId(id);
            
            //Se actualizan los valores del reporte
            usuarioBuscado.setAlias(usuarioDTO.getAlias());
            usuarioBuscado.setContrasena(usuarioDTO.getContrasena());
            
            entityManager.merge(usuarioBuscado);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public void actualizarEntidad(UsuarioEntidad usuarioEntidad) throws PersistenciaException {
        try{
            entityManager.merge(usuarioEntidad);
        }catch(Exception e){
            e.printStackTrace();
            throw new PersistenciaException("No se pudo actualizar la entidad");
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        try{
            //Se inicial la transacción
            entityManager.getTransaction().begin();

            //Se busca el reporte a eliminar
            UsuarioEntidad usuarioBuscado = obtenerPorId(id);
            
            //Elimina el reporte y termina la transacción
            entityManager.remove(usuarioBuscado);
            entityManager.getTransaction().commit();
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }

    @Override
    public UsuarioEntidad obtenerPorId(Long id) throws PersistenciaException {
        UsuarioEntidad usuarioBuscado = entityManager.find(UsuarioEntidad.class, id);
        if(usuarioBuscado == null){
            throw new PersistenciaException("No se encontró al estudiante con el id");
        }
        return usuarioBuscado;
    }
    
    @Override
    public UsuarioEntidad obtenerPorAlias(String alias) throws PersistenciaException {
        List<UsuarioEntidad> usuarios = obtenerUsuarios();
        for (UsuarioEntidad usuario : usuarios) {
            if(usuario.getAlias().equalsIgnoreCase(alias)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public List<UsuarioEntidad> obtenerUsuarios() throws PersistenciaException {
        List<UsuarioEntidad> usuarios = entityManager.createQuery("SELECT e FROM UsuarioEntidad e", UsuarioEntidad.class)
                .getResultList();
        if(usuarios == null || usuarios.isEmpty()){
            throw new PersistenciaException("No hay usuarios por mostrar");
        }
        return usuarios;
    }
    
}
