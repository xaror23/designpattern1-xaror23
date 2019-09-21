package ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceB;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Course;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;

public class InMemoryCourseRepository implements CourseRepository {

	public Map<String, Course> courses = new HashMap<>();

	@Override
	public List<Course> findAll() {
		System.out.println("MEMORY: find all courses");
		return new LinkedList<Course>(courses.values());
	}

	@Override
	public Course findByName(String name) {
		System.out.println("MEMORY: find by name");
		return courses.get(name);
	}

	@Override
	public void persist(Course course) {
		System.out.println("MEMORY: persist courses");
		courses.put(course.name, course);
	}

}
