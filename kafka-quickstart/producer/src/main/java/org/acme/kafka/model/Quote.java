package org.acme.kafka.model;

public class Quote {

    public Integer id;
    public String name;
    public int price;

    /**
     * Default constructor required for Jackson serializer
     */
    public Quote() { }

    public Quote(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Quote{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", price=" + price +
               '}';
    }
}