package AB1;

/**
 * This class implements an encoder from ASCII character to Braille binary representation.
 * In Braille binary representation a 2D Braille cell is represented by one byte,
 * where each dot is mapped to one specific bit.
 *
 * <p> The encoder utilizes a lookup table ({@code brailleLUT}) of predefined binary values
 * corresponding to ASCII characters </p>
 */
public class BrailleEncoder implements AB1.Interfaces.Encoder {

    /**
     * Lookup table (LUT) for Braille character encoding.
     *
     * <p>This array holds the Braille cells binary representation for all lower case ASCII letters ('a' to 'z').
     * Index 0 corresponds to letter 'a', index 1 to letter 'b', index 2 to letter 'c' and so on.
     * The binary representation of each letter specifies which dots are set within the letter's Braille cell,
     * a 2x3 dot matrix configuration of specific dots set (1 or 0).</p>
     *
     * The LUT must be used by the class method {@code toBinary}.
     */
    // DONE: choose appropriate access modifier (public/private)
    private static final byte[] brailleLUT = {
            0b000001, // a
            0b000011, // b
            0b001001, // c
            0b011001, // d
            0b010001, // e
            0b001011, // f
            0b011011, // g
            0b010011, // h
            0b001010, // i
            0b011010, // j
            0b000101, // k
            0b000111, // l
            0b001101, // m
            0b011101, // n
            0b010101, // o
            0b001111, // p
            0b011111, // q
            0b010111, // r
            0b001110, // s
            0b011110, // t
            0b100101, // u
            0b100111, // v
            0b111010, // w
            0b101101, // x
            0b111101, // y
            0b110101, // z
            // DONE: complete the array: add binary representation for letters f-z
            //       for details on the Braille alphabet see
            //       https://de.wikipedia.org/w/index.php?title=Brailleschrift#Systematik_des_Punkteaufbaus
    };

    /**
     * Encoder for ASCII to binary representation of a Braille cell.
     *
     * <p>This method encodes a given ASCII character from range [a-z] to it's
     * corresponding Braille binary representation. The method implementation relies on the lookup table (LUT) {@code brailleLut}. </p>
     *
     * @param asciiChar an ASCII character from the lower case alphabet ['a','z']
     *                  <p>Precondition: (asciiChar>='a') && (asciiChar<='z')</p>
     */
    // DONE: choose appropriate access modifier (public/private)
    @Override
    public byte toBinary(char asciiChar) {
        // DONE: implementation
        return brailleLUT[asciiChar - 'a'];
    }


}
