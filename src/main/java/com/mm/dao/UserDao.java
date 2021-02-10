package com.mm.dao;

import com.mm.model.User;

/**
 * @author CXH2015
 * @date 2021/2/10
 */
public interface UserDao {
  User getUserById(Long id);
}
