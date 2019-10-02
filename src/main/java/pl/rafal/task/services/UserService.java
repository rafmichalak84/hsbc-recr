package pl.rafal.task.services;

import org.springframework.stereotype.Service;
import pl.rafal.task.model.User;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private List<User> users = new LinkedList<>();

    public Optional<User> getUserBySession(String session) {
        Optional<User> user = users.stream()
                .filter(user1 ->
                        user1.getSession().equals(session))
                .findFirst();
        return user;
    }

    public Optional<User> getUserByUsername(String username) {
        Optional<User> user = users.stream()
                .filter(user1 ->
                        user1.getUsername().equals(username))
                .findFirst();
        return user;
    }

    public Optional<User> addUser(String username, String session) {
        User user = new User(username, session);
        this.users.add(user);
        return Optional.of(user);
    }

    public void followUser(String session, String username) {
        Optional<User> user = getUserBySession(session);
        Optional<User> followedUser = getUserByUsername(username);

        user.ifPresent(user1 -> followedUser.ifPresent(user2 -> user1.getFollows().add(user2)));
    }
}
