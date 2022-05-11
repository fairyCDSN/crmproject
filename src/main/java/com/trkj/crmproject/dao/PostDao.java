package com.trkj.crmproject.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.trkj.crmproject.entity.mybatis.Post;
import com.trkj.crmproject.entity.mybatis_plus.PostMp;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
@Mapper
public interface PostDao extends BaseMapper<PostMp> {
    int deleteByPrimaryKey(Integer post_id);

    int insert(Post record);

    int insertSelective(Post record);

    Post selectByPrimaryKey(Integer post_id);

    int updateByPrimaryKeySelective(Post record);

    int updateByPrimaryKey(Post record);
}
