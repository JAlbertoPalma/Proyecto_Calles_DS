/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.ReporteDTO;
import java.util.List;

/**
 *
 * @author Beto_
 */
public interface IFachadaReporte {
    public void validarCampos(ReporteDTO reporteDTO) throws NegocioException;
    
    public List<ReporteDTO> obtenerReportes() throws NegocioException;
    
    public List<ReporteDTO> obtenerReportesPorCalle(String filtroCalle) throws NegocioException;
    
    public int likearReporte(ReporteDTO reporteDTO, boolean like) throws NegocioException;
    
    public String[] obtenerCalles(double[] coordenadas) throws NegocioException;
}
