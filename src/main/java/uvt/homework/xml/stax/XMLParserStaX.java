package uvt.homework.xml.stax;

import uvt.homework.xml.models.Boardgame;
import uvt.homework.xml.models.Category;
import uvt.homework.xml.models.Manufacturer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLParserStaX {
    public static ArrayList<Boardgame> parseBoardgamesXML() throws FileNotFoundException, XMLStreamException {
        ArrayList<Boardgame> boardgames = new ArrayList<>();

        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream("/Users/daniel/IdeaProjects/boardgame-xml/boardgame.xml"));

        Boardgame boardgame = null;
        Manufacturer manufacturer = null;
        Category category = null;
        ParentElementType parentElementType = null;

        Map<String, Manufacturer> manufacturerMap = new HashMap<String, Manufacturer>();
        Map<String, Category> categoryMap = new HashMap<String, Category>();

        while (reader.hasNext()) {
            XMLEvent nextEvent = reader.nextEvent();

            if (nextEvent.isStartElement()) {
                StartElement startElement = nextEvent.asStartElement();
                switch (startElement.getName().getLocalPart()) {
                    case "boardgame":
                        parentElementType = ParentElementType.BOARDGAME;

                        boardgame = new Boardgame();

                        Attribute id = startElement.getAttributeByName(new QName("ID"));
                        if (id != null) {
                            boardgame.setBoardgameID(id.getValue());
                        }

                        boardgame.setManufacturer(manufacturerMap.get(startElement.getAttributeByName(new QName("manufacturerID")).getValue()));
                        
                        String[] categoriesIds = startElement.getAttributeByName(new QName("categoriesIDs")).getValue().split("\\s");
                        ArrayList<Category> categories = new ArrayList<>();
                        for (String c : categoriesIds) {
                            categories.add(categoryMap.get(c));
                        }
                        boardgame.setCategories(categories);

                        break;
                    case "manufacturer":
                        parentElementType = ParentElementType.MANUFACTURER;

                        manufacturer = new Manufacturer();
                        Attribute mId = startElement.getAttributeByName(new QName("manufacturerID"));
                        if (mId != null) {
                            manufacturer.setManufacturerID(mId.getValue());
                        }
                        manufacturerMap.put(manufacturer.getManufacturerID(), manufacturer);
                        break;

                    case "category":
                        parentElementType = ParentElementType.CATEGORY;

                        category = new Category();
                        Attribute cId = startElement.getAttributeByName(new QName("categoryID"));
                        if (cId != null) {
                            category.setCategoryID(cId.getValue());
                        }
                        categoryMap.put(category.getCategoryID(), category);
                        break;

                    case "name":
                        nextEvent = reader.nextEvent();
                        if (parentElementType == ParentElementType.MANUFACTURER) {
                            manufacturer.setName(nextEvent.asCharacters().getData());
                        } else if (parentElementType == ParentElementType.BOARDGAME) {
                            boardgame.setName(nextEvent.asCharacters().getData());
                        } else {
                            category.setName(nextEvent.asCharacters().getData());
                        }
                        break;

                    case "country":
                        nextEvent = reader.nextEvent();
                        manufacturer.setCountry(nextEvent.asCharacters().getData());
                        break;

                    case "price":
                        nextEvent = reader.nextEvent();
                        boardgame.setPrice(Integer.parseInt(nextEvent.asCharacters().getData()));
                        break;
                    case "releaseDate":
                        nextEvent = reader.nextEvent();
                        boardgame.setReleaseDate(nextEvent.asCharacters().getData());
                        break;

                }
            }

            if (nextEvent.isEndElement()) {
                EndElement endElement = nextEvent.asEndElement();

                if (endElement.getName().getLocalPart().equals("boardgame")) {
                    boardgames.add(boardgame);
                }
            }
        }

        // System.out.println("DEBUG: " + manufacturerMap);
        // System.out.println("DEBUG: " + categoryMap);
        return boardgames;
    }
}
