package com.oserious.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/courses")
	public java.util.List<Course> getTopic() {

		return courseService.getCourses();
	}

	/**
	 * Adding a sub url.
	 */
	@RequestMapping("/courses/{id}")
	public Course getTopic(@PathVariable String id) {
		return courseService.getCourses(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/addcourses")
	public void addTopic(@RequestBody Course course) {
		courseService.addTopic(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
	public void updateTopic(@RequestBody Course course, @PathVariable String id) {
		courseService.updateTopic(id, course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
	public void removeTopic(@PathVariable String id) {
		courseService.removeTopic(id);
	}
}
