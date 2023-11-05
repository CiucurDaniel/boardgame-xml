package uvt.homework.xml.models;

import java.util.ArrayList;

public class Boardgame {
    public String boardgameID;
    public Manufacturer manufacturer;
    public String name;
    public int price;
    public String releaseDate;
    public ArrayList<Category> categories;

    public String getBoardgameID() {
        return boardgameID;
    }

    public void setBoardgameID(String boardgameID) {
        this.boardgameID = boardgameID;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Boardgame{" +
                "boardgameID='" + boardgameID + '\'' +
                ", manufacturer=" + manufacturer +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", categories=" + categories +
                '}';
    }
}
