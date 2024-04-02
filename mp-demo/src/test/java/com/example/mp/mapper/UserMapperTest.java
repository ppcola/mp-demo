package com.example.mp.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.mp.entity.User;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;

import java.sql.Wrapper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author xi
 * @create 2024/4/1 11:14
 */
@SpringBootTest
@MapperScan("com.example.mp.mapper")
@Repository
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testQueryWrapper(){
        // 1.构建查询条件 where name like "%o%" AND balance >= 1000
        QueryWrapper<User> wrapper = new QueryWrapper<User>()
                .select("id", "username", "info", "balance")
                .like("username", "o")
                .ge("balance", 1000);
// 2.查询数据
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    void test(){
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void save(){
        User user = new User();
        user.setUsername("梅西");
        user.setPassword("123456");
        user.setInfo("{\"age\": 30, \"intro\": \"足球\", \"gender\": \"male\"}");
        userMapper.insert(user);
    }

    @Test
    void delete(){
        userMapper.deleteById(501014);
    }

    @Test
    void update(){
        User user = userMapper.selectById(1);
        user.setUsername("小丽");
        userMapper.updateById(user);
    }

    @Test
    void testQueryByIds(){
        List<User> users=userMapper.queryUserByIds(List.of(1L,2L,3L,4L));
        users.forEach(System.out::println);
    }

    @Test
    void select(){
//        不加任何条件,全部查询
//        userMapper.selectList(null);

//        单条件查询
//        QueryWrapper wrapper = new QueryWrapper<>();
//        wrapper.eq("id","2");

//        多条件查询
//        QueryWrapper wrapper = new QueryWrapper();
//        Map<String,Object> map = new HashMap<>();
//        map.put("password","123456");
//        map.put("username","梅西");
//        wrapper.allEq(map);

        //lt;gt;ne分别是小于;大于;不等于   ||ge是大于等于;le是小于等于

//        模糊查询
//        wrapper.like("username","o");  //相当于like %参数%
//        wrapper.likeLeft("username","小") //相当于like '%小' (即为查询以小结尾的名字)
//        wrapper.likeRight("username","小") //相当于like '小%' (即为查询以小开头的名字)

//        inSql 下面两条会查询时进行嵌套
//        wrapper.inSql("id","select id from tb_user where id <3");
//        wrapper.inSql("age","select id from tb_user where age >5");
//        wrapper.orderByDesc("id");  //降序
//        wrapper.having("id>1")

//        System.out.println(userMapper.selectList(wrapper));

//        根据单个条件查询
//        System.out.println(userMapper.selectById(3));
//        查询多个
//        userMapper.selectBatchIds(Arrays.asList(1,2,3)).forEach(System.out::println);

//        使用map根据多个条件查询
//        Map<String,Object> map = new HashMap<>();
//        map.put("status","1");
//        map.put("password","123456");
//        userMapper.selectByMap(map).forEach(System.out::println);

        //根据wrapper将查询的结果集封装到Map里
//        userMapper.selectMaps(wrapper).forEach(System.out::println);
    }

    @Test
    void productVoList(){
        userMapper.queryProductVo(10).forEach(System.out::println);
    }

}