package pl.rafal.task.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.rafal.task.services.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    private UserService userService;

    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user/follow", produces = "application/json")
    public ResponseEntity follow(@RequestParam String followUser, HttpServletRequest request) {
        String session = request.getSession().getId();
        userService.followUser(session, followUser);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
