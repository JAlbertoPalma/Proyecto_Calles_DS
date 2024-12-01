package entidad;

import entidad.UsuarioEntidad;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-11-30T21:35:09", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(ReporteEntidad.class)
public class ReporteEntidad_ { 

    public static volatile SingularAttribute<ReporteEntidad, String> descripcion;
    public static volatile SingularAttribute<ReporteEntidad, LocalDate> fecha;
    public static volatile SingularAttribute<ReporteEntidad, String> calle;
    public static volatile SingularAttribute<ReporteEntidad, String> titulo;
    public static volatile SingularAttribute<ReporteEntidad, UsuarioEntidad> usuario;
    public static volatile SingularAttribute<ReporteEntidad, Long> id;
    public static volatile SingularAttribute<ReporteEntidad, Integer> likes;

}