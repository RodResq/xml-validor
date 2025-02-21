package br.com.labs.xml_validor;

import br.com.labs.xml_validor.validation.ValidationService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.xml.sax.SAXException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class XmlValidorApplicationTests {

	@Test
	public void givenValidXML_WhenIsValid_ThenTrue() throws IOException, SAXException {
		assertTrue(new ValidationService("/home/resque/github/xml-validor/src/main/resources/templates/person.xsd",
				"/home/resque/github/xml-validor/src/main/resources/templates/person.xml").isValid());
	}

	@Test
	public void givenInvalidXML_WhenIsValid_ThenFalse() throws IOException, SAXException {
		assertFalse(new ValidationService("/home/resque/github/xml-validor/src/main/resources/templates/person.xsd",
				"/home/resque/github/xml-validor/src/main/resources/templates/person.xml").isValid());
	}

}
