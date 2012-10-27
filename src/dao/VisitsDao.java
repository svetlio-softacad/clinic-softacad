package dao;

import java.util.Date;
import java.util.Set;

import entity.*;

public interface VisitsDao extends Daoable<Visit> {
	
	Set<Visit> findAllByDoctor(Doctor doctor, Date from, Date to) throws DataAccessException;
	Set<Visit> findAllByPatient(Patient patient, Date from, Date to) throws DataAccessException;

}
