package edu.princeton.cs.lanqiao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Vector;

public class 货物摆放 {
    public static void main(String[] args) {
          long n = 2021041820210418L;
          int count = 0;
          Vector<Long> vector = new Vector<>();
          for(long i=1;i*i<=n;i++){     //找约数
              if(n%i == 0){
                  vector.add(i);
                  if(n/i != i){
                      vector.add(n/i);
                  }
              }
          }

          for(long a : vector){
              for(long b : vector){
                  for(long c : vector){
                      if(a*b*c == n){
                          count++;
                      }
                  }
              }
          }
          System.out.println(count);

          //2430


    }
}
