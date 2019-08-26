package com.example.mergulhaoanimeroom;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface AnimeDAO {

    @Insert
    void insert(Anime... anime);

    @Query("SELECT * FROM anime")
    List<Anime> getAnimes();

}
