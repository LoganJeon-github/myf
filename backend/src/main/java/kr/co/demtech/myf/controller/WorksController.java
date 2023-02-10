package kr.co.demtech.myf.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.co.demtech.myf.domain.Work;
import kr.co.demtech.myf.service.WorksService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@RestController
@Slf4j
public class WorksController {
  private final WorksService worksService;

  @GetMapping("/work-state")
  public List<Work> getWorks() {
    List<Work> works = worksService.getWorks();
    return works;
  }

  @PostMapping("/change-state")
  public ResponseEntity<HttpStatus> updateWorks(@RequestBody Work param) {
    log.info(param.toString());
    LocalDateTime current = LocalDateTime.now();
    Timestamp ts = Timestamp.valueOf(current);
    if (param.isWorkState() == false) {
      param.setWorkOutAt(ts);
    } else {
      param.setWorkInAt(ts);
    }
    worksService.updateWorks(param);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
