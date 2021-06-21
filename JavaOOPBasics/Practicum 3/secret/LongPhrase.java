package secret;

/**
 * A long secret phrase with 27 characters. A solution should be found very 
 * quickly.
 */
public class LongPhrase extends SecretPhrase {
    /**
     * A secret phrase encoded as octal integers.
     */
    private static final int[] SECRET = {
        0111, 0164, 047, 0163, 040, 0141, 040, 0163, 0145, 0143, 0162, 0145, 
        0164, 040, 0164, 0157, 040, 0145, 0166, 0145, 0162, 0171, 0142, 0157, 
        0144, 0171, 056
    };

    /**
     * Creates a new instance of the long phrase.
     */
    public LongPhrase() {
        super(SECRET);
    }
}
