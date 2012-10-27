package dao;

public interface DaoFactory {	
	DoctorsDao getDoctorsDao();
	PatientsDao getPatientsDao();
	VisitsDao getVisitsDao();
	SepcialtiesDao getSpecialtiesDao();
	TitlesDao getTitlesDao();
}
