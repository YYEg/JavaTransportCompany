package YY.message;

public enum Message {
    EMPTY_RECORD_CHOSEN("Выберите товар из таблицы"),
    CONTAINS_EMPTY_FIELD("Заполните все поля");

    final String message;
    Message(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
