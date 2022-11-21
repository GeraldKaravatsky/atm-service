package com.senla.courses.atm.service.exception;

public class ExceptionConstants {

    public static final String ATTEMPTS_EXCEEDED_ERROR_MESSAGE = "Attempts exceeded! The card will be blocked";

    public static final String AUTHORIZATION_ERROR_MESSAGE = "You are not authorized to do this action! Please authorize";

    public static final String CARD_BLOCKED_ERROR_MESSAGE = "Your card is blocked! The card will be unblocked one day after the blocking started";

    public static final String INCORRECT_CARD_NUMBER_ERROR_MESSAGE = "Incorrect card number format. " +
            "Please use this format: 'XXXX-XXXX-XXXX-XXXX' and try again";

    public static final String INCORRECT_PIN_CODE_ERROR_MESSAGE = "Incorrect pin-code. Try again";

    public static final String NO_MONEY_ERROR_MESSAGE = "There are not enough money on the account or the ATM limit has been exceeded";

    public static final String INCORRECT_VALUE = "Incorrect value. Please try again";

    public static final String REPLENISHMENT_AMOUNT_ERROR = "The replenishment amount should not exceed 1,000,000";

    private ExceptionConstants() {

    }

}
