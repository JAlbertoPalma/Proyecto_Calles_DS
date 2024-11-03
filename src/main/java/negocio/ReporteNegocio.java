/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.ReporteDTO;
import persistencia.PersistenciaException;

/**
 *
 * @author Beto_
 */
public class ReporteNegocio implements IReporteNegocio{

    @Override
    public void validarCampos(ReporteDTO reporteDTO) throws NegocioException {
        // Validar campos obligatorios
        if (reporteDTO.getTitulo() == null || reporteDTO.getTitulo().isEmpty()) {
            throw new NegocioException("El titulo del reporte es obligatorio.");
        }
        
        if (reporteDTO.getDescripcion() == null || reporteDTO.getDescripcion().isEmpty()) {
            throw new NegocioException("La descripción del reporte es obligatoria.");
        }
        
        if (reporteDTO.getFecha() == null) {
            throw new NegocioException("La fecha del reporte es obligatoria.");
        }
        
        if (reporteDTO.getCalle() == null || reporteDTO.getCalle().isEmpty()) {
            throw new NegocioException("La calle del reporte es obligatoria.");
        }
    }
    
}
