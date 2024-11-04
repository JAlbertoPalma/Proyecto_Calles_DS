/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.UsuarioDTO;
import javax.persistence.EntityManager;
import persistencia.IUsuarioDAO;
import persistencia.PersistenciaException;
import persistencia.UsuarioDAO;

/**
 *
 * @author Beto_
 */
public class UsuarioNegocio implements IUsuarioNegocio{
    private EntityManager entityManager;
    private UsuarioCvr usuarioCvr;
    private IUsuarioDAO usuarioDAO;

    public UsuarioNegocio(EntityManager entityManager) {
        this.entityManager = entityManager;
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
            UsuarioDTO usuarioAux = usuarioCvr.convDTO(usuarioDAO.obtenerPorAlias(usuarioDTO.getAlias()));
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
    
}
