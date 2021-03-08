package com.internship.service.model;

import com.internship.persistence.entity.CommunityEntity;
import com.internship.persistence.entity.UserCommunityEntity;
import com.internship.persistence.entity.UserEntity;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public class UserWrapper {

    Long id;
    String status;
    String firstName;
    List<String> communities;

    public UserWrapper(Long id,
                       String status,
                       String firstName) {
        this.id = id;
        this.status = status;
        this.firstName = firstName;
    }

    public UserWrapper(UserEntity user) {
        this.id = user.getId();
        this.status = user.getStatus();
        this.firstName = user.getFirstName();
        List<UserCommunityEntity> listOfUserCommunities = user.getListOfUserCommunities();
        if (!CollectionUtils.isEmpty(listOfUserCommunities)) {
            this.communities = listOfUserCommunities.stream().map(UserCommunityEntity::getCommunity)
                    .map(CommunityEntity::getName).collect(Collectors.toList());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<String> getCommunities() {
        return communities;
    }

    public void setCommunities(List<String> communities) {
        this.communities = communities;
    }
}
