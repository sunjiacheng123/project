package sun.mapper;

import sun.base.BaseMapper;
import sun.model.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {

    int batchAdd(@Param("awardId") Integer awardId, @Param("memberIds") List<Integer> memberIds);

    void deleteByCondition(Record r);

    int deleteBySettingId(Integer id);
}