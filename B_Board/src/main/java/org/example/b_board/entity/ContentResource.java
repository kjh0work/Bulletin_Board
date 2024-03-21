package org.example.b_board.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Getter;
import lombok.Setter;
import org.example.b_board.ContentController;
import org.springframework.hateoas.RepresentationModel;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Getter
@Setter
public class ContentResource extends RepresentationModel<Content> {

    @JsonUnwrapped
    private Content content;

    public ContentResource(Content content) {
        this.content = content;
        add(linkTo(ContentController.class).slash(content.getId()).withSelfRel());
    }
}
