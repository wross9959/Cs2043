class Rational {
 private int x, y;
 public Rational (int x, int y) {
   this.x = x;
   this.y = y;
 }
 public int getX() {
   return x;
 }
 public int getY() {
   return y;
 }
 public void add (Rational r) {
  this.x = this.x * r.getY() + this.y * r.getX();
  this.y = this.y * r.getY();
 }
 public double getDecimal () {
   return this.x / this.y;
 }
} 