package com.dbudim.client.wrappers;

import com.dbudim.client.BookStackRestClient;
import com.dbudim.client.models.Book;
import com.dbudim.client.models.Shelve;

import java.util.List;

import static com.dbudim.utils.ExecutionUtils.execute;

/**
 * Note: This is a placeholder class and does not contain actual implementation.
 */

public class ShelvesApi {

    private BookStackRestClient client;

    public ShelvesApi(BookStackRestClient client) {
        this.client = client;
    }

    public Shelve createShelve(String name, List<Book> books) {
        return execute(client.shelvesService.createShelve(new Shelve(name, books))).body();
    }

}
