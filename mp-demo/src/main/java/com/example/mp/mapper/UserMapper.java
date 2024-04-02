package com.example.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mp.entity.ProductVo;
import com.example.mp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xi
 * @create 2024/4/1 11:08
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<User> queryUserByIds(@Param("ids") List<Long> ids);

    //多表查询用VO接收(sql里的username用name别名对应上vo的字段)
    @Select("select p.*,u.username name from product p,tb_user u where p.user_id=u.id and u.id=#{id};")
    List<ProductVo> queryProductVo(Integer id);
}
