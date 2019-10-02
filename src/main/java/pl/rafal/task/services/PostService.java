package pl.rafal.task.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.rafal.task.model.Post;
import pl.rafal.task.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class PostService {
    private UserService userService;

    public PostService(@Autowired UserService userService) {
        this.userService = userService;
    }

    public List<Post> getUserPosts(String session) {
        Optional<User> user = userService.getUserBySession(session);
        if(user.isPresent()) {
            return userService.getUserBySession(session).get().getList();
        }
        return new ArrayList<>();
    }

    public List<Post> getUserFollowersPosts(String session) {
        Set<User> followedUsers = userService.getUserBySession(session).get().getFollows();
        Stream.Builder<List<Post>> stream = Stream.builder();
        for(User followedUser : followedUsers) {
            stream.add(followedUser.getList());
        }
        return stream.build().flatMap(posts -> posts.stream()).sorted().collect(Collectors.toList());
    }

    public void addPost(String session, Post post) {
        Optional<User> user = userService.getUserBySession(session);
        if(!user.isPresent()) {
            user = userService.addUser("user"+session, session);
        }
        user.ifPresent(user1 -> user1.getList().add(post));
    }
}
