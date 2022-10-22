package com.kurdestanbootcamp.instagram.comment;

import com.kurdestanbootcamp.instagram.common.BaseEntity;
import com.kurdestanbootcamp.instagram.post.Post;
import com.kurdestanbootcamp.instagram.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "tbl_comment")
@Data
@Audited
public class Comment extends BaseEntity {
    @NotNull
    @Column(name = "text")
    private String text;

    @ManyToOne()
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;


}
