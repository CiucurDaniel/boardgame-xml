package uvt.homework.xml.sax;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import uvt.homework.xml.models.Boardgame;

public class XMLParserSAX {

    public static ArrayList<Boardgame> parseBoardgamesXML() {
        ArrayList<Boardgame> boardgames = new ArrayList<>();

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            BoardgameHandler handler = new BoardgameHandler();
            saxParser.parse(new File("/Users/daniel/IdeaProjects/boardgame-xml/boardgame.xml"), handler);
            boardgames = handler.getBoardgameCollection();

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return boardgames;
    }

}