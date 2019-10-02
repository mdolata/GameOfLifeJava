package com.mdolat.gameoflife.board;

public class ErrorMessage {
    private final String message;

    static ErrorMessage of(String message) {
        return new ErrorMessage(message);
    }

    private ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ErrorMessage that = (ErrorMessage) o;

        return message != null ? message.equals(that.message) : that.message == null;
    }
}
