package com.oserious.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseRepository coursepository;

	public List<Course> getCourses() {
		// return topics;
		List<Course> topics = new ArrayList<>();
		coursepository.findAll().forEach(topics::add);
		return topics;
	}

	public Course getCourses(String id) {

		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return coursepository.findOne(id);
	}

	public void addTopic(Course topic) {

		coursepository.save(topic);

	}

	public void updateTopic(String id, Course topic) {

		coursepository.save(topic);
	}

	public void removeTopic(String id) {

		coursepository.delete(id);
	}
}
