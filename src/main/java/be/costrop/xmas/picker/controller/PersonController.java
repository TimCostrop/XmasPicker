package be.costrop.xmas.picker.controller;

import be.costrop.xmas.picker.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {

	private final PersonRepository personRepository;

	@Autowired
	public PersonController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@GetMapping("/")
	public String getPersons(Model model) {
		model.addAttribute("persons", personRepository.findAll());
		return "persons";
	}
}
