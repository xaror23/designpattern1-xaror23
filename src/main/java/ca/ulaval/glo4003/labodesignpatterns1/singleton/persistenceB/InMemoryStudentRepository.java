package ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceB;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Student;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.StudentRepository;

public class InMemoryStudentRepository implements StudentRepository {

	@Override
	public Student findByIdul(String idul) {
		System.out.println("MEMORY: findByIdul");
		return new Student();
	}

	@Override
	public void persist(Student student) {
		System.out.println("MEMORY: persist student");
	}

}
