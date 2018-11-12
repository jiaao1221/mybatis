package mapper;

import entity.User;

import java.util.List;

/**
 * Created by HASEE on 2018/11/12.
 */
public interface UserMapper {
    User selectUserById(Integer id);

    List<User> selectAllUser();

    void deleteUserById(Integer id);
}
