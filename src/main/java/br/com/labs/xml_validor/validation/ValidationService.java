package br.com.labs.xml_validor.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

@Service
public class ValidationService {
    private static final Logger logger = LoggerFactory.getLogger(ValidationService.class);

    private String xsdPath = "templates/mni/pessoa.xsd";
    private String xmlPath = "templates/mni/pessoa.xml";

    public ValidationService() {
    }

    public ValidationService(String xsdPath, String xmlPath) {
        this.xsdPath = xsdPath;
        this.xmlPath = xmlPath;
    }

    private Validator initValidator(String xsdPath) throws SAXException, IOException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Source schemaFile = new StreamSource(getFile(xsdPath));
        Schema schema = factory.newSchema(schemaFile);
        return schema.newValidator();
    }

    private File getFile(String location) throws IOException{
        ClassPathResource resource = new ClassPathResource(location);
        File file = resource.getFile();
        if (file.exists()) {
            System.out.println("File found at: " + file.getAbsolutePath());
        } else {
            System.out.println("File not found!");
        }
        return file;
    }

    public boolean isValid() throws IOException, SAXException {
        Validator validator = initValidator(xsdPath);
        try {
            validator.validate(new StreamSource(getFile(xmlPath)));
            logger.info("Xml válido");
            return true;
        } catch (SAXException e) {
            logger.error(e.getMessage());
            return false;
        }
    }
}
