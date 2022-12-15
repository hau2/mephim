package com.example.mephim.service;

import com.example.mephim.entity.ShowDate;
import com.example.mephim.entity.ShowTime;
import com.example.mephim.response.ShowResponse;

import java.util.List;

public interface ShowDateService {
    List<ShowDate> findAll();
    List<ShowDate> findShowDateByTheaterId(Integer theaterId);
    List<ShowDate> findShowDateByMovieId(Integer movieId);
    List<ShowTime> adminFindAllShow();
    ShowDate findShowDateById(Integer showDateId);
}
