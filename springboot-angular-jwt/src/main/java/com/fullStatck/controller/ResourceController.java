package com.fullStatck.controller;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.pattern.PathPattern;

import com.fullStatck.model.Event;
import com.fullStatck.model.SpecialEvent;
import com.fullStatck.model.User;
import com.fullStatck.security.AuthenticationRequest;
import com.fullStatck.security.AuthenticationResponse;
import com.fullStatck.security.JwtUtil;
import com.fullStatck.security.MyUserDetailsService;
import com.fullStatck.service.EventService;
import com.fullStatck.service.LoadDefaultData;
import com.fullStatck.service.SpecialEventService;
import com.fullStatck.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class ResourceController {

	private Logger logger = LoggerFactory.getLogger(ResourceController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private LoadDefaultData loadDefaultData;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private SpecialEventService specialEventService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@PostConstruct
	void load() {
		loadDefaultData.loadData();
	}



	@GetMapping("/users")
	public ResponseEntity<?> retriveUsers() {
		try {
			List<User> users = userService.getUsers();
			return ResponseEntity.ok(users);
		} catch (Exception e) {
			return new ResponseEntity<>("Server Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


	@GetMapping("/events")
	public ResponseEntity<?> retriveEvents() {
		try {
			List<Event> events = eventService.retriveEvents();
			return ResponseEntity.ok(events);
		} catch (Exception e) {
			return new ResponseEntity<>("Server Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/special")
	public ResponseEntity<?> retriveSpecialEvents() {
		try {
			List<SpecialEvent> events = specialEventService.retriveSpecialEvents();
			return ResponseEntity.ok(events);
		} catch (Exception e) {
			return new ResponseEntity<>("Server Error!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationResponse(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {
		try {
			new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
					authenticationRequest.getPassword());
		} catch (BadCredentialsException e) {
			throw new Exception("Bad Credential!" +e.getMessage());
		}
		
		UserDetails userDetails =  userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		
		String token = jwtTokenUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticationResponse(token));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) throws Exception {
		Optional<User> savedUser = userService.UserByEmail(user.getEmail());
		if (savedUser.isPresent()) {
			if (!savedUser.get().getPassword().equals(user.getPassword()))
				return new ResponseEntity<>("Invalid Password!", HttpStatus.UNAUTHORIZED);
		} else {
			return new ResponseEntity<>("Not a Valid User!", HttpStatus.UNAUTHORIZED);
		}
		logger.info("User Details Saved: USER : {}", savedUser.get());

		return ResponseEntity.ok(generateOrValidateToken(savedUser.get()));
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody User user) throws Exception {
		Long id = userService.getReordCount();
		if (id == null) {
			id = 0L;
		}

		user.setUserId(++id);
		userService.saveUser(user);
		logger.info("User Details Saved: USER : {}", user);
		//return ResponseEntity.ok(user);
		return ResponseEntity.ok(generateOrValidateToken(user));
	}
	
	public AuthenticationResponse generateOrValidateToken(User authenticationRequest) throws Exception {
		try {
			new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
					authenticationRequest.getPassword());
		}catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		UserDetails userDetails =  userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
		
		String token = jwtTokenUtil.generateToken(userDetails);
		
		return new AuthenticationResponse(token);
	}
	
	/*
	 * @Bean public WebMvcConfigurer corsConfigure() {
	 * 
	 * return new WebMvcConfigurer() {
	 * 
	 * @Override public void addCorsMappings(CorsRegistry registry) {
	 * registry.addMapping("/**"); } };
	 * 
	 * 
	 * }
	 */
	
}
