package com.example.mergulhaoanimeroom;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Anime.class}, version = 1, exportSchema = false)
public abstract class AnimeDatabase extends RoomDatabase {

    public abstract AnimeDAO animeDao();

}
