package com.kurdestanbootcamp.instagram.like;

import com.kurdestanbootcamp.instagram.common.BaseDTO;
import com.kurdestanbootcamp.instagram.post.PostDTO;
import com.kurdestanbootcamp.instagram.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class LikeDTO extends BaseDTO {

    @ApiModelProperty(required = true)
    private PostDTO post;
    @ApiModelProperty(required = true)
    private UserDTO user;

}
