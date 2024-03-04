package com.sixcandoit.plrecipe_post.config;

import lombok.*;

import java.util.Map;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ResponseMessage {
    private int httpStatus;
    private String message;
    private Map<String, Object> result;

}
