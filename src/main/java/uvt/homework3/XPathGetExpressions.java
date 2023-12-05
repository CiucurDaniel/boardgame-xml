package uvt.homework3;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XPathGetExpressions {

    public static void main(String[] args) {
        try {
            // Load the XML document
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("/Users/daniel/Documents/GitHub/boardgame-xml/boardgame.xml");

            // Create an XPath expression
            XPathFactory xPathFactory = XPathFactory.newInstance();
            XPath xpath = xPathFactory.newXPath();

            // Example 1: Get the name of the boardgame by ID
            String boardgameId = "b2";
            String boardgameName = getBoardgameById(document, xpath, boardgameId);
            System.out.println("Name of the boardgame with ID '" + boardgameId + "': " + boardgameName);

            // Example 2: Get the names of all boardgames made by "Kosmos" with price > 100
            String manufacturerName = "Kosmos";
            NodeList kosmosGames = getBoardgamesByManufacturerAndPrice(document, xpath, manufacturerName, 100);

            System.out.println("Boardgames made by '" + manufacturerName + "' with price > 100:");
            for (int i = 0; i < kosmosGames.getLength(); i++) {
                System.out.println(kosmosGames.item(i).getTextContent());
            }

            // Example 3: Apply a discount to all boardgames and print the updated XML
            double discountPercentage = 10; // You can change this value as needed
            Document discountedDocument = applyDiscountToBoardgames(document, xpath, discountPercentage);
            printXml(discountedDocument);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getBoardgameById(Document document, XPath xpath, String boardgameId) throws XPathExpressionException {
        XPathExpression expr = xpath.compile(
                String.format("//boardgame[@ID='%s']/name", boardgameId));
        return (String) expr.evaluate(document, XPathConstants.STRING);
    }

    private static NodeList getBoardgamesByManufacturerAndPrice(Document document, XPath xpath, String manufacturerName, double price) throws XPathExpressionException {
        XPathExpression expr = xpath.compile(
                String.format("//manufacturer[name='%s']/ancestor::BoardgameRoot/boardgames/boardgame[number(price) > %f]/name",
                        manufacturerName, price));
        return (NodeList) expr.evaluate(document, XPathConstants.NODESET);
    }

    private static Document applyDiscountToBoardgames(Document document, XPath xpath, double discountPercentage) throws XPathExpressionException {
        NodeList boardgames = (NodeList) xpath.evaluate("//boardgame", document, XPathConstants.NODESET);

        for (int i = 0; i < boardgames.getLength(); i++) {
            Element boardgame = (Element) boardgames.item(i);
            double originalPrice = Double.parseDouble(boardgame.getElementsByTagName("price").item(0).getTextContent());
            double discountedPrice = originalPrice - (originalPrice * (discountPercentage / 100));

            Element discountedPriceElement = document.createElement("discountedPrice");
            discountedPriceElement.setTextContent(String.valueOf(discountedPrice));

            boardgame.appendChild(discountedPriceElement);
        }

        return document;
    }

    private static void printXml(Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);

            StreamResult result = new StreamResult(System.out); // Print to console
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

