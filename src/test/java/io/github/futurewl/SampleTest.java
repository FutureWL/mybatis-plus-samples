package io.github.futurewl;

import io.github.futurewl.entity.User;
import io.github.futurewl.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SampleTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    void main() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}