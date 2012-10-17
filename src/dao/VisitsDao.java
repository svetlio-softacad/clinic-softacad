package dao;

import java.util.Date;
import java.util.Set;

import entity.*;

public interface VisitsDao extends Base<Visit> {
	
	Set<Visit> find_all_by_doctor(Doctor doctor, Date from, Date to);
	Set<Visit> find_all_by_patient(Patient patient, Date from, Date to);

}
