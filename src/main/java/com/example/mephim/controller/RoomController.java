package com.example.mephim.controller;

import com.example.mephim.constants.Constants;
import com.example.mephim.entity.RoomTicket;
import com.example.mephim.repos.RoomRepo;
import com.example.mephim.repos.RoomTicketRepo;
import com.example.mephim.response.CustomResponse;
import com.example.mephim.response.RoomSeatRes;
import com.example.mephim.response.RoomStruct;
import com.example.mephim.service.RoomService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
@CrossOrigin("*")
public class RoomController {

    @Autowired
    RoomTicketRepo roomTicketRepo;
    @Autowired
    RoomService roomService;

    @GetMapping("/find")
    public ResponseEntity<?> addBooking(@RequestParam(name = "showDateId") Integer showDateId,
                                        @RequestParam(name = "showTimeId") Integer showTimeId,
                                        @RequestParam(name = "ticketId") Integer ticketId) {

        List<RoomSeatRes> roomSeat = roomService.findRoomSeatByShowDateAndShowTimeTicket(showDateId, showTimeId, ticketId);
        RoomTicket roomTicket = roomTicketRepo.findByTicketId(ticketId);
        JSONObject dataResponseJson=new JSONObject();
        if(roomTicket != null) {
            dataResponseJson.put("room", roomTicket.getRoom());
        }
        dataResponseJson.put("roomSeat", roomSeat);
        return new ResponseEntity<>(new CustomResponse<>(0,Constants.RESPONSE_STATUS_SUCCESS,dataResponseJson), HttpStatus.CREATED);
    }

    @GetMapping("/find-room-struct")
    public ResponseEntity<?> getRoomStruct(@RequestParam(name = "roomId") Integer roomId) {
        RoomStruct roomStruct = roomService.getRoomStruct(roomId);
        return new ResponseEntity<>(roomStruct, HttpStatus.OK);

    }
}
