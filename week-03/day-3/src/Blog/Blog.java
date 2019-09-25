package Blog;

import java.util.ArrayList;

public class Blog {
  /*
  # Blog

   -  Reuse your `BlogPost` class
   -  Create a `Blog` class which can
       -  store a list of BlogPosts
       -  add BlogPosts to the list
       -  delete(int) one item at given index
       -  update(int, BlogPost) one item at the given index and update it with another BlogPost
   */

  ArrayList<BlogPost> blogPosts = new ArrayList<>();

  // functions
  public void add(String authorName, String title, String text, String publicationDate) {
    this.blogPosts.add(new BlogPost(authorName, title, text, publicationDate));
  }

  public void delete(int index) {
    this.blogPosts.remove(index);
  }

  public void update(int index, BlogPost blogPost) {
    this.blogPosts.set(index, blogPost);
  }
}
