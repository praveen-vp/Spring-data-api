package com.oserious.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListTopic {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public java.util.List<Topic> getTopic() { 
		
		return topicService.getTopics();
	}

	/**
	 * Adding a sub url.
	 */
	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopics(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/addtopics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/topics/{id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
		topicService.updateTopic(id, topic);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/topics/{id}")
	public void removeTopic(@PathVariable String id) {
		topicService.removeTopic(id);
	}
}
