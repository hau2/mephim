package com.example.mephim.service.impl;

import com.example.mephim.entity.Seat;
import com.example.mephim.repos.SeatRepo;
import com.example.mephim.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class SeatServiceImpl implements SeatService {

    @Autowired
    SeatRepo seatRepo;
    @Override
    public void save(Seat seat) {
        seatRepo.save(seat);
    }

    @Override
    public Seat findSeatByTicketIdAndSeatId(Integer ticketId, Integer seatId) {
        return seatRepo.findSeatByTicketIdAndSeatId(ticketId, seatId);
    }
}
