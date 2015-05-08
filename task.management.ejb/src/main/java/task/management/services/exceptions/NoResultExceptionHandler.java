package task.management.services.exceptions;

import java.io.Serializable;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class NoResultExceptionHandler extends Exception implements Serializable {

	private static final long serialVersionUID = 1L;

}
