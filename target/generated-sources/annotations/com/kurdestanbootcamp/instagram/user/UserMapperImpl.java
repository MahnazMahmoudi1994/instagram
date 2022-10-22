package com.kurdestanbootcamp.instagram.user;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T19:45:37+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toUser(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setVersion( userDTO.getVersion() );
        user.setCreatedDate( userDTO.getCreatedDate() );
        user.setCreatedBy( userDTO.getCreatedBy() );
        user.setLastModifiedDate( userDTO.getLastModifiedDate() );
        user.setLastModifiedBy( userDTO.getLastModifiedBy() );
        user.setFullName( userDTO.getFullName() );
        user.setUsername( userDTO.getUsername() );
        user.setPassword( userDTO.getPassword() );
        user.setPhoneNumber( userDTO.getPhoneNumber() );
        user.setProfilePhoto( userDTO.getProfilePhoto() );
        user.setBio( userDTO.getBio() );
        user.setEmail( userDTO.getEmail() );
        user.setGender( userDTO.getGender() );

        return user;
    }

    @Override
    public UserDTO toUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setVersion( user.getVersion() );
        userDTO.setCreatedDate( user.getCreatedDate() );
        userDTO.setCreatedBy( user.getCreatedBy() );
        userDTO.setLastModifiedDate( user.getLastModifiedDate() );
        userDTO.setLastModifiedBy( user.getLastModifiedBy() );
        userDTO.setFullName( user.getFullName() );
        userDTO.setUsername( user.getUsername() );
        userDTO.setPassword( user.getPassword() );
        userDTO.setPhoneNumber( user.getPhoneNumber() );
        userDTO.setProfilePhoto( user.getProfilePhoto() );
        userDTO.setBio( user.getBio() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setGender( user.getGender() );

        return userDTO;
    }

    @Override
    public List<UserDTO> toUserDTOS(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDTO> list = new ArrayList<UserDTO>( users.size() );
        for ( User user : users ) {
            list.add( toUserDTO( user ) );
        }

        return list;
    }

    @Override
    public List<User> toUsers(List<UserDTO> userDTOS) {
        if ( userDTOS == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userDTOS.size() );
        for ( UserDTO userDTO : userDTOS ) {
            list.add( toUser( userDTO ) );
        }

        return list;
    }
}
