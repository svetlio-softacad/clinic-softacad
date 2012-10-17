package util;

/**
 * Typical usage:
 * <pre>
 * <code>
 * new TranastionalUnitOfWork() {
 * 	protected void doWork() {
 * 		// Do some work
 * 	}
 * }.execute()
 * </code>
 * </pre>
 * @author Vladimir Tsanev
 * 
 */
public abstract class TransactionalUnitOfWork {

	/**
	 * The current session is accessible through
	 * {@link HibernateUtil#getSession()} method.
	 */
	protected abstract void doWork();

	/**
	 * Executes this unit of work in Transaction context.
	 */
	public void execute() {
		try {
			HibernateUtil.getSession().beginTransaction();
			doWork();
			HibernateUtil.getSession().getTransaction().commit();
		} catch (RuntimeException e) {
			// Note that rollback closes the session
			HibernateUtil.getSession().getTransaction().rollback();
			throw e; // or display error message
		}
	}

}
