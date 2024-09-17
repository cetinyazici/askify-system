package com.askify.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "p_like")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @ManyToOne
    @JoinColumn(name = "post_id")    // Her "like" bir gönderiye ait.
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id")  // Her "like" bir kullanıcıya ait.
    private User user;
}
