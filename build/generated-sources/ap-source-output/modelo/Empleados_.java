package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Buses;
import modelo.Cargo;
import modelo.Nomina;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T16:19:15")
@StaticMetamodel(Empleados.class)
public class Empleados_ { 

    public static volatile SingularAttribute<Empleados, Integer> idempleados;
    public static volatile SingularAttribute<Empleados, Cargo> idcargo;
    public static volatile SingularAttribute<Empleados, Nomina> idnomina;
    public static volatile SingularAttribute<Empleados, Buses> busesIdbuses;
    public static volatile SingularAttribute<Empleados, String> apellido;
    public static volatile SingularAttribute<Empleados, Double> salario;
    public static volatile SingularAttribute<Empleados, String> direccion;
    public static volatile SingularAttribute<Empleados, String> telefono;
    public static volatile SingularAttribute<Empleados, String> nombre;

}