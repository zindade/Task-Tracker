package main.java.com.taskcli.service;


import main.java.com.taskcli.domain.Status;
import main.java.com.taskcli.domain.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class TaskService {



     private int id;
     private String description;
     private Status status;
     private LocalDate createdAt ;
     private LocalDate updatedAt;
     private User assignee;


     public TaskService(String title,String description,Status status,String priority,LocalDate date,String assignee){

         this.description = description;
         this.status = status;
         this.assignee = assignee;
     }

     

     public void setStatus(Status status){
         this.status = status;
     }
     
     public void setDescription(String description) {
         this.description = description;
     }

     
     public void setDate(LocalDate date) {
         this.date = date;
     }

     public void  setAssignee(String assignee) {
         this.assignee = assignee;
     }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getPriority() {
        return priority;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getAssignee() {
        return assignee;
    }

}
