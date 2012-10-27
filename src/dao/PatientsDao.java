package dao;

import java.util.Set;

import entity.Doctor;
import entity.Patient;

public interface PatientsDao extends Daoable<Patient>{
	
	Set<Patient> findAllByDoctor(Doctor doctor) throws DataAccessException;
	Set<Patient> findAllByDiagnose(String diagnose);
	Set<Patient> findAllWithExpensiveVisit(double visitCostsAtLeast);

}
