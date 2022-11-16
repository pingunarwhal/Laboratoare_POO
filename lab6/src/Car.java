public class Car {
    public enum CarType {MERCEDES, FIAT, SKODA}
    private CarType carType;
    private int price;
    private int year;

    public Car(int price, CarType type, int year) {
        this.price = price;
        this.carType = type;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "price=" + price +
                ", carType=" + carType +
                ", year=" + year +
                '}';
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
