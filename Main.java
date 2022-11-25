package lab03;

class Main {

  public static void main(String[] args) {

    Forest forest = new Forest(1000, 15, true);

    try {
      System.out.println("Carbon sequestered in this forest: " + String.format("%.2f", forest.currCarbonContent()) + " kg");
    } catch (Exception e) {
      System.out.println("Implement currCarbonContent first!");
      System.exit(1);
    }

    try {
      WhiteAsh target = new WhiteAsh(20);
      forest.harvest(target);
      System.out.println("Percent of forest remaining after harvest: " + String.format("%.2f", forest.forestRemaining()));
    } catch (Exception e) {
      System.out.println("Implement harvest first!");
      System.exit(1);
    }

  }

}