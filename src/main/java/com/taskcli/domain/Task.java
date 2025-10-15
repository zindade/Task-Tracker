package main.java.com.taskcli.domain;


import java.time.LocalDate;

public class Task {



     private int id;
     private String description;
     private Status status;
     private LocalDate createdAt ;
     private LocalDate updatedAt;
     private User assignee;


     public Task(int id, String description, Status status, LocalDate createdAt, LocalDate updatedAt, User assignee){

         this.id = id;
         this.status = status;
         this.description = description;
         this.createdAt= createdAt;
         this.updatedAt = updatedAt;
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
