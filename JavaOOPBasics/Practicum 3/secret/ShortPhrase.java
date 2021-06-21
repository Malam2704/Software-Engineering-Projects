package secret;

/**
 * A short secret phrase with 5 characters. Suitable for testing with debugging.
 * A solution should be found very quickly.
 */
public class ShortPhrase extends SecretPhrase {
    /**
     * The secret phrase encoded as octal integers.
     */
    private static final int[] SECRET = {0105, 0170, 0141, 0155, 041};

    /**
     * Creates a new instance of the short phrase.
     */
    public ShortPhrase() {
        super(SECRET);
    }
    
}
