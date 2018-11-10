package api.study.pjq.core.filter.errors.vm;

import java.io.Serializable;

public class FieldErrorVM implements Serializable {


    private static final long serialVersionUID = 6233267055797675232L;

    private final String objectName;

    private final String field;

    private final String message;

    public FieldErrorVM(String dto, String field, String message) {
        this.objectName = dto;
        this.field = field;
        this.message = message;
    }

    public String getObjectName() {
        return objectName;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }


}
