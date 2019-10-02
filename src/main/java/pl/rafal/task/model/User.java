package pl.rafal.task.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class User {
    private String session;
    private String username;
    private List<Post> list;
    private Set<User> follows;

    public User(String username, String session) {
        this.username = username;
        this.session = session;
        this.list = new LinkedList<>();
        this.follows = new HashSet<>();
    }

    public String getSession() {
        return session;
    }

    public String getUsername() {
        return username;
    }

    public List<Post> getList() {
        return list;
    }

    public Set<User> getFollows() {
        return follows;
    }
}
