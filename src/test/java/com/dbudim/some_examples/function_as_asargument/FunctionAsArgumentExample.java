package com.dbudim.some_examples.function_as_asargument;

import com.dbudim.client.models.Book;
import com.dbudim.fixtures.FixtureSmoke;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FunctionAsArgumentExample extends FixtureSmoke {

    @Test
    public void smell() throws IOException {
        assertEquals(client.booksService.getBooks().execute().body().data.size(), 1, "books count doesn't match");
    }

    @Test
    public void well() throws IOException {
        List<Book> books = client.booksService.getBooks().execute().body().data;
        assertEquals(books.size(), 1, "books count doesn't match");
    }
}
