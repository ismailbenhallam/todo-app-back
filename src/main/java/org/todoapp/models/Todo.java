package org.todoapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private TodoPriority priority;
    private TodoState state;
    private LocalDateTime completionDate;

    public Todo() {
    }

    public Todo(long id, String title, String description, TodoPriority priority, TodoState state, LocalDateTime completionDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.state = state;
        this.completionDate = completionDate;
    }

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private long id;
        private String title;
        private String description;
        private TodoPriority priority;
        private TodoState state;
        private LocalDateTime completionDate;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder priority(TodoPriority priority) {
            this.priority = priority;
            return this;
        }

        public Builder state(TodoState state) {
            this.state = state;
            return this;
        }

        public Builder completionDate(LocalDateTime completionDate) {
            this.completionDate = completionDate;
            return this;
        }

        public Todo build() {
            return new Todo(id, title, description, priority, state, completionDate);
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodoPriority getPriority() {
        return priority;
    }

    public void setPriority(TodoPriority priority) {
        this.priority = priority;
    }

    public TodoState getState() {
        return state;
    }

    public void setState(TodoState state) {
        this.state = state;
    }

    public LocalDateTime getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }
}
