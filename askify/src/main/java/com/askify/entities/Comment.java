package com.askify.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")  // Her yorum bir gönderiye ait
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Her yorum bir kullanıcıya ait
    private User user;

    @Lob
    @Column(columnDefinition = "text")
    String text;
}
