package com.realtime.messagingApp.controller;

import com.realtime.messagingApp.exception.ResourceNotFoundException;
import com.realtime.messagingApp.model.User;
import com.realtime.messagingApp.payload.*;
import com.realtime.messagingApp.repository.PollRepository;
import com.realtime.messagingApp.repository.UserRepository;
import com.realtime.messagingApp.repository.VoteRepository;
import com.realtime.messagingApp.security.UserPrincipal;
import com.realtime.messagingApp.service.PollService;
import com.realtime.messagingApp.security.CurrentUser;
import com.realtime.messagingApp.util.AppConstants;

//import sessions.ActiveUsers.ActiveUserStore;

import java.util.ArrayList;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

//	@Autowired
//    ActiveUserStore activeUserStore;
	
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PollRepository pollRepository;

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private PollService pollService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    
//    @GetMapping("/loggedUsers")
//    public List<String> getLoggedUsers(Locale locale, Model model) {
//        model.addAttribute("users", activeUserStore.getUsers());
//        return  activeUserStore.getUsers();
//    }

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('USER')")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/dashboard")
    public ArrayList<UserSummary> getAllUsers() {
        ArrayList<UserSummary> users = new ArrayList<>();
        for(User user : userRepository.findAll()) {
        	users.add(new UserSummary(user.getId(), user.getUsername(), user.getName()));
        }
        return users;
    }

    
    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/users/{username}")
    public UserProfile getUserProfile(@PathVariable(value = "username") String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("User", "username", username));

        long pollCount = pollRepository.countByCreatedBy(user.getId());
        long voteCount = voteRepository.countByUserId(user.getId());

        UserProfile userProfile = new UserProfile(user.getId(), user.getUsername(), user.getName(), user.getCreatedAt(), pollCount, voteCount);

        return userProfile;
    }
    
    @PatchMapping("/users/status")
    public User updateUserStatus(@Valid @RequestBody LoginRequest loginRequest){
    	User user = userRepository.findByEmail(loginRequest.getUsernameOrEmail())
    			.orElseThrow(() -> new ResourceNotFoundException("User", "email", loginRequest.getUsernameOrEmail()));
    	user.setStatus(1);
    	userRepository.save(user);
    	return user;
    }

    
    
    
    @GetMapping("/users/{username}/polls")
    public PagedResponse<PollResponse> getPollsCreatedBy(@PathVariable(value = "username") String username,
                                                         @CurrentUser UserPrincipal currentUser,
                                                         @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                         @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return pollService.getPollsCreatedBy(username, currentUser, page, size);
    }


    @GetMapping("/users/{username}/votes")
    public PagedResponse<PollResponse> getPollsVotedBy(@PathVariable(value = "username") String username,
                                                       @CurrentUser UserPrincipal currentUser,
                                                       @RequestParam(value = "page", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) int page,
                                                       @RequestParam(value = "size", defaultValue = AppConstants.DEFAULT_PAGE_SIZE) int size) {
        return pollService.getPollsVotedBy(username, currentUser, page, size);
    }

}
