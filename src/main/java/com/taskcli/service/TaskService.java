package main.java.com.taskcli.service;


import main.java.com.taskcli.domain.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

public class TaskService {




    private String title;
     private String description;
     private String status;
     private String priority;
     private LocalDate date ;
     private String assignee;

     public TaskService(String title,String description,String status,String priority,LocalDate date,String assignee){
         this.title = title;
         this.description = description;
         this.status = status;
         this.priority = priority;
         this.date = date;
         this.assignee = assignee;
     }



     public void setStatus(String status){
         this.status = status;
     }
     public void setTitle(String title) {
         this.title = title;
     }
     public void setDescription(String description) {
         this.description = description;
     }

     public    void setPriority(String priority){
         this.priority= priority;
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
