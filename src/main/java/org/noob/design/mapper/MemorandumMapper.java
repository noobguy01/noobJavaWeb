package org.noob.design.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.noob.design.pojo.Memorandum;
import org.noob.design.pojo.User;

import java.util.List;

@Mapper
public interface MemorandumMapper {
    @Insert("INSERT INTO memorandum VALUES (NULL,#{title},#{all_text},#{time},#{user_id})")
    void insert(Memorandum memorandum);
    @Select("select * from  memorandum where user_id = #{id} order by time desc")
    List<Memorandum> getAllMemorandum(User user ) ;
    @Delete("delete  from memorandum where id = #{id}")
    void deleteById(Integer id);
}
