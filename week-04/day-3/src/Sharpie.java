public class Sharpie {

  // fields
  private String color;
  private float width;
  private float inkAmount;


  // constructors
  public Sharpie(String color, float inkAmount) {
    this.color = color;
    this.width = 100;
    this.inkAmount = inkAmount;
  }


  // getters and setters
  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public float getWidth() {
    return width;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public float getInkAmount() {
    return inkAmount;
  }

  public void setInkAmount(float inkAmount) {
    this.inkAmount = inkAmount;
  }

  // methods
  public void use() {
    this.inkAmount--;
  }
}
