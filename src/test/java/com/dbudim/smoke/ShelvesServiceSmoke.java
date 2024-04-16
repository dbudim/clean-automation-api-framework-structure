package com.dbudim.smoke;

import com.dbudim.fixtures.FixtureSmoke;
import org.testng.annotations.Test;

import java.io.IOException;

public class ShelvesServiceSmoke extends FixtureSmoke {

    @Test
    public void getShelves() throws IOException {
        client.shelvesService.getShelves().execute().body();
    }
}
