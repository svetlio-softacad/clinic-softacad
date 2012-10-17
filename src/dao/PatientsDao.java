package dao;

import java.util.Set;

import entity.Doctor;
import entity.Patient;

public interface PatientsDao extends Base<Patient>{
	
	Set<Patient> find_all_by_doctor(Doctor doctor);
	Set<Patient> find_all_by_diagnose(String diagnose);
	Set<Patient> find_all_with_expensive_visit(double visitCostsAtLeast);

}
