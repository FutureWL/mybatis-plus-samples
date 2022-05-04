package io.github.futurewl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.futurewl.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
