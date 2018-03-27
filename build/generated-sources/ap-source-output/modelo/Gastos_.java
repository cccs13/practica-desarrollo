package modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import modelo.Buses;
import modelo.Nomina;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-03-18T16:19:15")
@StaticMetamodel(Gastos.class)
public class Gastos_ { 

    public static volatile SingularAttribute<Gastos, Integer> idgastos;
    public static volatile SingularAttribute<Gastos, String> descripcion;
    public static volatile SingularAttribute<Gastos, Double> valor;
    public static volatile SingularAttribute<Gastos, Buses> idbuses;
    public static volatile CollectionAttribute<Gastos, Nomina> nominaCollection;

}