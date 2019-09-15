package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article", schema = "public")
public class Article {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private long id;

    private String name;
    private String description;

    //additional fields
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
    private List<Paragraph> paragraphs;

    @ManyToOne
    private Category category;
}
