package ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Student;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.StudentRepository;

public class DevNullStudentRepository implements StudentRepository {

	@Override
	public Student findByIdul(String idul) {
		System.out.println("DEV/NULL: find by idul");
		return new Student();
	}

	@Override
	public void persist(Student student) {
		System.out.println("DEV/NULL: persist student");
	}

}
