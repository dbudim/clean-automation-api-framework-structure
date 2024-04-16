package com.dbudim.some_examples.builder;

import com.dbudim.client.models.Shelve;
import com.dbudim.client.models.User;
import com.dbudim.fixtures.FixtureSmoke;
import org.testng.annotations.Test;

import java.util.List;

import static com.dbudim.utils.ExecutionUtils.execute;

public class UsageExample extends FixtureSmoke {

    @Test
    public void createShelveWithConstructor() {
        Shelve shelve = new Shelve("My Shelve",
                "my-shelve",
                "Sample shelve",
                "2023-12-25",
                "2023-12-26",
                new User(),
                new User(),
                new User(),
                List.of());
        execute(client.shelvesService.createShelve(shelve));
    }

    @Test
    public void createShelveWithBuilder() {
        Shelve shelve = new Shelve.Builder()
                .withName("My Shelve")
                .withSlug("sadasd")
                .build();

        execute(client.shelvesService.createShelve(shelve));
    }
}
