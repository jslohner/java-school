package com.lambdaschool.schools.controllers;

import com.lambdaschool.schools.models.Instructor;
import com.lambdaschool.schools.services.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instructors")
public class InstructorController {
	@Autowired
	private InstructorService instructorService;

	@GetMapping(value = "/instructor/{instructorid}", produces = {"application/json"})
	public ResponseEntity<?> getInstructorById(@PathVariable long instructorid) {
		Instructor rtnInstructor = instructorService.findInstructorById(instructorid);
		return new ResponseEntity<>(rtnInstructor, HttpStatus.OK);
	}

	@GetMapping(value = "/instructor/{instructorid}/advice", produces = {"application/json"})
	public ResponseEntity<?> getInstructorAdviceById(@PathVariable long instructorid) {
		Instructor rtnInstructor = instructorService.addAdvice(instructorid);
		return new ResponseEntity<>(rtnInstructor, HttpStatus.OK);
	}
}
