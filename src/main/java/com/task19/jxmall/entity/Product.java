package com.task19.jxmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
public class Product {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id",insertable=false,nullable=false,updatable=false)
  private int id;

  @NotNull
  private String name;

  @NotNull
  private String description;

  @NotNull
  private int price;

  @OneToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST, CascadeType.REMOVE})
  @JsonIgnoreProperties("product")
  @JoinColumn(unique = true, name = "inventoryId")
  private Inventory inventory;

  public Product(String name, String description, int price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }
}
