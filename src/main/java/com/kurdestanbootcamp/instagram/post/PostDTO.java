package com.kurdestanbootcamp.instagram.post;

import com.kurdestanbootcamp.instagram.common.BaseDTO;
import com.kurdestanbootcamp.instagram.user.UserDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class PostDTO extends BaseDTO {

    @ApiModelProperty(required = false)
    private String text;

    @ApiModelProperty(required = true)
    private String image;

    @ApiModelProperty(required = false)
    private Long numberOfLike;

    @ApiModelProperty(required = false)
    private Long numberOfComment;

    @ApiModelProperty(required = true)
    private UserDTO user;

}
