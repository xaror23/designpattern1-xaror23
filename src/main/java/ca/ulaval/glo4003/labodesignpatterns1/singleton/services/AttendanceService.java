package ca.ulaval.glo4003.labodesignpatterns1.singleton.services;

import java.util.Date;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Course;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Student;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.StudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA.DevNullCourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA.DevNullStudentRepository;

public class AttendanceService {

	public void addAttendee(String courseName, Date date, String idul) {
		CourseRepository courseRepository = new DevNullCourseRepository();
		StudentRepository studentRepository = new DevNullStudentRepository();

		Course course = courseRepository.findByName(courseName);
		Student student = studentRepository.findByIdul(idul);

		course.addAttendant(student, date);

		courseRepository.persist(course);
	}

	public void clearAttendees(String courseName) {
		CourseRepository courseRepository = new DevNullCourseRepository();

		Course course = courseRepository.findByName(courseName);

		course.clearAttendees();

		courseRepository.persist(course);
	}
}
