package org.example;

import lombok.Getter;

/**
 *author Kacper Mazur
 *  *  @version 1.0
 * Klasa pomocnicza przechowująca dane statyczne, takie jak nazwa użytkownika i hasło.
 */
@Getter
public class getData {
    /**
     * Nazwa użytkownika, używana w całej aplikacji.
     */
    public static String username;

    /**
     * Hasło używane w aplikacji do zalogowania.
     */
    public static String path;
}
