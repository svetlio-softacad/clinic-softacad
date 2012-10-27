package dao;

import java.util.Date;
import java.util.Set;

import entity.*;

public interface DoctorsDao extends Daoable<Doctor> {
	
	Set<Doctor> findAllByPatient(Patient patirnt, Date from, Date to) throws DataAccessException;

}
