package secret;

/**
 * A class that represents a secret phrase that can be guessed based on a
 * random mix of ASCII characters encoded as an array of integers.
 */
public abstract class SecretPhrase {
    /**
     * The secret phrase encoded as an array of integers.
     */
    private int[] secret;

    /**
     * Creates a new secret phrase with the specified phrase.
     * 
     * @param secret The secret phrase encoded as an integer array.
     */
    SecretPhrase(int[] secret) {
        this.secret = secret;
    }

    /**
     * Returns the number of characters in the phrase.
     * 
     * @return The number of characters in the phrase.
     */
    public int length() {
        return secret.length;
    }

    /**
     * Indicates whether or not a partial guess is "on track" meaning that its
     * length is less than or equal to the secret phrase and the characters
     * are all in the correct position. The method returns false if the guess
     * has any incorrect characters. 
     * 
     * @param guess An at least partial guess of the secret phrase.
     * 
     * @return True if the partial guess has the correct letters in the correct
     * positions. False otherwise.
     */
    public boolean onTrack(String guess) {
        char[] chars = guess.toCharArray();
        if(chars.length <= secret.length) {
            for(int i=0; i<chars.length; i++) {
                if(chars[i] != secret[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Returns true if the guess is correct, and false otherwise. A correct
     * guess must be the same length as the phrase and contain all of the 
     * correct characters in the correct positions.
     * 
     * @param guess The guess being checked against the phrase.
     * 
     * @return True if the guess is correct, and false otherwise.
     */
    public boolean guess(String guess) {
        return onTrack(guess) && guess.length() == secret.length;
    }
}
