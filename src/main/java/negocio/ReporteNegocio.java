/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dto.ReporteDTO;
import javax.persistence.EntityManager;
import persistencia.IReporteDAO;
import persistencia.IUsuarioDAO;
import persistencia.PersistenciaException;
import persistencia.ReporteDAO;
import persistencia.UsuarioDAO;

/**
 *
 * @author Beto_
 */
public class ReporteNegocio implements IReporteNegocio{
    EntityManager entityManager;
    IReporteDAO reporteDAO;
    IUsuarioDAO usuarioDAO;

    public ReporteNegocio(EntityManager entityManager, Long id) {
        this.entityManager = entityManager;
        reporteDAO = new ReporteDAO(entityManager);
        usuarioDAO = new UsuarioDAO(entityManager);
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
    }
    
}
