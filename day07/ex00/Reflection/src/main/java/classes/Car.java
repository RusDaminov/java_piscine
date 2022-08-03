package classes;

public class Car {
    private String model;
    private Integer year;
    private Integer price;
    private Integer speed;

    public Car(String model, Integer year, Integer price, Integer speed) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.speed = speed;
    }

    public Car() {
        this.model = "Default";
        this.year = 2022;
        this.price = 0;
        this.speed = 0;
    }

    public void AccSpeed(Integer speedIncrement) {
        speed += speedIncrement;
    }

    public void DecSpeed(Integer speedDecrement ) {
        speed -= speedDecrement;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", speed=" + speed +
                '}';
    }
}
