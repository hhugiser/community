package com.hhugiser.community.mapper;

import com.hhugiser.community.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @PROJECT_NAME: community
 * @DESCRIPTION:
 * @USER: huxun
 * @DATE: 2021/1/28 21:14
 */
@Mapper
public interface UserMapper {

  void insert(User user);
}
