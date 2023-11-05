package uvt.homework2.xml;

import org.xml.sax.SAXException;
import uvt.homework2.xml.validation.XMLValidator;

import java.io.IOException;

public class Main {
    private final static String xsdPath = "/Users/daniel/IdeaProjects/boardgame-xml/boardgame.xsd";
    private final static String xmlPath = "/Users/daniel/IdeaProjects/boardgame-xml/boardgame.xml";

    public static void main(String[] args) throws IOException, SAXException {
        System.out.println("XML Homework 2 -  Ciucur Daniel");

        XMLValidator validator = new XMLValidator(xsdPath, xmlPath);
        boolean passedValidation = validator.isValid();

        if (passedValidation) {
            System.out.println("Your XML is valid against XSD schema.");
        } else {
            System.out.println("Your XML is not valid against XSD schema");
            validator.listParsingExceptions();
        }
    }
}
