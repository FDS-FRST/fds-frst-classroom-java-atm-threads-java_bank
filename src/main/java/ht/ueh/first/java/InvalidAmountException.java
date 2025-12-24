package ht.ueh.first.java;

//Les exceptions permettent d'eviter l'arret du programme en environnement multi-thread

    public class InvalidAmountException extends RuntimeException {
        public InvalidAmountException(String message) {
            super(message);
        }
    }

