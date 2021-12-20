package fr.acore.api.test.list;

import fr.acore.api.list.ListHelper;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListHelperTest implements ListHelper {


    @Test
    public void testAddBefore(){
        List<String> primaryList = Arrays.asList("chien", "chat", "cochon", "poney");
        List<String> resultList = Arrays.asList("chien", "chat", "cochon", "poney","miaou");

        List<String> addBeforeList = addBefore(primaryList, "miaou", 4);

        assertNotEquals(primaryList, addBeforeList);
        assertEquals(resultList, addBeforeList);
    }

    @Test
    public void testAddAfter(){
        List<String> primaryList = Arrays.asList("chien", "chat", "cochon", "poney");
        List<String> resultList = Arrays.asList("chien", "chat", "miaou", "cochon", "poney");

        List<String> addAfterList = addAfter(primaryList, "miaou", 1);

        assertNotEquals(primaryList, addAfterList);
        assertEquals(resultList, addAfterList);
    }

}
