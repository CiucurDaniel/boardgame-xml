package uvt.homework.xml;

import uvt.homework.xml.dom.XMLParserDOM;
import uvt.homework.xml.models.Boardgame;
import uvt.homework.xml.sax.XMLParserSAX;
import uvt.homework.xml.stax.XMLParserStaX;
import uvt.homework.xml.website.WebsiteBuilder;

import javax.xml.stream.XMLStreamException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws XMLStreamException, IOException {
        System.out.println("XML Homework 1 -  Ciucur Daniel");

        System.out.println("""
                Contents:
                1 package with models: models (Boardgame, Category, Manufacturer)
                                       
                3 packages with parsers :  "dom" and "sax" and ""stax"
                Each has a parseBoardgamesXML method which parses "boardgames.xml" file.
                 
                1 package website
                Contains a WebsiteBuilder class used to generate HTML elements from the parsed XML data source.
                                        
                1 Main class which contains extended workflow examples.
                """
        );

        System.out.println("DOM parser usage");
        ArrayList<Boardgame> boardgamesDOM = XMLParserDOM.parseBoardgamesXML();
        for (Boardgame b : boardgamesDOM) {
            System.out.println(b);
        }

        System.out.println("SAX parser usage");
        ArrayList<Boardgame> boardgamesSAX = XMLParserSAX.parseBoardgamesXML();
        for (Boardgame b : boardgamesSAX) {
            System.out.println(b);
        }

        System.out.println("StaX parser usage");
        ArrayList<Boardgame> boardgamesStaX = XMLParserStaX.parseBoardgamesXML();
        for (Boardgame b : boardgamesStaX) {
            System.out.println(b);
        }

        System.out.println("Example workflow: website for boardgame shop using XML as a data source to module HTML pages and display information");
        WebsiteBuilder boardgameshop = new WebsiteBuilder();
        boardgameshop.generateWebsite(boardgamesDOM);
    }
}