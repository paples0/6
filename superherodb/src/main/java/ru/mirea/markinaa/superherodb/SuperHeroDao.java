package ru.mirea.markinaa.superherodb;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SuperHeroDao {
    @Query("SELECT * FROM superHero")
    List<SuperHero> getAll();
    @Query("SELECT * FROM superHero WHERE id = :id")
    SuperHero getById(long id);
    @Insert
    void insert(SuperHero superHero);
    @Update
    void update(SuperHero superHero);
    @Delete
    void delete(SuperHero superHero);
}