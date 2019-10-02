package pl.rafal.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.rafal.task.model.Post;
import pl.rafal.task.model.User;
import pl.rafal.task.services.PostService;
import pl.rafal.task.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class PostController {
    private PostService postService;
    private UserService userService;

    public PostController(@Autowired PostService postService, @Autowired UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    @PostMapping(value="/post/post", produces="application/json")
    public ResponseEntity<Post> post(@Valid @RequestBody Post post, HttpServletRequest request) {
        String session = request.getSession().getId();
        postService.addPost(session, post);

        return new ResponseEntity<>(post, HttpStatus.OK);
    }

}
