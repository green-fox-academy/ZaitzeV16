package postit;

public class Main {
  public static void main(String[] args) {
    PostIt postIt1 = new PostIt("orange", "pink", "Idea1");
    System.out.println(String.join(", ", postIt1.backgroundColor, postIt1.text, postIt1.textColor));

    PostIt postIt2 = new PostIt("pink", "black", "Awesome");
    System.out.println(String.join(", ", postIt2.backgroundColor, postIt2.text, postIt2.textColor));

    PostIt postIt3 = new PostIt("yellow", "green", "Superb!");
    System.out.println(String.join(", ", postIt3.backgroundColor, postIt3.text, postIt3.textColor));
  }
}
