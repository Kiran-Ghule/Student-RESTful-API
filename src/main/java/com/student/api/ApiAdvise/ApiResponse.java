package com.student.api.ApiAdvise;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

    //@JsonFormat(pattern = "dd:MM:yyyy hh:mm:ss")
    private LocalDateTime date;
    private T data;
    private ApiError err;

    public ApiResponse()
    {
        this.date=LocalDateTime.now();
    }

    public ApiResponse(T data)
    {
        this();
        this.data=data;
    }

    public ApiResponse(ApiError err)
    {
        this();
        this.err=err;
    }

}
