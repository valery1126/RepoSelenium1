package pojo;

public class Products {

    private String name;
    private double dolarsPrice;
    private double poundsPrice;
    private double euroPrice;


    public Products(String name, double dolarsPrice, double poundsPrice, double euroPrice) {
        this.name = name;
        this.dolarsPrice = dolarsPrice;
        this.poundsPrice = poundsPrice;
        this.euroPrice = euroPrice;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDolarsPrice() {
        return dolarsPrice;
    }

    public void setDolarsPrice(double dolarsPrice) {
        this.dolarsPrice = dolarsPrice;
    }

    public double getPoundsPrice() {
        return poundsPrice;
    }

    public void setPoundsPrice(double poundsPrice) {
        this.poundsPrice = poundsPrice;
    }

    public double getEuroPrice() {
        return euroPrice;
    }

    public void setEuroPrice(double euroPrice) {
        this.euroPrice = euroPrice;
    }


}
