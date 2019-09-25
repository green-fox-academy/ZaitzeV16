package Blog;

public class BlogPost {

  /*
  # Blog

   -  Reuse your `BlogPost` class
   -  Create a `Blog` class which can
       -  store a list of BlogPosts
       -  add BlogPosts to the list
       -  delete(int) one item at given index
       -  update(int, BlogPost) one item at the given index and update it with another BlogPost
   */

  String authorName;
  String title;
  String text;
  String publicationDate;

  public BlogPost(String authorName, String title, String text, String publicationDate) {
    this.authorName = authorName;
    this.title = title;
    this.text = text;
    this.publicationDate = publicationDate;
  }
}
