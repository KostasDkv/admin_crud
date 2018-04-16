package entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Type.class)
public abstract class Type_ {

	public static volatile SingularAttribute<Type, String> typeName;
	public static volatile CollectionAttribute<Type, Variety> varietyCollection;
	public static volatile SingularAttribute<Type, Integer> typeId;
	public static volatile SingularAttribute<Type, Category> categoryId;

}

