package com.klab.todo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import com.klab.todo.validator.Advance;
import com.klab.todo.validator.TodoExists;

import lombok.Data;

@Data
public class TodoRequest {
    @NotNull(message = "Tood id must not be null")
    @Positive(message = "Tood id must be grater than 0")
    @TodoExists(groups = Advance.class)
    private Long id;

}
