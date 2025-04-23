package org.example.diaryserver.controller

import org.example.diaryserver.model.Work
import org.example.diaryserver.service.WorkService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/work")
class WorkController(
    private val workServer: WorkService
) {

//    @PostMapping
//    fun addWork(@RequestBody work: Work) {
//
//    }

    @GetMapping("/{id}")
    fun getWork(@PathVariable("id") id: Long): Work? {
        return workServer.getById(id)
    }
}