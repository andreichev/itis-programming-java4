package ru.itis.ideas_api.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorEntity {
    // Общие ошибки
    INVALID_REQUEST(0, "Неверный запрос"),
    INVALID_TOKEN(1, "Ошибка авторизации"),
    NOT_FOUND(2, "Не найдено"),
    EMAIL_ALREADY_TAKEN(3, "Email уже занят"),

    // Отправка смс
    TOO_OFTEN_OTP(4, "Слишком мало времени прошло с отправки предыдущей смс."),
    PHONE_NOT_FOUND(5, "На этот телефон не был отправлен код."),
    INVALID_OTP(6, "Неверный код"),

    // Ошбика создания Idea
    BLANK_IDEA_NAME(7, "Имя не может быть пустым"),
    BLANK_IDEA_DESCRIPTION(8, "Поле description не может быть пустым"),

    // Получение Idea
    IDEA_NOT_FOUND(9, "Запись не найдена"),

    // Ошбика создания Comment
    BLANK_COMMENT_TEXT(454, "Комментарий не может быть пустым"),

    // Получение Comment
    COMMENT_NOT_FOUND(404, "Комментарий не найден"),

    // Регистрация
    PASSWORD_TOO_SHORT(10, "Пароль слишком короткий"),
    INVALID_EMAIL(11, "Некорректный Email"),

    // Вход
    USER_NOT_FOUND(12, "Пользователь не найден"),
    INCORRECT_PASSWORD(13, "Неверный пароль"),

    // Выгрузка картинки
    ONLY_IMAGES_AVAILABLE_TO_UPLOAD(14, "Выгружать можно только картинки"),
    ;

    int status;
    String message;

    ErrorEntity(int status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String rawValue() {
        return toString();
    }
}
