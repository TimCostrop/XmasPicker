package be.costrop.xmas.picker.bootstrap;

import be.costrop.xmas.picker.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Arrays;

@Component
public class Bootstrap implements ApplicationRunner {
	private final PersonRepository personRepository;

	@Autowired
	public Bootstrap(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Transactional
	public void initialize() {
		personRepository.deleteAll();

		personRepository.saveAll(Arrays.asList(
				PersonBuilder.aPerson().withName("Tim").build(),
				PersonBuilder.aPerson().withName("Test").build()
		));
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		initialize();
	}
}
