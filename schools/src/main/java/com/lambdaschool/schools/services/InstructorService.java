package com.lambdaschool.schools.services;

import com.lambdaschool.schools.models.AdviceSlip;
import com.lambdaschool.schools.models.Instructor;

public interface InstructorService {
	Instructor findInstructorById(long id);

	Instructor addAdvice(long id);
}
