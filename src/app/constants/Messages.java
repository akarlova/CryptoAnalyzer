package app.constants;

public enum Messages {

    START_MENU("""
            CAESAR CRYPTO ANALYZER
            Пожалуйста, выбери опцию:
            1 - Зашифровать файл
            2 - Расшифровать файл по ключу
            3 - Расшифровка Brute Force
            4 - Расшифровка методом статистического анализа
            5 - Выход
            """),
    INVALID_OPTION("Такая опция отсутствует. Попробуй еще раз"),
    PLEASE_ENTER_FILE_PATH_FOR_HANDLING("Пожалуйста, введи путь к файлу, который обрабатываем"),
    PLEASE_ENTER_KEY("Введите ключ шифра"),
    PLEASE_ENTER_FILE_PATH_FOR_SAVING("Пожалуйста, введи путь к файлу, в который сохраним результат"),
    TRY_AGAIN ("Попробуй заново"),
    FILE_NOT_FOUND("Такой файл не найден: "),
    KEY_NOT_FOUND ("Такого ключа не существует"),
    PATH_NOT_FOUND ("Что-то не так с путем к файлу"),
    KEY_IS_GENERATED ("Возникла ошибка. Мы сгенерировали ключ для тебя: "),
    YOUR_KEY ("Твой ключ: "),
    RESULT_WILL_BE_SAVED_TO("Результат будет сохранен в: "),
    APP_CLOSED("Работа приложения завершена"),
    EMPTY_DATA("Вы передали пустые данные"),
    HANDLING_FILE_EXCEPTION ("Что-то пошло не так при чтении и записи файла: "),
    SUCCESS("Всё получилось! Твой результат здесь: ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
