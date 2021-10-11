package com.panaskin.cacheapp.dao;

import com.panaskin.cacheapp.entity.Film;
import com.panaskin.cacheapp.entity.Ticket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TicketDaoIT {
    @Autowired
    private TicketDao ticketDao;

    @Test
    public void shouldCreateTicket(){
        Ticket ticket = new Ticket();
        ticket.setRow(2);
        ticketDao.addTicket(ticket);
        Assertions.assertEquals(ticketDao.getTicket(ticket.getUuid().toString()), ticket);
    }

    @Test
    public void shouldDeleteTicket(){
        Ticket ticket = new Ticket();
        ticket.setSeat(22);
        ticketDao.addTicket(ticket);
        Assertions.assertNotNull(ticketDao.getTicket(ticket.getUuid().toString()));
        ticketDao.deleteTicket(ticket);
        Assertions.assertNull(ticketDao.getTicket(ticket.getUuid().toString()));
    }
}
