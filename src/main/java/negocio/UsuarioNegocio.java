/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.UsuarioDTO;
import entidad.UsuarioEntidad;
import javax.persistence.EntityManager;
import subsistemaUsuario.IUsuarioDAO;
import subsistemaReporte.PersistenciaException;
import subsistemaUsuario.UsuarioDAO;

/**
 *
 * @author Beto_
 */
public class UsuarioNegocio implements IUsuarioNegocio{
    private UsuarioCvr usuarioCvr;
    private IUsuarioDAO usuarioDAO;

    public UsuarioNegocio(EntityManager entityManager) {
        this.usuarioCvr = new UsuarioCvr();
        this.usuarioDAO = new UsuarioDAO(entityManager);
    }

    @Override
    public void validarRegistro(UsuarioDTO usuarioDTO) throws NegocioException {
        // Validar campos obligatorios
        if (usuarioDTO.getAlias() == null || usuarioDTO.getAlias().isEmpty()) {
            throw new NegocioException("El Alias es obligatorio.");
        }

        String contrasena = usuarioDTO.getContrasena();
        if (contrasena == null || contrasena.isEmpty()) {
            throw new NegocioException("La contraseña es obligatoria.");
        }

        // Validación de contraseña (mínimo 8 caracteres, al menos una letra y un número)
        if (contrasena.length() < 8 || !contrasena.matches(".*[a-zA-Z].*") || !contrasena.matches(".*\\d.*")) {
            throw new NegocioException("La contraseña debe tener al menos 8 caracteres, incluyendo letras y números.");
        }
        try{
            //Alias repetido
            usuarioDAO.guardar(usuarioDTO);
        }catch(PersistenciaException pe){
            System.out.println("Error en capa persistencia: " + pe.getMessage()
            );
        }
    }

    @Override
    public void iniciaSesion(UsuarioDTO usuarioDTO) throws NegocioException{
        // Validar campos obligatorios
        if (usuarioDTO.getAlias() == null || usuarioDTO.getAlias().isEmpty()) {
            throw new NegocioException("El Alias es obligatorio.");
        }

        String contrasena = usuarioDTO.getContrasena();
        if (contrasena == null || contrasena.isEmpty()) {
            throw new NegocioException("La contraseña es obligatoria.");
        }
        
        //obtener alias
        try{
            UsuarioEntidad usuarioEntidadAux = usuarioDAO.obtenerPorAlias(usuarioDTO.getAlias());
            if(usuarioEntidadAux == null){
                throw new NegocioException("No se encontró ningun usuario con este alias.");
            }
            UsuarioDTO usuarioAux = usuarioCvr.convDTO(usuarioEntidadAux);
            //extraer contraseña
            String contrasenaAlias = usuarioAux.getContrasena();
            
            //comparar contraseña
            if(!contrasena.equalsIgnoreCase(contrasenaAlias)){
                throw new NegocioException("La contraseña no coincide con el alias.");
            }
        }catch(PersistenciaException pe){
            throw new NegocioException("Error en capa persistencia: " + pe.getMessage());
        }
    }

    @Override
    public UsuarioDTO obtenerUsuarioSesion(String alias) throws NegocioException {
        try{
            UsuarioEntidad usuarioEntidadAux = usuarioDAO.obtenerPorAlias(alias);
            if(usuarioEntidadAux == null){
                throw new NegocioException("No se encontró ningun usuario con este alias.");
            }
            UsuarioDTO usuarioAux = usuarioCvr.convDTO(usuarioEntidadAux);
            return usuarioAux;
        }catch(PersistenciaException pe){
            throw new NegocioException("Error en la capa persistencia: " + pe.getMessage());
        }
    }
    
}
