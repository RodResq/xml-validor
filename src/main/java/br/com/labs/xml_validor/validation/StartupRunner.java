package br.com.labs.xml_validor.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    @Autowired
    private ValidationService validationService;

    @Override
    public void run(String... args) throws Exception {
        validationService.isValid();
    }
}
