/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.ReporteDTO;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Beto_
 */
public class FachadaReporte implements IFachadaReporte{
    IReporteNegocio reporteNegocio;    
    
    public FachadaReporte(EntityManager entityManager) {
        reporteNegocio = new ReporteNegocio(entityManager);
    }
    
    @Override
    public void validarCampos(ReporteDTO reporteDTO) throws NegocioException {
        reporteNegocio.validarCampos(reporteDTO);
    }

    @Override
    public List<ReporteDTO> obtenerReportes() throws NegocioException {
        return reporteNegocio.obtenerReportes();
    }

    @Override
    public List<ReporteDTO> obtenerReportesPorCalle(String filtroCalle) throws NegocioException {
        return reporteNegocio.obtenerReportesPorCalle(filtroCalle);
    }

    @Override
    public int likearReporte(ReporteDTO reporteDTO, boolean like) throws NegocioException {
        return reporteNegocio.likearReporte(reporteDTO, like);
    }

    @Override
    public String[] obtenerCalles(double[] coordenadas) throws NegocioException {
        return reporteNegocio.obtenerCalles(coordenadas);
    }
    
    
}
