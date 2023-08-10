Database Schema:
Design your database schema to represent products, pricing history, and campaign information.

Product Table:

    id (Primary Key)
    name
    description
    base_price

Pricing History Table:

    id (Primary Key)
    product_id (Foreign Key to Product)
    price
    start_date
    end_date

Campaign Table:

    id (Primary Key)
    name
    start_date
    end_date
    discount_percentage

API Endpoints:
Design and implement APIs to interact with your database. You can use Spring Boot to create these APIs.

Product API Endpoints:

    GET /products: Get all products and their information.
    GET /products/{productId}/pricing-history: Get pricing history of a specific product.

Campaign API Endpoints:

    GET /campaigns: Get all campaign information.
    GET /campaigns/past: Get past campaigns.
    GET /campaigns/current: Get current campaign(s).
    GET /campaigns/upcoming: Get upcoming campaigns.

Business Logic:
Implement the business logic to adjust prices dynamically during campaign periods.

    When a campaign is active, apply the specified discount percentage to the base price of products.
    Maintain pricing history records in the database whenever a price change occurs.
    When querying pricing history, return a chronological list of price changes for each product.

Data Access:
Use Spring Data JPA to interact with the database. Create repositories for each entity (Product, Pricing History, Campaign).

Controller and Service Layer:
Create controllers to handle API requests and delegate business logic to service classes.

Testing:
Test your APIs to ensure they return the expected data. Test scenarios with different campaign states (past, current, upcoming) and pricing adjustments.