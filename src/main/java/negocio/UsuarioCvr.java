/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.ReporteDTO;
import dto.UsuarioDTO;
import entidad.UsuarioEntidad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beto_
 */
public class UsuarioCvr {

    public UsuarioCvr() {
    }
    
    public UsuarioDTO convDTO(UsuarioEntidad usuarioEntidad){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(usuarioEntidad.getId());
        usuarioDTO.setAlias(usuarioEntidad.getAlias());
        usuarioDTO.setContrasena(usuarioEntidad.getContrasena());
        //convertir lista de reportes en dto
        List<ReporteDTO> reportesDTO = new ArrayList();
        if(!reportesDTO.isEmpty()){
            usuarioDTO.setReportes(reportesDTO);
        }
        return usuarioDTO;
    }
    
//    public UsuarioEntidad convEntidad(UsuarioDTO usuarioDTO){
//        UsuarioEntidad usuarioEntidad = new UsuarioEntidad();
//        
//        return usuarioEntidad;
//    }
}
