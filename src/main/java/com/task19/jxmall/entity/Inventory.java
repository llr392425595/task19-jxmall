package com.task19.jxmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "inventory")
@Getter
@Setter
@NoArgsConstructor
public class Inventory {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private int count;

  @NotNull
  private int lockedCount;

  @OneToOne(mappedBy = "inventory")
  @JsonIgnoreProperties("inventory")
  private Product product;

  public Inventory(int count, int lockedCount) {
    this.count = count;
    this.lockedCount = lockedCount;
  }
}
