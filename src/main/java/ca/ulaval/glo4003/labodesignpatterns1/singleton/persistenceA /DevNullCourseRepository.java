package ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA;

import java.util.LinkedList;
import java.util.List;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Course;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;

public class DevNullCourseRepository implements CourseRepository {

	@Override
	public List<Course> findAll() {
		System.out.println("DEV/NULL: find all courses");
		return new LinkedList<Course>();
	}

	@Override
	public Course findByName(String name) {
		System.out.println("DEV/NULL: find by name");
		return new Course();
	}

	@Override
	public void persist(Course course) {
		System.out.println("DEV/NULL: persit course");
	}

}
