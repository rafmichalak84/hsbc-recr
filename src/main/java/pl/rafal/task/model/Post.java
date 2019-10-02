package pl.rafal.task.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

public class Post implements Comparable<Post> {
    @NotEmpty
    @Size(min=10, max=140)
    private String message;
    private LocalDateTime createdAt;

    public Post() { this.createdAt = LocalDateTime.now(); }

    public Post(String message, LocalDateTime createdAt) {
        this.message = message;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public int compareTo(Post o) {
        return o.getCreatedAt().compareTo(createdAt);
    }
}
