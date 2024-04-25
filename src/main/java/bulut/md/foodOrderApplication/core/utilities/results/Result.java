package com.northwind.northwind.core.utilities.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Result {
    private final boolean success;
    private String message;
}
