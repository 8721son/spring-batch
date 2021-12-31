package com.batch.modules.batch.controller;

import com.batch.modules.batch.service.BatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BatchController {

    private final BatchService batchService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("list",batchService.getList());
        return "index";
    }
}
