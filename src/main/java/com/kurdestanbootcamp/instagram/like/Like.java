package com.kurdestanbootcamp.instagram.like;

import com.kurdestanbootcamp.instagram.common.BaseEntity;
import com.kurdestanbootcamp.instagram.post.Post;
import com.kurdestanbootcamp.instagram.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_like")
@Data
@Audited
public class Like extends BaseEntity {


    @ManyToOne()
    @JoinColumn(name="post_id")
    private Post post;


    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;




}
