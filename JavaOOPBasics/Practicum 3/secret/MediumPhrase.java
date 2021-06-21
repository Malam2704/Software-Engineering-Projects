package secret;

/**
 * A short secret phrase with 16 characters. A solution should be found very 
 * quickly. Testing with debugging on is not recommended.
 */
public class MediumPhrase extends SecretPhrase {
    private static final int[] SECRET = {
        0127, 0150, 0171, 040, 0163, 0157, 040, 0163, 0145, 0162, 0151, 0157, 
        0165, 0163, 077, 041
    };

    /**
     * Creates a new instance of the short phrase.
     */
    public MediumPhrase() {
        super(SECRET);
    }
    
}
