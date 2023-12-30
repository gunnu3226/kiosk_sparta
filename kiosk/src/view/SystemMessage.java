package view;

public enum SystemMessage {
    WELCOME_MESSAGE("\"SHAKESHACK BURGER에 오신걸 환영합니다.\""),
    INVAILD_INPUT("잘못된 입력입니다. 숫자로 다시 입력해 주세요.");

    private final String message;
    SystemMessage(String message) {
        this.message = message;
    }
}
