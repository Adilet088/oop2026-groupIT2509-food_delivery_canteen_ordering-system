# Food Delivery / Canteen Ordering System

## Project Topic
Ordering system for a canteen or food delivery service with menu management and order lifecycle tracking.

Course: Object Oriented Programming (Java)  
Assignment: Endterm Project Defense  

---

## Main Features

• View available menu items (Lambda filtering & sorting)  
• Place order using Builder pattern  
• Select delivery type using Factory pattern  
• Apply tax using Singleton configuration  
• View active orders  
• Complete order (status changes from ACTIVE → COMPLETED)

---

## Technologies

• Java  
• JDBC  
• PostgreSQL (Supabase)  
• IntelliJ IDEA  

---

## Database Schema

Tables:

• customers  
• menu_items  
• orders  
• order_items  

Relationships:

• orders.customer_id → customers.id  
• order_items.order_id → orders.id  
• order_items.menu_item_id → menu_items.id  

Constraints:

• price > 0  
• quantity > 0  
• status: ACTIVE / COMPLETED  
• foreign keys with proper relations  

---

## Architecture (Components)

### UI Component
• Main (console interaction)

### Business Component
• OrderService  
• MenuService  
• PaymentService  
• Builder (PlaceOrderRequest)  
• Factory (DeliveryFactory)  
• Singleton (TaxConfig)

### Domain Component
• Entities (Customer, MenuItem, Order, OrderItem)  
• Repository Interfaces  

### Persistence Component
• Repository Implementations  
• JDBC  
• DatabaseConnection  

Dependency direction:

UI → Business → Domain  
           ↓  
      Persistence  

Domain does NOT depend on database implementation.

---

## Design Patterns Used

• Singleton – TaxConfig  
• Builder – PlaceOrderRequest  
• Factory – DeliveryFactory  

---

## How to Run

1. Setup PostgreSQL database (Supabase or local PostgreSQL)
2. Run SQL schema to create tables
3. Update DatabaseConnection credentials
4. Run Main.java

---

## Team Members

Daniyar (GitHub: iamadolphinn)  
Adilet (GitHub: Adilet088)





