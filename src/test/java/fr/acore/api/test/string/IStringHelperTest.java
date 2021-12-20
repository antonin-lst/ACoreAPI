package fr.acore.api.test.string;

import fr.acore.api.string.IStringHelper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class IStringHelperTest implements IStringHelper {

    @Test
    public void testIsInt(){
        assertTrue(isInt("13"));
        assertFalse(isInt("aa1"));
    }

    @Test
    public void testIsDouble(){
        assertTrue(isDouble("13.55d"));
        assertFalse(isDouble("13aaa"));
    }

    @Test
    public void testIsFloat(){
        assertTrue(isFloat("13.5f"));
        assertFalse(isFloat("asfg"));
    }

    @Test
    public void testIsByte(){
        assertTrue(isByte("2"));
        assertFalse(isByte("adf"));
    }

    @Test
    public void testIsBoolean(){
        assertTrue(isBoolean("false"));
        assertTrue(isBoolean("true"));
        assertFalse(isBoolean("atrueees"));
    }

}
