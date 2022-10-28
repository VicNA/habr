package ru.geekbrains.habr.entities;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "articles")
@Data
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

//    @ManyToOne
//    @JoinColumn(name = "status_id")
//    private Status status;

//    @OneToMany(mappedBy = "article")
//    private List<Comment> comments;

//    @ManyToMany
//    @JoinTable(name = "articles_categories",
//            joinColumns = @JoinColumn(name = "article_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ManyToMany(mappedBy = "articles")
    private Collection<Category> categories;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
