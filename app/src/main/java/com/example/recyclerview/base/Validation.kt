package com.example.recyclerview.base

import android.util.Patterns

private const val PATTERN_FOR_WORD = "^[a-zA-z][a-zA-Z]*$"
private const val PATTERN_FOR_EMAIL = "^[a-z]{1}[a-z0-9._]+@[a-z0-9]+[.][a-z]*$"
private const val PATTERN_FOR_PHONE_NUMBER = "^[6-9]{1}[0-9]{9}"
private const val PATTERN_FOR_PASSWORD =
    "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}\$"

class Validation {

    fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    fun isValidUsername(name: String): Boolean {
        return PATTERN_FOR_WORD.toRegex().matches(name);
    }

    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        return PATTERN_FOR_PHONE_NUMBER.toRegex().matches(phoneNumber);
    }

    fun isValidPassword(password: String): Boolean {
        return PATTERN_FOR_PASSWORD.toRegex().matches(password);
    }
}