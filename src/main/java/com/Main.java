package com;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

  public static void main(String[] args) {
    System.out.println("start");
    SpringApplication.run(Main.class, args);
    System.out.println("end");
  }
}