public class PostIt {

  /*
  Create a PostIt class that has
      a backgroundColor
      a text on it
      a textColor
  Create a few example post-it objects:
      an orange with blue text: "Idea 1"
      a pink with black text: "Awesome"
      a yellow with green text: "Superb!"
   */
  String backgroundColor;
  String text;
  String textColor;

  // constructors
  public PostIt(String backgroundColor, String text, String textColor) {
    this.backgroundColor = backgroundColor;
    this.text = text;
    this.textColor = textColor;
  }

  public static void main(String[] args) {
    PostIt postIt1 = new PostIt("orange", "pink", "Idea1");
    System.out.println(String.join(", ", postIt1.backgroundColor, postIt1.text, postIt1.textColor));

    PostIt postIt2 = new PostIt("pink", "black", "Awesome");
    System.out.println(String.join(", ", postIt2.backgroundColor, postIt2.text, postIt2.textColor));

    PostIt postIt3 = new PostIt("yellow", "green", "Superb!");
    System.out.println(String.join(", ", postIt3.backgroundColor, postIt3.text, postIt3.textColor));
  }
}
