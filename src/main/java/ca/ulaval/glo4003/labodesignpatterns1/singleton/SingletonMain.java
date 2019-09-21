package ca.ulaval.glo4003.labodesignpatterns1.singleton;

import java.util.Date;

import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Course;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.CourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.ServiceLocator.servicelocator;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.Student;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.domain.StudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA.DevNullCourseRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.persistenceA.DevNullStudentRepository;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.AttendanceService;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.RegistrationService;
import ca.ulaval.glo4003.labodesignpatterns1.singleton.services.RoomAssignationService;

public class SingletonMain {

	public static void main(String[] args) {

		servicelocator serviceLocator = new servicelocator();

		serviceLocator.registerSingleton(CourseRepository.class, new DevNullCourseRepository());
		serviceLocator.registerSingleton(StudentRepository.class, new DevNullStudentRepository());

		Course course = new Course();
		course.name = "course1";

		Student student = new Student();
		student.idul = "idul1";

		CourseRepository devNullCourseRepository = serviceLocator.resolve(CourseRepository.class);
		devNullCourseRepository.persist(course);

		StudentRepository studentRepository = serviceLocator.resolve(StudentRepository.class);
		studentRepository.persist(student);

		AttendanceService attendanceService = new AttendanceService();
		attendanceService.addAttendee(course.name, new Date(), student.idul);
		attendanceService.clearAttendees(course.name);

		RegistrationService registrationService = new RegistrationService();
		registrationService.addStudentToCourse(course.name, student.idul);
		registrationService.cancelCourse(course.name);

		RoomAssignationService roomAssignationService = new RoomAssignationService();
		roomAssignationService.assignRoomToCourse(1212, course.name);
	}

}
