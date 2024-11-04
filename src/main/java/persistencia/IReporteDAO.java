/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package persistencia;

import dto.ReporteDTO;
import entidad.ReporteEntidad;
import java.util.List;

/**
 *
 * @author Beto_
 */
public interface IReporteDAO {
    public void guardar(ReporteDTO reporteDTO, Long id_usuario) throws PersistenciaException;
    
    public void actualizar(Long id, ReporteDTO reporteDTO) throws PersistenciaException;
    
    public void actualizarEntidad(ReporteEntidad reporteEntidad) throws PersistenciaException;
    
    public void eliminar(Long id) throws PersistenciaException;
    
    public ReporteEntidad obtenerPorId(Long id) throws PersistenciaException;
    
    public List<ReporteEntidad> obtenerReportes() throws PersistenciaException;
}
