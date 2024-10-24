package ropold.cgn2405recapspring.model;

import lombok.With;

@With
public record TodoModel(
        String id,
        String todo,
        String description,
        TodoStatus status
) {
}
