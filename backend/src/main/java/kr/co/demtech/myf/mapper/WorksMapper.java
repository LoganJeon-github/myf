package kr.co.demtech.myf.mapper;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import kr.co.demtech.myf.domain.Work;

@Mapper
public interface WorksMapper {

  public List<Work> getWorks();

  public void updateWorks(@Param("room") int room,
      @Param("workState") boolean workState,
      @Param("workInAt") Timestamp workInAt,
      @Param("workOutAt") Timestamp workOutAt);
}
