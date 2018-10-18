package com.feedvisor.repricer.schedualed;

import com.feedvisor.repricer.models.Event;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedTransferQueue;

@Component
public class ScheduledTasks {
  private static final int MAX_EVENTS_CAPACITY =10;
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HHmmss");
  private static BlockingQueue<Event> queue  = new LinkedTransferQueue<>();

  public static void publishEvent(Event event){
    queue.offer(event);

    if(queue.size() == MAX_EVENTS_CAPACITY){
      persistEvents();
    }
  }

  @Scheduled(fixedRate = 10000)
  public void reportCurrentTime() {
    System.out.println("Scheduale");
    //persistEvents();
  }


  private static void persistEvents(){

    StringBuffer sb = new StringBuffer();
    List<Event> events = new ArrayList<>();
    for (int i=0; i< MAX_EVENTS_CAPACITY; i++){
      Event event = null;
      try {
        event = queue.take();
      } catch (InterruptedException e) {

      }
      sb.append(event.toString()+"\n");
      events.add(event);
    }

    queue.drainTo(events);

    Path path = Paths.get("C:\\Users\\Admin-PC\\Desktop\\jsoneditor-master\\"+dateFormat.format(new Date())+".txt");
    try {
      Files.write(path, sb.toString().getBytes());
    } catch (IOException e) {

    }
  }
}
