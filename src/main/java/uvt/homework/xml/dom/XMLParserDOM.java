package uvt.homework.xml.dom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import uvt.homework.xml.models.Boardgame;
import uvt.homework.xml.models.Category;
import uvt.homework.xml.models.Manufacturer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XMLParserDOM {
    public static ArrayList<Boardgame> parseBoardgamesXML() {

        ArrayList<Boardgame> boardgames = new ArrayList<>();

        try {
            File inputFile = new File("/Users/daniel/IdeaProjects/boardgame-xml/boardgame.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList boardgameList = doc.getElementsByTagName("boardgame");
            NodeList manufacturersList = doc.getElementsByTagName("manufacturer");
            NodeList categoriesList = doc.getElementsByTagName("category");


            // iterate trough manufacturers
            ArrayList<Manufacturer> manufacturers = new ArrayList<>();

            for (int index = 0; index < manufacturersList.getLength(); index++) {
                Node manufacturerNode = manufacturersList.item(index);

                if (manufacturerNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) manufacturerNode;

                    Manufacturer current = new Manufacturer();
                    current.setManufacturerID(eElement.getAttribute("manufacturerID"));
                    current.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    current.setCountry(eElement.getElementsByTagName("country").item(0).getTextContent());
                    manufacturers.add(current);
                }
            }

            // iterate trough categories
            ArrayList<Category> categories = new ArrayList<>();

            for (int index = 0; index < categoriesList.getLength(); index++) {
                Node categoryNode = categoriesList.item(index);

                if (categoryNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) categoryNode;
                    Category current = new Category();
                    current.setCategoryID(eElement.getAttribute("categoryID"));
                    current.setName(eElement.getElementsByTagName("name").item(0).getTextContent());

                    categories.add(current);
                }
            }

            // System.out.println("DEBUG: Manufacturers list is: " + manufacturers);
            // System.out.println("DEBUG: Categories list is: " + categories);

            // iterate trough boardgames
            for (int index = 0; index < boardgameList.getLength(); index++) {
                Node boardgameNode = boardgameList.item(index);
                // System.out.println("DEBUG:  Current Element :" + boardgameNode.getNodeName());

                if (boardgameNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) boardgameNode;

                    Boardgame currentBoardgame = new Boardgame();
                    currentBoardgame.setBoardgameID(eElement.getAttribute("ID"));
                    currentBoardgame.setName(eElement.getElementsByTagName("name").item(0).getTextContent());
                    currentBoardgame.setReleaseDate(eElement.getElementsByTagName("releaseDate").item(0).getTextContent());
                    currentBoardgame.setPrice(Integer.parseInt(eElement.getElementsByTagName("price").item(0).getTextContent()));


                    String mID = eElement.getAttribute("manufacturerID");
                    // System.out.println("DEBUG: Current manufacturer id :" + mID);
                    for (Manufacturer manufacturer : manufacturers) {
                        if (manufacturer.getManufacturerID().equals(mID)) {
                            // System.out.println("DEBUG: FOUND MATCH");
                            currentBoardgame.setManufacturer(manufacturer);
                            break;
                        }
                    }

                    String[] cID = eElement.getAttribute("categoriesIDs").split("\\s");
                    ArrayList<Category> c = new ArrayList<>();
                    for (String s : cID) {
                        for (Category category : categories) {
                            if (s.equals(category.getCategoryID())) {
                                // System.out.println("DEBUG: FOUND MATCH");
                                c.add(category);
                            }
                        }
                    }
                    currentBoardgame.setCategories(c);

                    boardgames.add(currentBoardgame);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return boardgames;
    }
}
