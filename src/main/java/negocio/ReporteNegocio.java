/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.ReporteDTO;
import entidad.ReporteEntidad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import subsistemaReporte.IReporteDAO;
import subsistemaUsuario.IUsuarioDAO;
import subsistemaReporte.PersistenciaException;
import subsistemaReporte.ReporteDAO;
import subsistemaUsuario.UsuarioDAO;

/**
 *
 * @author Beto_
 */
public class ReporteNegocio implements IReporteNegocio{
//    EntityManager entityManager;
    IReporteDAO reporteDAO;
    private ReporteCvr reporteCvr;
//    IUsuarioDAO usuarioDAO;

    public ReporteNegocio(EntityManager entityManager) {
//        this.entityManager = entityManager;
        reporteDAO = new ReporteDAO(entityManager);
        this.reporteCvr = new ReporteCvr();
//        usuarioDAO = new UsuarioDAO(entityManager);
    }

    @Override
    public void validarCampos(ReporteDTO reporteDTO) throws NegocioException {
        // Validar campos obligatorios
        if (reporteDTO.getTitulo() == null || reporteDTO.getTitulo().isEmpty()) {
            throw new NegocioException("El titulo del reporte es obligatorio.");
        }
        
        if (reporteDTO.getDescripcion() == null || reporteDTO.getDescripcion().isEmpty()) {
            throw new NegocioException("La descripción del reporte es obligatoria.");
        }
        
        if (reporteDTO.getCalle() == null || reporteDTO.getCalle().isEmpty()) {
            throw new NegocioException("La calle del reporte es obligatoria.");
        }
        try{
            //Alias repetido
            reporteDAO.guardar(reporteDTO, reporteDTO.getUsuario().getId());
        }catch(PersistenciaException pe){
            throw new NegocioException("Error en la capa persistencia :" + pe.getMessage());
        }        
    }
    
    @Override
    public List<ReporteDTO> obtenerReportes() throws NegocioException{
        try{
            return reporteCvr.convListaDTO(reporteDAO.obtenerReportes());
        }catch(PersistenciaException pe){
            throw new NegocioException("Error en la capa persistencia :" + pe.getMessage());
        }
    }

    @Override
    public int likearReporte(ReporteDTO reporteDTO, boolean like) throws NegocioException {
        try{
            if(!like){
                reporteDTO.setLikes(reporteDTO.getLikes() + 1);
                reporteDAO.actualizar(reporteDTO.getId(), reporteDTO);
            }
            else if(like && reporteDTO.getLikes() > 0){
                reporteDTO.setLikes(reporteDTO.getLikes() - 1);
                reporteDAO.actualizar(reporteDTO.getId(), reporteDTO);
            }
            return reporteDTO.getLikes();
        }catch(PersistenciaException pe){
            throw new NegocioException("Error en la capa persistencia: " + pe.getMessage());
        }
    }
}
