package com.kurdestanbootcamp.instagram.follower;

import com.kurdestanbootcamp.instagram.user.UserMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-07T19:45:37+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class FollowerMapperImpl implements FollowerMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Follower toFollower(FollowerDTO followerDTO) {
        if ( followerDTO == null ) {
            return null;
        }

        Follower follower = new Follower();

        follower.setId( followerDTO.getId() );
        follower.setVersion( followerDTO.getVersion() );
        follower.setCreatedDate( followerDTO.getCreatedDate() );
        follower.setCreatedBy( followerDTO.getCreatedBy() );
        follower.setLastModifiedDate( followerDTO.getLastModifiedDate() );
        follower.setLastModifiedBy( followerDTO.getLastModifiedBy() );
        follower.setUser( userMapper.toUser( followerDTO.getUser() ) );

        return follower;
    }

    @Override
    public FollowerDTO toFollowerDTO(Follower follower) {
        if ( follower == null ) {
            return null;
        }

        FollowerDTO followerDTO = new FollowerDTO();

        followerDTO.setId( follower.getId() );
        followerDTO.setVersion( follower.getVersion() );
        followerDTO.setCreatedDate( follower.getCreatedDate() );
        followerDTO.setCreatedBy( follower.getCreatedBy() );
        followerDTO.setLastModifiedDate( follower.getLastModifiedDate() );
        followerDTO.setLastModifiedBy( follower.getLastModifiedBy() );
        followerDTO.setUser( userMapper.toUserDTO( follower.getUser() ) );

        return followerDTO;
    }

    @Override
    public List<FollowerDTO> toFollowerDTOS(List<Follower> followers) {
        if ( followers == null ) {
            return null;
        }

        List<FollowerDTO> list = new ArrayList<FollowerDTO>( followers.size() );
        for ( Follower follower : followers ) {
            list.add( toFollowerDTO( follower ) );
        }

        return list;
    }

    @Override
    public List<Follower> toFollowers(List<FollowerDTO> followerDTOS) {
        if ( followerDTOS == null ) {
            return null;
        }

        List<Follower> list = new ArrayList<Follower>( followerDTOS.size() );
        for ( FollowerDTO followerDTO : followerDTOS ) {
            list.add( toFollower( followerDTO ) );
        }

        return list;
    }
}
