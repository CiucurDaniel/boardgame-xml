
package uvt.homework2.jaxb;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlID;
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.adapters.CollapsedStringAdapter;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="manufacturers"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="manufacturer" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="manufacturerID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="categories"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="category" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="categoryID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *         &lt;element name="boardgames"&gt;
 *           &lt;complexType&gt;
 *             &lt;complexContent&gt;
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                 &lt;sequence&gt;
 *                   &lt;element name="boardgame" maxOccurs="unbounded" minOccurs="0"&gt;
 *                     &lt;complexType&gt;
 *                       &lt;complexContent&gt;
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *                           &lt;sequence&gt;
 *                             &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *                             &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *                           &lt;/sequence&gt;
 *                           &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
 *                           &lt;attribute name="manufacturerID" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
 *                           &lt;attribute name="categoriesIDs" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREFS" /&gt;
 *                         &lt;/restriction&gt;
 *                       &lt;/complexContent&gt;
 *                     &lt;/complexType&gt;
 *                   &lt;/element&gt;
 *                 &lt;/sequence&gt;
 *               &lt;/restriction&gt;
 *             &lt;/complexContent&gt;
 *           &lt;/complexType&gt;
 *         &lt;/element&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "manufacturers",
    "categories",
    "boardgames"
})
@XmlRootElement(name = "BoardgameRoot")
public class BoardgameRoot {

    @XmlElement(required = true)
    protected BoardgameRoot.Manufacturers manufacturers;
    @XmlElement(required = true)
    protected BoardgameRoot.Categories categories;
    @XmlElement(required = true)
    protected BoardgameRoot.Boardgames boardgames;

    /**
     * Gets the value of the manufacturers property.
     * 
     * @return
     *     possible object is
     *     {@link BoardgameRoot.Manufacturers }
     *     
     */
    public BoardgameRoot.Manufacturers getManufacturers() {
        return manufacturers;
    }

    /**
     * Sets the value of the manufacturers property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoardgameRoot.Manufacturers }
     *     
     */
    public void setManufacturers(BoardgameRoot.Manufacturers value) {
        this.manufacturers = value;
    }

    /**
     * Gets the value of the categories property.
     * 
     * @return
     *     possible object is
     *     {@link BoardgameRoot.Categories }
     *     
     */
    public BoardgameRoot.Categories getCategories() {
        return categories;
    }

    /**
     * Sets the value of the categories property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoardgameRoot.Categories }
     *     
     */
    public void setCategories(BoardgameRoot.Categories value) {
        this.categories = value;
    }

    /**
     * Gets the value of the boardgames property.
     * 
     * @return
     *     possible object is
     *     {@link BoardgameRoot.Boardgames }
     *     
     */
    public BoardgameRoot.Boardgames getBoardgames() {
        return boardgames;
    }

    /**
     * Sets the value of the boardgames property.
     * 
     * @param value
     *     allowed object is
     *     {@link BoardgameRoot.Boardgames }
     *     
     */
    public void setBoardgames(BoardgameRoot.Boardgames value) {
        this.boardgames = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="boardgame" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
     *                 &lt;attribute name="manufacturerID" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
     *                 &lt;attribute name="categoriesIDs" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREFS" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "boardgame"
    })
    public static class Boardgames {

        protected List<BoardgameRoot.Boardgames.Boardgame> boardgame;

        /**
         * Gets the value of the boardgame property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the boardgame property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getBoardgame().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BoardgameRoot.Boardgames.Boardgame }
         * 
         * 
         */
        public List<BoardgameRoot.Boardgames.Boardgame> getBoardgame() {
            if (boardgame == null) {
                boardgame = new ArrayList<BoardgameRoot.Boardgames.Boardgame>();
            }
            return this.boardgame;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="releaseDate" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="price" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="ID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
         *       &lt;attribute name="manufacturerID" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREF" /&gt;
         *       &lt;attribute name="categoriesIDs" use="required" type="{http://www.w3.org/2001/XMLSchema}IDREFS" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "releaseDate",
            "name",
            "price"
        })
        public static class Boardgame {

            @XmlElement(required = true)
            protected String releaseDate;
            @XmlElement(required = true)
            protected String name;
            protected short price;
            @XmlAttribute(name = "ID", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlID
            @XmlSchemaType(name = "ID")
            protected String id;
            @XmlAttribute(name = "manufacturerID", required = true)
            @XmlIDREF
            @XmlSchemaType(name = "IDREF")
            protected Object manufacturerID;
            @XmlAttribute(name = "categoriesIDs", required = true)
            @XmlIDREF
            @XmlSchemaType(name = "IDREFS")
            protected List<Object> categoriesIDs;

            /**
             * Gets the value of the releaseDate property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReleaseDate() {
                return releaseDate;
            }

            /**
             * Sets the value of the releaseDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReleaseDate(String value) {
                this.releaseDate = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the price property.
             * 
             */
            public short getPrice() {
                return price;
            }

            /**
             * Sets the value of the price property.
             * 
             */
            public void setPrice(short value) {
                this.price = value;
            }

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getID() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setID(String value) {
                this.id = value;
            }

            /**
             * Gets the value of the manufacturerID property.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getManufacturerID() {
                return manufacturerID;
            }

            /**
             * Sets the value of the manufacturerID property.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setManufacturerID(Object value) {
                this.manufacturerID = value;
            }

            /**
             * Gets the value of the categoriesIDs property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the Jakarta XML Binding object.
             * This is why there is not a <CODE>set</CODE> method for the categoriesIDs property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCategoriesIDs().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Object }
             * 
             * 
             */
            public List<Object> getCategoriesIDs() {
                if (categoriesIDs == null) {
                    categoriesIDs = new ArrayList<Object>();
                }
                return this.categoriesIDs;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="category" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="categoryID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "category"
    })
    public static class Categories {

        protected List<BoardgameRoot.Categories.Category> category;

        /**
         * Gets the value of the category property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the category property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCategory().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BoardgameRoot.Categories.Category }
         * 
         * 
         */
        public List<BoardgameRoot.Categories.Category> getCategory() {
            if (category == null) {
                category = new ArrayList<BoardgameRoot.Categories.Category>();
            }
            return this.category;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="categoryID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name"
        })
        public static class Category {

            @XmlElement(required = true)
            protected String name;
            @XmlAttribute(name = "categoryID", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlID
            @XmlSchemaType(name = "ID")
            protected String categoryID;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the categoryID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCategoryID() {
                return categoryID;
            }

            /**
             * Sets the value of the categoryID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCategoryID(String value) {
                this.categoryID = value;
            }

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType&gt;
     *   &lt;complexContent&gt;
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *       &lt;sequence&gt;
     *         &lt;element name="manufacturer" maxOccurs="unbounded" minOccurs="0"&gt;
     *           &lt;complexType&gt;
     *             &lt;complexContent&gt;
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
     *                 &lt;sequence&gt;
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                   &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
     *                 &lt;/sequence&gt;
     *                 &lt;attribute name="manufacturerID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
     *               &lt;/restriction&gt;
     *             &lt;/complexContent&gt;
     *           &lt;/complexType&gt;
     *         &lt;/element&gt;
     *       &lt;/sequence&gt;
     *     &lt;/restriction&gt;
     *   &lt;/complexContent&gt;
     * &lt;/complexType&gt;
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "manufacturer"
    })
    public static class Manufacturers {

        protected List<BoardgameRoot.Manufacturers.Manufacturer> manufacturer;

        /**
         * Gets the value of the manufacturer property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a <CODE>set</CODE> method for the manufacturer property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getManufacturer().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link BoardgameRoot.Manufacturers.Manufacturer }
         * 
         * 
         */
        public List<BoardgameRoot.Manufacturers.Manufacturer> getManufacturer() {
            if (manufacturer == null) {
                manufacturer = new ArrayList<BoardgameRoot.Manufacturers.Manufacturer>();
            }
            return this.manufacturer;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType&gt;
         *   &lt;complexContent&gt;
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
         *       &lt;sequence&gt;
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *         &lt;element name="country" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
         *       &lt;/sequence&gt;
         *       &lt;attribute name="manufacturerID" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" /&gt;
         *     &lt;/restriction&gt;
         *   &lt;/complexContent&gt;
         * &lt;/complexType&gt;
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "name",
            "country"
        })
        public static class Manufacturer {

            @XmlElement(required = true)
            protected String name;
            @XmlElement(required = true)
            protected String country;
            @XmlAttribute(name = "manufacturerID", required = true)
            @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
            @XmlID
            @XmlSchemaType(name = "ID")
            protected String manufacturerID;

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the country property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getCountry() {
                return country;
            }

            /**
             * Sets the value of the country property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setCountry(String value) {
                this.country = value;
            }

            /**
             * Gets the value of the manufacturerID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getManufacturerID() {
                return manufacturerID;
            }

            /**
             * Sets the value of the manufacturerID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setManufacturerID(String value) {
                this.manufacturerID = value;
            }

        }

    }

}
