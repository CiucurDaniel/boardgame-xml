package uvt.homework.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import uvt.homework.xml.models.Boardgame;
import uvt.homework.xml.models.Category;
import uvt.homework.xml.models.Manufacturer;

import java.util.*;

public class BoardgameHandler extends DefaultHandler {
    private ArrayList<Boardgame> boardgameCollection;
    private Map<String, Manufacturer> manufacturerMap = new HashMap<String, Manufacturer>();
    private Map<String, Category> categoryMap = new HashMap<String, Category>();


    private Stack<String> elementStack = new Stack<String>();
    private Stack<Object> objectStack = new Stack<Object>();

    @Override
    public void startDocument() throws SAXException {
        boardgameCollection = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        this.elementStack.push(qName);

        if ("boardgame".equals(qName)) {
            Boardgame boardgame = new Boardgame();
            boardgame.setBoardgameID(attributes.getValue("ID"));
            boardgame.setManufacturer(manufacturerMap.get(attributes.getValue("manufacturerID")));

            String[] categoriesIds = attributes.getValue("categoriesIDs").split("\\s");
            ArrayList<Category> categories = new ArrayList<>();
            for (String category : categoriesIds) {
                categories.add(categoryMap.get(category));
            }
            boardgame.setCategories(categories);

            this.objectStack.push(boardgame);
            this.boardgameCollection.add(boardgame);

        } else if ("manufacturer".equals(qName)) {
            Manufacturer manufacturer = new Manufacturer();
            manufacturer.setManufacturerID(attributes.getValue("manufacturerID"));
            this.objectStack.push(manufacturer);

        } else if ("category".equals(qName)) {
            Category category = new Category();
            category.setCategoryID(attributes.getValue("categoryID"));
            this.objectStack.push(category);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        this.elementStack.pop();

        if ("boardgame".equals(qName) || "manufacturer".equals(qName) || "category".equals(qName)) {
            Object object = this.objectStack.pop();

            if ("manufacturer".equals(qName)) {
                Manufacturer manufacturer = (Manufacturer) object;
                this.manufacturerMap.put(manufacturer.manufacturerID, manufacturer);
            }

            if ("category".equals(qName)) {
                Category category = (Category) object;
                this.categoryMap.put(category.categoryID, category);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value = new String(ch, start, length).trim();

        if ("name".equals(currentElement()) && "manufacturer".equals(currentElementParent())) {
            Manufacturer manufacturer = (Manufacturer) this.objectStack.peek();
            manufacturer.setName(value);
        }

        if ("country".equals(currentElement()) && "manufacturer".equals(currentElementParent())) {
            Manufacturer manufacturer = (Manufacturer) this.objectStack.peek();
            manufacturer.setCountry(value);
        }

        if ("name".equals(currentElement()) && "category".equals(currentElementParent())) {
            Category category = (Category) this.objectStack.peek();
            category.setName(value);
        }

        if ("name".equals(currentElement()) && "boardgame".equals(currentElementParent())) {
            Boardgame boardgame = (Boardgame) this.objectStack.peek();
            boardgame.setName(value);
        }

        if ("releaseDate".equals(currentElement()) && "boardgame".equals(currentElementParent())) {
            Boardgame boardgame = (Boardgame) this.objectStack.peek();
            boardgame.setReleaseDate(value);
        }

        if ("price".equals(currentElement()) && "boardgame".equals(currentElementParent())) {
            Boardgame boardgame = (Boardgame) this.objectStack.peek();
            boardgame.setPrice(Integer.parseInt(value));
        }

    }

    private String currentElement() {
        return this.elementStack.peek();
    }

    private String currentElementParent() {
        if (this.elementStack.size() < 2) return null;
        return this.elementStack.get(this.elementStack.size() - 2);
    }

    public ArrayList<Boardgame> getBoardgameCollection() {
        return boardgameCollection;
    }
}
