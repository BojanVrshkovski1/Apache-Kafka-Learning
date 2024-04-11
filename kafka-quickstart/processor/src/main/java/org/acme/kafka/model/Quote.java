package org.acme.kafka.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "quote")
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
      name = "id",
      nullable = false
    )
    public Integer id;
    @Column(
      name = "name",
      nullable = false
    )
    public String name;
    @Column(
      name = "price",
      nullable = false
    )
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