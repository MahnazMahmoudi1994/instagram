package com.kurdestanbootcamp.instagram.user;

import com.kurdestanbootcamp.instagram.common.BaseDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
public class UserDTO extends BaseDTO {

    @ApiModelProperty(required = true,hidden = false)
    private String fullName;

    @ApiModelProperty(required = true,hidden = false)
    private String username;

    @ApiModelProperty(required = true,hidden = false)
    private String password;

    @ApiModelProperty(required = true,hidden = false)
    private String phoneNumber;

    @ApiModelProperty(required = false,hidden = false)
    private String profilePhoto;

    @ApiModelProperty(required = false,hidden = false)
    private String bio;

    @ApiModelProperty(required = false,hidden = false)
    private String email;

    @ApiModelProperty(required = false,hidden = false)
    private Gender gender;
}
