package com.lambdaschool.schools.services;

import com.lambdaschool.schools.exceptions.ResourceNotFoundException;
import com.lambdaschool.schools.models.AdviceSlip;
import com.lambdaschool.schools.models.Instructor;
import com.lambdaschool.schools.repositories.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service(value = "instructorService")
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	private InstructorRepository instrepo;

	@Override
	public Instructor findInstructorById(long id) {
		return instrepo
			.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Instructor " + id + " not found!"));
	}

	@Override
	public Instructor addAdvice(long id) {
		Instructor instructor = instrepo
			.findById(id)
			.orElseThrow(() -> new ResourceNotFoundException("Instructor " + id + " not found!"));

		RestTemplate restTemplate = new RestTemplate();

		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
		converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
		restTemplate.getMessageConverters().add(converter);

		String requestURL = "http://api.adviceslip.com/advice";

		ParameterizedTypeReference<AdviceSlip> responseType = new ParameterizedTypeReference<>() {};

		ResponseEntity<AdviceSlip> responseEntity = restTemplate.exchange(requestURL, HttpMethod.GET, null, responseType);
		AdviceSlip adviceSlip = responseEntity.getBody();

		instructor.setAdvice(adviceSlip);
		return instructor;
	}
}