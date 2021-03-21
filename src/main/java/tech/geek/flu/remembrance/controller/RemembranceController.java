package tech.geek.flu.remembrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.geek.flu.remembrance.application.service.RemembranceApplicationService;
import tech.geek.flu.remembrance.domain.entity.Remembrance;
import tech.geek.flu.remembrance.request.RemembranceRequest;
import tech.geek.flu.remembrance.response.RemembranceResponse;
import tech.geek.flu.remembrance.transform.RemembranceResponseMapper;

import javax.validation.Valid;

@RestController
@RequestMapping("/remembrance")
public class RemembranceController {

  @Autowired
  private RemembranceApplicationService applicationService;

  @Autowired
  private RemembranceResponseMapper remembranceResponseMapper;

  @GetMapping("")
  public String hello() {
    return "Version: 0.0.1";
  }

  @PostMapping("/bootstrap")
  public RemembranceResponse bootstrapEvent(@RequestBody @Valid RemembranceRequest remembranceRequest) {
    Remembrance remembrance = applicationService.boostrapRemembrance(remembranceRequest.getRemembranceName(), remembranceRequest.getRemembranceDescription());
    return remembranceResponseMapper.toEpicEventResponse(remembrance);
  }

}
