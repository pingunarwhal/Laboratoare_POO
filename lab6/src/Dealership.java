import java.util.Random;

class Deals {
    static int brandMercedes = 5;
    static int brandSkoda = 15;
    static int brandFiat = 10;
    static int dealerMercedes = 300;
    static int dealerSkoda = 150;
    static int dealerFiat = 100;
    static int currentYear = 2022;
}
public class Dealership {

    private class BrandOffer implements Offer{

        @Override
        public int getDiscount(Car car) {
            System.out.print("Applying Brand discount: ");
            switch(car.getCarType()) {
                case MERCEDES:
                    System.out.print(car.getPrice() * Deals.brandMercedes / 100 + " euros\n");
                    return car.getPrice() * Deals.brandMercedes / 100;
                case FIAT:
                    System.out.print(car.getPrice() * Deals.brandFiat / 100 + " euros\n");
                    return car.getPrice() * Deals.brandFiat / 100;
                case SKODA:
                    System.out.print(car.getPrice() * Deals.brandSkoda / 100 + " euros\n");
                    return car.getPrice() * Deals.brandSkoda / 100;
                default:
                    return 0;
            }
        }
    }

    private class DealerOffer implements Offer{

        @Override
        public int getDiscount(Car car) {
            System.out.print("Applying Dealer discount: ");
            switch(car.getCarType()) {
                case MERCEDES:
                    System.out.println(Deals.dealerMercedes * (Deals.currentYear - car.getYear()) + " euros");
                    return Deals.dealerMercedes * (Deals.currentYear - car.getYear());
                case FIAT:
                    System.out.println(Deals.dealerFiat * (Deals.currentYear - car.getYear()) + " euros");
                    return Deals.dealerFiat * (Deals.currentYear - car.getYear());
                case SKODA:
                    System.out.println(Deals.dealerSkoda * (Deals.currentYear - car.getYear()) + " euros");
                    return Deals.dealerSkoda * (Deals.currentYear - car.getYear());
                default:
                    return 0;
            }
        }
    }

    private class SpecialOffer implements Offer{
        int random;
        public SpecialOffer() {
            random = Main.rand.nextInt(1000);
        }
        @Override
        public int getDiscount(Car car) {
            System.out.println("Applying Special discount: " + random + " euros");
            return random;
        }
    }

    public void getFinalPrice(Car car) {
        Offer brandOffer = new BrandOffer();
        Offer dealerOffer = new DealerOffer();
        Offer specialOffer = new SpecialOffer();
        int newPriceBrand = car.getPrice() - brandOffer.getDiscount(car);
        int newPriceDiscount = car.getPrice() - dealerOffer.getDiscount(car);
        int newPriceSpecial = car.getPrice() - specialOffer.getDiscount(car);
    }

    public void negotiate(Car car, Offer offer) {
        System.out.println("Applying Client discount: " + offer.getDiscount(car) + " euros");
        int newPriceNegotiate = car.getPrice() - offer.getDiscount(car);
    }
}
