package com.professional.bot.dialog;

import lombok.Getter;

@Getter
public enum DialogStatus {
    NOT_REGISTERED((short) 0),
    REGISTERED((short) 1),
    IN_MAIN_MENU((short) 2),
    UPLOADING_BOOK((short) 24),
    SUCCESSFULY_UPLOADED_BOOK((short) 241),
    BOOK_UPLOADING_FAILED((short) 243),
    SELECTING_BOOK((short) 26),
    EDITING_SELECTED_BOOK((short) 261),
    READING_SELECTED_BOOK((short) 262),
    DELETING_SELECTED_BOOK((short) 263);

    private final Short dialogStatusCode;

    DialogStatus(Short dialogStatusCode) {
        this.dialogStatusCode = dialogStatusCode;
    }
}
