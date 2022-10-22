package com.kurdestanbootcamp.instagram.post;

import com.kurdestanbootcamp.instagram.comment.Comment;
import com.kurdestanbootcamp.instagram.common.BaseEntity;
import com.kurdestanbootcamp.instagram.like.Like;
import com.kurdestanbootcamp.instagram.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_post")
@Data
@Audited

public class Post extends BaseEntity {

    @Column(name = "text")
    private String text;

    @NotNull
    @Column(name = "image")
    private String image;

    @Column(name = "numberOfLike")
    private Long numberOfLike;

    @Column(name = "numberOfComment")
    private Long numberOfComment;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Like> like;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comment;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;
}
