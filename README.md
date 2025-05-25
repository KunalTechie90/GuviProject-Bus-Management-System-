# Simple Bus Booking System

A **Java-based command-line application** that provides a streamlined and user-friendly bus ticket booking experience. This system allows users to book tickets, cancel them with a fair refund policy, and view all existing bookings in an organized manner.

## Overview

This project demonstrates practical use of core Java programming concepts, including:

- Object-Oriented Design  
- Collections Framework (`ArrayList`)  
- Date and Time API (`java.time`)  
- Exception Handling  
- User Input Validation  

The system manages ticket bookings with unique IDs, calculates fares based on seat types (Normal or VIP), and enforces cancellation policies with dynamic refund calculations.

## Key Features

- **Intuitive Ticket Booking:**  
  Input journey details such as pickup and drop stations, travel date/time, and seat preferences to book tickets seamlessly.

- **Robust Cancellation Mechanism:**  
  Tickets can be canceled by their unique IDs with an automated refund process. Full refunds apply for cancellations made at least 24 hours before the journey; late cancellations incur a penalty fee.

- **Comprehensive Ticket Management:**  
  View all tickets along with detailed journey information and current status (active/canceled).

- **Input Validation & Error Handling:**  
  Ensures correct date formats and valid seat selections, enhancing user experience and system reliability.

## Technologies & Concepts Utilized

- Java 8+  
- `java.time.LocalDateTime` and `Duration` for precise date/time calculations  
- `ArrayList` for dynamic ticket storage  
- Console-based I/O using `Scanner`  
- Clean, modular code with well-defined classes and methods

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher installed  
- Command line or IDE for compiling and running Java programs

### Installation

1. Clone this repository:  
   ```bash
   git clone https://github.com/yourusername/SimpleBusBookingSystem.git
