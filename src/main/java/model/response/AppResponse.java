package model.response;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AppResponse<T> implements Serializable {

    private T data;
    private String message;
    private int status;
    private Object error;

}
