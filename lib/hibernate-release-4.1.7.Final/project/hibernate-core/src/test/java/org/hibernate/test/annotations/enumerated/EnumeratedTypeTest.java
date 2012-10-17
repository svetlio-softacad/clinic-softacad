package org.hibernate.test.annotations.enumerated;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.mapping.PersistentClass;
import org.hibernate.testing.junit4.BaseCoreFunctionalTestCase;
import org.hibernate.type.EnumType;
import org.hibernate.type.Type;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.hibernate.test.annotations.enumerated.EntityEnum.*;

/**
 * Test type definition for enum
 * 
 * @author Janario Oliveira
 */
public class EnumeratedTypeTest extends BaseCoreFunctionalTestCase {

	@Test
	public void testTypeDefinition() {
		Configuration cfg = configuration();
		PersistentClass pc = cfg.getClassMapping( EntityEnum.class.getName() );

		// ordinal default of EnumType
		Type ordinalEnum = pc.getProperty( "ordinal" ).getType();
		assertEquals( Common.class, ordinalEnum.getReturnedClass() );
		assertEquals( EnumType.class.getName(), ordinalEnum.getName() );

		// string defined by Enumerated(STRING)
		Type stringEnum = pc.getProperty( "string" ).getType();
		assertEquals( Common.class, stringEnum.getReturnedClass() );
		assertEquals( EnumType.class.getName(), stringEnum.getName() );

		// explicit defined by @Type
		Type first = pc.getProperty( "firstLetter" ).getType();
		assertEquals( FirstLetter.class, first.getReturnedClass() );
		assertEquals( FirstLetterType.class.getName(), first.getName() );

		// implicit defined by @TypeDef in somewhere
		Type last = pc.getProperty( "lastNumber" ).getType();
		assertEquals( LastNumber.class, last.getReturnedClass() );
		assertEquals( LastNumberType.class.getName(), last.getName() );

		// implicit defined by @TypeDef in anywhere, but overrided by Enumerated(STRING)
		Type implicitOverrideExplicit = pc.getProperty( "explicitOverridingImplicit" ).getType();
		assertEquals( LastNumber.class, implicitOverrideExplicit.getReturnedClass() );
		assertEquals( EnumType.class.getName(), implicitOverrideExplicit.getName() );
	}

	@Test
	public void testTypeQuery() {
		Session session = openSession();
		session.getTransaction().begin();

		// persist
		EntityEnum entityEnum = new EntityEnum();
		entityEnum.setOrdinal( Common.A2 );
		Serializable id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createQuery( "from EntityEnum ee where ee.ordinal=1" ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( Common.A2, entityEnum.getOrdinal() );
		// find parameter
		entityEnum = (EntityEnum) session.createQuery( "from EntityEnum ee where ee.ordinal=:ordinal" )
				.setParameter( "ordinal", Common.A2 ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( Common.A2, entityEnum.getOrdinal() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where ordinal=1" ).executeUpdate() );

		session.getTransaction().commit();
		session.close();

		// **************
		session = openSession();
		session.getTransaction().begin();

		// persist
		entityEnum = new EntityEnum();
		entityEnum.setString( Common.B1 );
		id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createQuery( "from EntityEnum ee where ee.string='B1'" ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( Common.B1, entityEnum.getString() );
		// find parameter
		entityEnum = (EntityEnum) session.createQuery( "from EntityEnum ee where ee.string=:string" )
				.setParameter( "string", Common.B1 ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( Common.B1, entityEnum.getString() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where string='B1'" ).executeUpdate() );
		session.getTransaction().commit();
		session.close();

		// **************
		session = openSession();
		session.getTransaction().begin();

		// persist
		entityEnum = new EntityEnum();
		entityEnum.setFirstLetter( FirstLetter.C_LETTER );
		id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createQuery( "from EntityEnum ee where ee.firstLetter='C'" ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( FirstLetter.C_LETTER, entityEnum.getFirstLetter() );
		// find parameter
		entityEnum = (EntityEnum) session.createQuery( "from EntityEnum ee where ee.firstLetter=:firstLetter" )
				.setParameter( "firstLetter", FirstLetter.C_LETTER ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( FirstLetter.C_LETTER, entityEnum.getFirstLetter() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where firstLetter='C'" ).executeUpdate() );

		session.getTransaction().commit();
		session.close();

		// **************
		session = openSession();
		session.getTransaction().begin();

		// persist
		entityEnum = new EntityEnum();
		entityEnum.setLastNumber( LastNumber.NUMBER_1 );
		id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createQuery( "from EntityEnum ee where ee.lastNumber='1'" ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( LastNumber.NUMBER_1, entityEnum.getLastNumber() );
		// find parameter
		entityEnum = (EntityEnum) session.createQuery( "from EntityEnum ee where ee.lastNumber=:lastNumber" )
				.setParameter( "lastNumber", LastNumber.NUMBER_1 ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( LastNumber.NUMBER_1, entityEnum.getLastNumber() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where lastNumber='1'" ).executeUpdate() );

		session.getTransaction().commit();
		session.close();

		// **************
		session = openSession();
		session.getTransaction().begin();

		// persist
		entityEnum = new EntityEnum();
		entityEnum.setExplicitOverridingImplicit( LastNumber.NUMBER_2 );
		id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createQuery(
				"from EntityEnum ee where ee.explicitOverridingImplicit='NUMBER_2'" ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( LastNumber.NUMBER_2, entityEnum.getExplicitOverridingImplicit() );
		// find parameter
		entityEnum = (EntityEnum) session
				.createQuery( "from EntityEnum ee where ee.explicitOverridingImplicit=:override" )
				.setParameter( "override", LastNumber.NUMBER_2 ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( LastNumber.NUMBER_2, entityEnum.getExplicitOverridingImplicit() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where explicitOverridingImplicit='NUMBER_2'" )
				.executeUpdate() );

		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testTypeCriteria() {
		Session session = openSession();
		session.getTransaction().begin();

		// persist
		EntityEnum entityEnum = new EntityEnum();
		entityEnum.setOrdinal( Common.A1 );
		Serializable id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createCriteria( EntityEnum.class )
				.add( Restrictions.eq( "ordinal", Common.A1 ) ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( Common.A1, entityEnum.getOrdinal() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where ordinal=0" ).executeUpdate() );

		session.getTransaction().commit();
		session.close();

		// **************
		session = openSession();
		session.getTransaction().begin();

		// persist
		entityEnum = new EntityEnum();
		entityEnum.setString( Common.B2 );
		id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createCriteria( EntityEnum.class )
				.add( Restrictions.eq( "string", Common.B2 ) ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( Common.B2, entityEnum.getString() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where string='B2'" ).executeUpdate() );

		session.getTransaction().commit();
		session.close();

		// **************
		session = openSession();
		session.getTransaction().begin();

		// persist
		entityEnum = new EntityEnum();
		entityEnum.setFirstLetter( FirstLetter.A_LETTER );
		id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createCriteria( EntityEnum.class )
				.add( Restrictions.eq( "firstLetter", FirstLetter.A_LETTER ) ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( FirstLetter.A_LETTER, entityEnum.getFirstLetter() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where firstLetter='A'" ).executeUpdate() );

		session.getTransaction().commit();
		session.close();

		// **************
		session = openSession();
		session.getTransaction().begin();

		// persist
		entityEnum = new EntityEnum();
		entityEnum.setLastNumber( LastNumber.NUMBER_3 );
		id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createCriteria( EntityEnum.class )
				.add( Restrictions.eq( "lastNumber", LastNumber.NUMBER_3 ) ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( LastNumber.NUMBER_3, entityEnum.getLastNumber() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where lastNumber='3'" ).executeUpdate() );

		session.getTransaction().commit();
		session.close();

		// **************
		session = openSession();
		session.getTransaction().begin();

		// persist
		entityEnum = new EntityEnum();
		entityEnum.setExplicitOverridingImplicit( LastNumber.NUMBER_2 );
		id = session.save( entityEnum );

		session.getTransaction().commit();
		session.close();
		session = openSession();
		session.getTransaction().begin();

		// find
		entityEnum = (EntityEnum) session.createCriteria( EntityEnum.class )
				.add( Restrictions.eq( "explicitOverridingImplicit", LastNumber.NUMBER_2 ) ).uniqueResult();
		assertEquals( id, entityEnum.getId() );
		assertEquals( LastNumber.NUMBER_2, entityEnum.getExplicitOverridingImplicit() );
		// delete
		assertEquals( 1, session.createSQLQuery( "DELETE FROM EntityEnum where explicitOverridingImplicit='NUMBER_2'" )
				.executeUpdate() );

		session.getTransaction().commit();
		session.close();

	}

	@Override
	protected Class[] getAnnotatedClasses() {
		return new Class[] { EntityEnum.class };
	}
}
