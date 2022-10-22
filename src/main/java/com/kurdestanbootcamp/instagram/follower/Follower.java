package com.kurdestanbootcamp.instagram.follower;

import com.kurdestanbootcamp.instagram.common.BaseEntity;
import com.kurdestanbootcamp.instagram.follower_following.FollowerFollowing;
import com.kurdestanbootcamp.instagram.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "tbl_follower")
@Data
@Audited
public class Follower extends BaseEntity {

    @NotNull
    @Column(name = "full_name")
    private String fullName;

    @NotNull
    @Column(name = "username")
    private String username;

    @Column(name = "profile_photo")
    private String profilePhoto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "follower",cascade = CascadeType.ALL)
    private List<FollowerFollowing> followerFollowings;
}
