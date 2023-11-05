package uvt.homework2.xml.validation;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.List;

// The basic behaviour of the validate method is to exit once the parsing throws a SAXException.
// Now that we want to gather all validation errors, we need to change this behaviour. For this, we have to define our own ErrorHandler
public class XmlErrorHandler implements ErrorHandler {

    private final List<SAXParseException> exceptions;

    public XmlErrorHandler() {
        this.exceptions = new ArrayList<>();
    }

    public List<SAXParseException> getExceptions() {
        return exceptions;
    }

    @Override
    public void warning(SAXParseException exception) {
        exceptions.add(exception);
    }

    @Override
    public void error(SAXParseException exception) {
        exceptions.add(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) {
        exceptions.add(exception);
    }
}