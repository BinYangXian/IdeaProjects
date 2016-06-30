package com.wangyi.fraction;
import java.util.Scanner;
  public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(),in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5,6)).print();
        a.print();
        b.print();
        in.close();

    }
}
  class Fraction {
      private int _a;
      private int _b;

      Fraction(int a, int b) {
          int temp, r;
          int _a = a;
          int _b = b;
          if (a < b) { //把大的数放在n里面
              temp = a;
              a = b;
              b = temp;
          }
          while (b != 0) {
              r = a % b;
              a = b;
              b = r;
          }
          this._a = _a / a;
          this._b = _b / a;
      }

      double toDouble() {

          return (double) _a / _b;
      }

      Fraction plus(Fraction r) {
          return new Fraction(r._b*_a + r._a*_b, r._b * _b);
      }

      Fraction multiply(Fraction r) {
          return new Fraction(r._a*_a,r._b*_b);
      }

      void print() {
          if (_a != _b) {
              System.out.println(_a + "/" + _b);
          } else {
              System.out.println(1);
          }
      }
  }