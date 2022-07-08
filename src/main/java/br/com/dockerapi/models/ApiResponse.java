package br.com.dockerapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

    private LocalDateTime timestamp;
    private T data;
    private List<String> errors;

    public ApiResponse(T data) {
        this.timestamp = LocalDateTime.now();
        this.data = data;
        this.errors = null;
    }

    public ApiResponse(List<String> errors) {
        this.timestamp = LocalDateTime.now();
        this.data = null;
        this.errors = errors;
    }
}
