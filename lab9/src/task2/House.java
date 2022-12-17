package task2;
import java.util.ArrayList;

public class House {

    private String location; // mandatory
    private int numFloors; // mandatory
    private int numRooms; // mandatory
    private boolean pool; // optional
    private boolean appliances; // optional
    private boolean solarPanels; // optional
    private String securityCompany; // optional

    private House(HouseBuilder builder) {
        this.location = builder.location;;
        this.numFloors = builder.numFloors;;
        this.numRooms = builder.numRooms;;
        this.pool = builder.pool;
        this.appliances = builder.appliances;
        this.solarPanels = builder.solarPanels;
        this.securityCompany = builder.securityCompany;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(int numFloors) {
        this.numFloors = numFloors;
    }

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isAppliances() {
        return appliances;
    }

    public void setAppliances(boolean appliances) {
        this.appliances = appliances;
    }

    public boolean isSolarPanels() {
        return solarPanels;
    }

    public void setSolarPanels(boolean solarPanels) {
        this.solarPanels = solarPanels;
    }

    public String getSecurityCompany() {
        return securityCompany;
    }

    public void setSecurityCompany(String securityCompany) {
        this.securityCompany = securityCompany;
    }

    @Override
    public String toString() {
        return "House{" +
                "location='" + location + '\'' +
                ", numFloors=" + numFloors +
                ", numRooms=" + numRooms +
                ", pool=" + pool +
                ", appliances=" + appliances +
                ", solarPanels=" + solarPanels +
                ", securityCompany='" + securityCompany + '\'' +
                '}';
    }

    static class HouseBuilder {

        private String location; // mandatory
        private int numFloors; // mandatory
        private int numRooms; // mandatory
        private boolean pool; // optional
        private boolean appliances; // optional
        private boolean solarPanels; // optional
        private String securityCompany; // optional

        public HouseBuilder(String location, int numFloors, int numRooms) {
            this.location = location;
            this.numFloors = numFloors;
            this.numRooms = numRooms;
        }

        public HouseBuilder pool(boolean pool) {
            this.pool = pool;
            return this;
        }

        public HouseBuilder securityCompany(String securityCompany) {
            this.securityCompany = securityCompany;
            return this;
        }

        public HouseBuilder appliances(boolean appliances) {
            this.appliances = appliances;
            return this;
        }

        public HouseBuilder solarPanels(boolean solarPanels) {
            this.solarPanels = solarPanels;
            return this;
        }

        public House build() {
            return new House(this);
        }

    }
}
