package ru.mirea.markinaa.superherodb;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class SuperHero {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String name;
    public String superpower;
}
