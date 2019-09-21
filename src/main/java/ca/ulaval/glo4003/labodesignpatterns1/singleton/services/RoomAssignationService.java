package ca.ulaval.glo4003.labodesignpatterns1.singleton.services;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Course;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA.DevNullCourseRepository;

public class RoomAssignationService {

	public void assignRoomToCourse(int roomNumber, String courseName) {

		CourseRepository courseRepository = new DevNullCourseRepository();

		Course course = courseRepository.findByName(courseName);

		course.assignRoomNumber(roomNumber);

		courseRepository.persist(course);
	}

}
