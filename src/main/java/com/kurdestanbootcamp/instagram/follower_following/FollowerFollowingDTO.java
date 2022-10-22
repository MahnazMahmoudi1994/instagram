package com.kurdestanbootcamp.instagram.follower_following;

import com.kurdestanbootcamp.instagram.common.BaseDTO;
import com.kurdestanbootcamp.instagram.follower.Follower;
import com.kurdestanbootcamp.instagram.follower.FollowerDTO;
import com.kurdestanbootcamp.instagram.following.Following;
import com.kurdestanbootcamp.instagram.following.FollowingDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class FollowerFollowingDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private FollowerDTO follower;

    @ApiModelProperty(required = true,hidden = false)
    private FollowingDTO following;
}
