package api.study.pjq.core.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by alex on 2018/6/28.
 */
@Setter
@Getter
public class StudyResponseEntity<T> {

    private String status;

    private String code;

    private String desc;

    private T data;

    public StudyResponseEntity() {
    }

    public StudyResponseEntity(String status, String code) {
        this.status = status;
        this.code = code;
    }

    public StudyResponseEntity(String status, String code, T data) {
        this.status = status;
        this.code = code;
        this.data = data;
    }

    public StudyResponseEntity(String status, String code, String desc) {
        this.status = status;
        this.code = code;
        this.desc = desc;
    }
    public StudyResponseEntity(String status, String code, T data, String desc) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.desc = desc;
    }

    public static <T> StudyResponseEntity<T> ok(T data) {
        return new StudyResponseEntity<>("SUCC","200", data);
    }

    public static <T> StudyResponseEntity<T> ok() {
        return new StudyResponseEntity<>("SUCC","200");
    }

    public static <T> StudyResponseEntity<T> ok(T data, String desc) {
        return new StudyResponseEntity<>("SUCC","200", data,desc);
    }

    public static <T> StudyResponseEntity<T> success(String code, T data) {
        return new StudyResponseEntity<>("SUCC",code, data);
    }

    public static <T> StudyResponseEntity<T> success(String code, T data, String desc) {
        return new StudyResponseEntity<>("SUCC",code, data,desc);
    }



    public static StudyResponseEntity warn(String code, String desc) {
        return new StudyResponseEntity<>("FAIL",code, desc);
    }

    public static <T>StudyResponseEntity<T> warn(String code, T data, String desc) {
        return new StudyResponseEntity<>("FAIL",code,data, desc);
    }

}
