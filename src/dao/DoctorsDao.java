package dao;

import java.util.Date;
import java.util.Set;

import entity.*;

public interface DoctorsDao extends Daoable<Doctor> {
	
	Set<Doctor> find_all_by_patient(Patient patirnt, Date from, Date to);

}
