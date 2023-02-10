package kr.co.demtech.myf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import kr.co.demtech.myf.domain.Work;
import kr.co.demtech.myf.mapper.WorksMapper;

@Service
public class WorksService {
  @Autowired
  private WorksMapper worksMapper;

  public List<Work> getWorks() {
    return worksMapper.getWorks();
  }

  public void updateWorks(Work param) {
    worksMapper.updateWorks(param.getRoom(),
        param.isWorkState(),
        param.getWorkInAt(),
        param.getWorkOutAt());
  }

}
