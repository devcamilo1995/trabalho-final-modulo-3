package com.dbc.trabalhovemser.controller;

import com.dbc.trabalhovemser.dto.HoteisDTO;
import com.dbc.trabalhovemser.dto.QuartosDTO;
import com.dbc.trabalhovemser.service.HoteisService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Validated
@RestController
@RequestMapping("/hoteis")
@Slf4j
@RequiredArgsConstructor
public class HoteisController {
    private final HoteisService hoteisService;

//    @ApiOperation(V)
    @GetMapping
    public List<HoteisDTO> list(){
        return hoteisService.list();
    }


}
