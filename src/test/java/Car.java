import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertEquals;


public class Car {
    Integer price;
    String model;
    Integer year;
    String description;

    public Car(Integer price, String model, Integer year, String description) {
        this.price = price;
        this.model = model;
        this.year = year;
        this.description = description;
    }

    public Car() {

    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (getClass() == o.getClass()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Price: '" + this.getPrice() + "', Model: '" + this.getModel() + "' , Year: '" + this.getYear() + "' ,Description: '" + this.getDescription() + "'";
    }
}
