package com.kurdestanbootcamp.instagram.follower_following;


import com.kurdestanbootcamp.instagram.common.BaseEntity;
import com.kurdestanbootcamp.instagram.follower.Follower;
import com.kurdestanbootcamp.instagram.following.Following;
import com.kurdestanbootcamp.instagram.user.User;
import lombok.Data;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_follower_following")
@Data
@Audited
public class FollowerFollowing extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "follower_id")
    private Follower follower;

    @ManyToOne
    @JoinColumn(name = "following_id")
    private Following following;
}
