package pl.rafal.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.rafal.task.model.Post;
import pl.rafal.task.services.PostService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class WallController {
    private PostService postService;

    public WallController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @GetMapping(value="/", produces="application/json")
    public List<Post> listMyPosts(HttpServletRequest request) {
        String session = request.getSession().getId();

        return postService.getUserPosts(session);
    }

    @GetMapping(value="/followed", produces="application/json")
    public List<Post> listFollowedPosts(HttpServletRequest request) {
        String session = request.getSession().getId();

        return postService.getUserFollowersPosts(session);
    }
}
