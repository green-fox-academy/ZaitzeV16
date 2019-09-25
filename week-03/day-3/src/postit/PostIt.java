package postit;

public class PostIt {

  /*
  Create a postit.PostIt class that has
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
}
