package com.panaskin.cacheapp.dao;

import com.panaskin.cacheapp.entity.Ticket;

public interface TicketDao {
    void addTicket(Ticket ticket);
    void updateTicket(String ticketId, Ticket ticket);
    void deleteTicket(Ticket ticket);
    Ticket getTicket(String ticketId);
}
