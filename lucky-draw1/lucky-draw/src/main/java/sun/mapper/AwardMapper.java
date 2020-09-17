package sun.mapper;

import sun.base.BaseMapper;
import sun.model.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AwardMapper extends BaseMapper<Award> {

    List<Award> query(Award award);
}