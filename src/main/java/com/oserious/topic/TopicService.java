package com.oserious.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getTopics() {
		// return topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopics(String id) {

		// return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
		return topicRepository.findOne(id);
	}

	public void addTopic(Topic topic) {

		topicRepository.save(topic);

	}

	public void updateTopic(String id, Topic topic) {

		topicRepository.save(topic);
	}

	public void removeTopic(String id) {

		topicRepository.delete(id);
	}
}
