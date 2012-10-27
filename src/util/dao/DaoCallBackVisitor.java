package util.dao;

import org.hibernate.Query;
import org.hibernate.Session;

public interface DaoCallBackVisitor {
	public Query visit(Session session);
}
