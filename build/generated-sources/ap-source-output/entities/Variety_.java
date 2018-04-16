package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Variety.class)
public abstract class Variety_ {

	public static volatile CollectionAttribute<Variety, Product> productCollection;
	public static volatile SingularAttribute<Variety, Integer> varietyId;
	public static volatile SingularAttribute<Variety, Type> typeId;
	public static volatile SingularAttribute<Variety, String> varietyName;

}

