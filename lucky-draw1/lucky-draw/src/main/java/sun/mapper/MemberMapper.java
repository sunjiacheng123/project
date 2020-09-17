package sun.mapper;

import sun.base.BaseMapper;
import sun.model.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper extends BaseMapper<Member> {
}