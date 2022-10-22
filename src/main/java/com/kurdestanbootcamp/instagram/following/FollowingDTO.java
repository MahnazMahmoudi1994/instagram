package com.kurdestanbootcamp.instagram.following;

import com.kurdestanbootcamp.instagram.common.BaseDTO;
import com.kurdestanbootcamp.instagram.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FollowingDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String fullName;

    @ApiModelProperty(required = true,hidden = false)
    private String username;

    @ApiModelProperty(required = false,hidden = false)
    private String profilePhoto;

    @ApiModelProperty(required = true,hidden = false)
    private UserDTO user;
}
