package Blog;

public class Main {

  public static void main(String[] args) {
  /*
  # Blog

   -  Reuse your `BlogPost` class
   -  Create a `Blog` class which can
       -  store a list of BlogPosts
       -  add BlogPosts to the list
       -  delete(int) one item at given index
       -  update(int, BlogPost) one item at the given index and update it with another BlogPost
   */

    Blog blog = new Blog();
    blog.add("my", "no title", "no text", "today");
    blog.add("my123", "no title123", "no text123", "today123");
    blog.add("my0", "no title0", "no text0", "today0");
    blog.add("m", "n", "n", "t");

    blog.delete(3);

    BlogPost blogPost = new BlogPost("WWW", "WWW", "WWW", "WWW");
    blog.update(1, blogPost);
  }
}
