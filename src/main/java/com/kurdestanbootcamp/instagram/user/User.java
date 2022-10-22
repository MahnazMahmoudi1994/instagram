package com.kurdestanbootcamp.instagram.user;


import com.kurdestanbootcamp.instagram.comment.Comment;
import com.kurdestanbootcamp.instagram.common.BaseEntity;
import com.kurdestanbootcamp.instagram.follower.Follower;
import com.kurdestanbootcamp.instagram.following.Following;
import com.kurdestanbootcamp.instagram.like.Like;
import com.kurdestanbootcamp.instagram.post.Post;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_user",uniqueConstraints = {@UniqueConstraint(columnNames = {"username", "password"})})
@Data
@Audited
public class User extends BaseEntity {

    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Column(name = "username")
    private String username;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "phone_number", unique = true)
    private String phoneNumber;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @Column(name = "bio")
    private String bio;

    @Column(name = "email")
    private String email;

    @Column(name = "gender")
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Following> followings;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Follower> followers;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Post> posts;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "user",cascade = CascadeType.ALL)
    private List<Comment> comments;


}
