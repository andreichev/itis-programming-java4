package ru.itis.ideas_api.exceptions;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ErrorEntity {
    // Общие ошибки
    INVALID_REQUEST(400, "Неверный запрос"),
    INVALID_TOKEN(403, "Ошибка авторизации"),
    NOT_FOUND(404, "Не найдено"),
    EMAIL_ALREADY_TAKEN(453, "Email уже занят"),

    // Отправка смс
    PHONE_NOT_FOUND(404, "На этот телефон не был отправлен код."),
    INVALID_OTP(450, "Неверный код"),

    // Ошбика создания Idea
    BLANK_IDEA_NAME(454, "Имя не может быть пустым"),
    BLANK_IDEA_DESCRIPTION(455, "Поле description не может быть пустым"),
    USER_ID_EMPTY(456, "Поле authorId не может быть пустым"),

    // Получение Idea
    IDEA_NOT_FOUND(404, "Запись не найдена"),

    // Регистрация
    PASSWORD_TOO_SHORT(460, "Пароль слишком короткий"),
    INVALID_EMAIL(461, "Некорректный Email"),

    // Вход
    USER_NOT_FOUND(404, "Пользователь не найден"),
    INCORRECT_PASSWORD(460, "Неверный пароль"),

    // Выгрузка картинки
    ONLY_IMAGES_AVAILABLE_TO_UPLOAD(460, "Выгружать можно только картинки"),
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
