package kamenev.model;

import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="text")
    private String text;

    @Column(name="author")
    private String author;

    @Column(name="date")
    private String date;

    public void setText(String text) {
        this.text = text;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getId() {
        return this.id;
    }

    public String getText() {
        return this.text;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getDate() {
        return this.date;
    }
}
