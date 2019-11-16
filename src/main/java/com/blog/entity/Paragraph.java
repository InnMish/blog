package com.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paragraph", schema = "public")
public class Paragraph {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name= "increment", strategy= "increment")
    private long id;

    @Column(name = "paragraph_text")
    private String paragraphText;

    @Column(name = "image")
    private byte[] image;

    @Column(name = "paragraph_order")
    private int paragraphOrder;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
}
