package fr.uavignon.ceri.tp2.data;

public @interface Database {
    Class<Book>[] entities();

    int version();
}
