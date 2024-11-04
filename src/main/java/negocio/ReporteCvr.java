/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.ReporteDTO;
import dto.UsuarioDTO;
import entidad.ReporteEntidad;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Beto_
 */
public class ReporteCvr {
    UsuarioCvr usuarioCvr;

    public ReporteCvr() {
        usuarioCvr = new UsuarioCvr();
    }
    
    public ReporteDTO convDTO(ReporteEntidad reporteEntidad){
        ReporteDTO reporteDTO = new ReporteDTO();
        reporteDTO.setId(reporteEntidad.getId());
        reporteDTO.setTitulo(reporteEntidad.getTitulo());
        reporteDTO.setDescripcion(reporteEntidad.getDescripcion());
        reporteDTO.setCalle(reporteEntidad.getCalle());
        reporteDTO.setFecha(reporteEntidad.getFecha());
        reporteDTO.setLikes(reporteEntidad.getLikes());
        UsuarioDTO usuarioDTO = usuarioCvr.convDTO(reporteEntidad.getUsuario());
        reporteDTO.setUsuario(usuarioDTO);
        return reporteDTO;
    }
    
    public List<ReporteDTO> convListaDTO(List<ReporteEntidad> reportesEntidad){
        List<ReporteDTO> reportesDTO = new ArrayList();
        for (ReporteEntidad reporteEntidad : reportesEntidad) {
            reportesDTO.add(convDTO(reporteEntidad));
        }
        return reportesDTO;
    }
}
