/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dto.ReporteDTO;
import entidad.ReporteEntidad;
import java.util.List;

/**
 *
 * @author Beto_
 */
public interface IFachadaReporte {
    public void guardar(ReporteDTO reporteDTO, Long id_usuario) throws NegocioException;
    
    public void actualizar(Long id, ReporteDTO reporteDTO) throws NegocioException;
    
    public void actualizarEntidad(ReporteEntidad reporteEntidad) throws NegocioException;
    
    public void eliminar(Long id) throws NegocioException;
    
    public ReporteEntidad obtenerPorId(Long id) throws NegocioException;
    
    public List<ReporteEntidad> obtenerReportes() throws NegocioException;
}
