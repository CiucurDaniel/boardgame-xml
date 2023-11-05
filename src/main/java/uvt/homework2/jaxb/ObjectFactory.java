
package uvt.homework2.jaxb;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the uvt.homework2.jaxb package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: uvt.homework2.jaxb
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link BoardgameRoot }
     * 
     */
    public BoardgameRoot createBoardgameRoot() {
        return new BoardgameRoot();
    }

    /**
     * Create an instance of {@link BoardgameRoot.Boardgames }
     * 
     */
    public BoardgameRoot.Boardgames createBoardgameRootBoardgames() {
        return new BoardgameRoot.Boardgames();
    }

    /**
     * Create an instance of {@link BoardgameRoot.Categories }
     * 
     */
    public BoardgameRoot.Categories createBoardgameRootCategories() {
        return new BoardgameRoot.Categories();
    }

    /**
     * Create an instance of {@link BoardgameRoot.Manufacturers }
     * 
     */
    public BoardgameRoot.Manufacturers createBoardgameRootManufacturers() {
        return new BoardgameRoot.Manufacturers();
    }

    /**
     * Create an instance of {@link BoardgameRoot.Boardgames.Boardgame }
     * 
     */
    public BoardgameRoot.Boardgames.Boardgame createBoardgameRootBoardgamesBoardgame() {
        return new BoardgameRoot.Boardgames.Boardgame();
    }

    /**
     * Create an instance of {@link BoardgameRoot.Categories.Category }
     * 
     */
    public BoardgameRoot.Categories.Category createBoardgameRootCategoriesCategory() {
        return new BoardgameRoot.Categories.Category();
    }

    /**
     * Create an instance of {@link BoardgameRoot.Manufacturers.Manufacturer }
     * 
     */
    public BoardgameRoot.Manufacturers.Manufacturer createBoardgameRootManufacturersManufacturer() {
        return new BoardgameRoot.Manufacturers.Manufacturer();
    }

}
