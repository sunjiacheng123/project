package sun.mapper;

import sun.base.BaseMapper;
import sun.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}