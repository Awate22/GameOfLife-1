package com.example.demo;

import com.example.demo.pojo.Board;
import com.example.demo.pojo.Life;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

      Life life = new Life();
      life.runGame();

    }




}
