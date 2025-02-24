package com.movievoting.movieVoting.response;

import lombok.Data;

@Data
public class ResponseError {
    String msg;

    public ResponseError(String msg) {
        this.msg = msg;
    }
}
