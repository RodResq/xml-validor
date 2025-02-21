package br.com.labs.xml_validor.errors;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

public class XmlErrorHandler implements ErrorHandler {

    private List<SAXParseException> exceptions;

    public XmlErrorHandler() {
        this.exceptions = new ArrayList<>();
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        exceptions.add(exception);
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        exceptions.add(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        exceptions.add(exception);
    }
}
