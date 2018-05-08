package com.task19.jxmall.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
public class Inventory {
  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  private int count;

  @NotNull
  private int lockedCount;

}
