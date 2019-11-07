package com.greenfox.reddit.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
@Entity
public class Post {

  // region Fields
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long votes = 0;
  private String title;
  private String url;
  @CreatedDate
  private Date dateCreated = new Date();
  @ManyToOne
  private User createdBy;
  // endregion Fields


  // region Constructors
  public Post(String title, String url, User createdBy) {
    this.title = title;
    if (!url.startsWith("http://") && !url.startsWith("https://")) {
      url = "http://" + url;
    }
    this.url = url;
    this.createdBy = createdBy;
  }

  public Post(String title, String url) {
    this.title = title;
    if (!url.startsWith("http://") && !url.startsWith("https://")) {
      url = "http://" + url;
    }
    this.url = url;
  }
  // endregion Constructors
}
