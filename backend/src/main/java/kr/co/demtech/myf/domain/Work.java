package kr.co.demtech.myf.domain;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class Work {
  private int room;
  private boolean workState;
  private Timestamp workInAt;
  private Timestamp workOutAt;

}
