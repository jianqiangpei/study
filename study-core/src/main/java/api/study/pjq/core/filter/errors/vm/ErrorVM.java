package api.study.pjq.core.filter.errors.vm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ErrorVM implements Serializable {

    private static final long serialVersionUID = 2135012448840967460L;

    private final String status;
    private final String code;
    private final String desc;

    private List<FieldErrorVM> fieldErrors;

    public ErrorVM(String message) {
        this(message, null);
    }

    public ErrorVM(String code, String desc) {
        this.status = "FAIL";
        this.code = code;
        this.desc = desc;
    }

    public ErrorVM(String status, String code, String desc, List<FieldErrorVM> fieldErrors) {
        this.status = status;
        this.code = code;
        this.desc = desc;
        this.fieldErrors = fieldErrors;
    }

    public void add(String objectName, String field, String message) {
        if (fieldErrors == null) {
            fieldErrors = new ArrayList<>();
        }
        fieldErrors.add(new FieldErrorVM(objectName, field, message));
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public List<FieldErrorVM> getFieldErrors() {
        return fieldErrors;
    }






}
