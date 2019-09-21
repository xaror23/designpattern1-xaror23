package ca.ulaval.glo4003.labodesignpatterns1.singleton.domain;

import java.util.List;

public interface CourseRepository {

	List<Course> findAll();

	Course findByName(String name);

	void persist(Course course);

}
