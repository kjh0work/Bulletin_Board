package org.example.b_board;

import org.example.b_board.entity.Content;
import org.example.b_board.entity.ContentResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping(path = "/api/contents", consumes = MediaType.APPLICATION_JSON_VALUE)
public class ContentController {

    @Autowired
    private ContentRepository repository;

    @PostMapping
    @ResponseBody
    public ResponseEntity createContent(@RequestBody Content content){

        Content saved = this.repository.save(content);
        ContentResource contentResource = new ContentResource(saved);

        return ResponseEntity.ok(contentResource);

    }

}
