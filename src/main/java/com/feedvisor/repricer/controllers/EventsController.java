package com.feedvisor.repricer.controllers;

import com.feedvisor.repricer.config.AppProperties;
import com.feedvisor.repricer.models.Event;
import com.feedvisor.repricer.repositories.EventRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class EventsController {
  @Autowired
  private KafkaTemplate kafkaTemplate;

  @Autowired
  private EventRepository eventRepository;


  @GetMapping("/{name}")
  public Event getEvent(@PathVariable String name){
    return this.eventRepository.findByName(name);
  }

  @GetMapping
  public List<Event> getEvents(){
      return this.eventRepository.findAll();
  }

  @PostMapping
  public void postEvent(Event event){
    //kafkaTemplate.send("events", "hello");
  }

  @KafkaListener(topics = "events")
  public void receiveTopic1(ConsumerRecord<?, ?> consumerRecord) {
    System.out.println("Receiver on topic1: "+consumerRecord.value().toString());
  }
}

