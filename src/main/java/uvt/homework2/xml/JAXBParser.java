package uvt.homework2.xml;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import uvt.homework2.jaxb.BoardgameRoot;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JAXBParser {
    private static final String xmlPath = "/Users/daniel/Documents/GitHub/boardgame-xml/boardgame.xml";
    public static void main(String[] args) throws FileNotFoundException, JAXBException {
        JAXBContext jc = JAXBContext.newInstance( "uvt.homework2.jaxb" );
        Unmarshaller u = jc.createUnmarshaller();
        BoardgameRoot boardgameStore = (BoardgameRoot)u.unmarshal(
                        new FileInputStream( xmlPath ) );

        // Get some data from the parsed XML

        for (BoardgameRoot.Boardgames.Boardgame boardgame: boardgameStore.getBoardgames().getBoardgame()) {
            System.out.println("Boardgame:" + boardgame.getName() + " " + boardgame.getPrice());
        }

        for (BoardgameRoot.Manufacturers.Manufacturer manufacturer: boardgameStore.getManufacturers().getManufacturer()) {
            System.out.println(manufacturer.getName() + " " + manufacturer.getCountry());
        }
    }
}
