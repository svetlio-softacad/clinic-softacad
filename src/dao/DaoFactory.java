package dao;

public interface DaoFactory {	
	DoctorsDao getDoctorsDao();
	PatientsDao getPatientsDao();
	VisitsDao getVisitsDao(); 
}
