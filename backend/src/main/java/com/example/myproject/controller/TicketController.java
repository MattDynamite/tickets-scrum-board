package com.example.myproject.controller;

import com.example.myproject.model.Ticket;
import com.example.myproject.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {
        return ResponseEntity.ok(ticketService.createTicket(ticket));
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/stage/{workflowStage}")
    public ResponseEntity<List<Ticket>> getTicketsByWorkflowStage(@PathVariable String workflowStage) {
        return ResponseEntity.ok(ticketService.getTicketsByWorkflowStage(workflowStage));
    }
}