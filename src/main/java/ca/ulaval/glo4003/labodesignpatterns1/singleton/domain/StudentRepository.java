package ca.ulaval.glo4003.labodesignpatterns1.singleton.domain;

public interface StudentRepository {

	Student findByIdul(String idul);

	void persist(Student student);

}
